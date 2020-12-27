#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<map>

using namespace std;

vector<int> getPart(const string& N) {
	int begin = 1, matched = 0, m = N.size();
	vector<int> pi(m, 0);

	while (begin + matched < m) {
		if (N[begin + matched] == N[matched]) {
			matched++;
			pi[begin + matched - 1] = matched;
		}
		else {
			if (matched == 0)
				begin++;
			else {
				begin += matched - pi[matched - 1];
				matched = pi[matched - 1];
			}
		}
	}

	return pi;
}

vector<int> stringFind(const string& H, const string &N) {
	vector<int> pi = getPart(N), ret;
	int begin = 0, matched = 0, h = H.size(), n = N.size();

	while (begin <= h - n) {
		if (matched < n && H[begin + matched] == N[matched]) {
			matched++;
			if (matched == n)
				ret.push_back(begin);
		}
		else {
			if (matched == 0)
				begin++;
			else {
				begin += matched - pi[matched - 1];
				matched = pi[matched - 1];
			}
		}
	}

	return ret;
}

string convertW(const string&W, string& A2, int x) {
	map<char, string> m;
	string converted;
	int sizeA2 = A2.size(), sizeW = W.size();
	
	for (int i = 0; i < sizeA2 / 2; i++)
		m[A2[i]] = A2[i + x];

	for (int i = 0; i < sizeW; i++)
		converted += m[W[i]];

	return converted;
}

vector<int> solve(const string& A, const string& W, const string& S) {
	vector<int> vX, pos;
	string A2 = A + A, s, converted;
	int sizeA = A.size();

	for (int i = 0; i < sizeA; i++) {
		s = A2.substr(i, sizeA);

		converted = convertW(W, A2, i);

		pos = stringFind(S, converted);
		
		if (pos.size() == 1)
			vX.push_back(i);
	}

	sort(vX.begin(), vX.end());
	return vX;
}

int main(void) {
	int N;
	string A, W, S;
	cin >> N;
	while (N--) {
		cin >> A; cin >> W; cin >> S;

		vector<int> v = solve(A, W, S);

		if (v.size() == 0)
			cout << "no solution";
		else if (v.size() == 1)
			cout << "unique:";
		else
			cout << "ambiguous:";

		for (int i = 0; i < v.size(); i++)
			printf(" %d", v[i]);
		printf("\n");
	}
	return 0;
}
