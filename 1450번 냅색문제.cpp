#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int search(vector<long long>& v, vector<int>& w, long long currentW, int C, int idx) {
	if (idx == w.size()) {		
		if (currentW <= C)
			if (currentW != 0)
				v.push_back(currentW);
		return currentW <= C;
	}

	int ret = 0;

	ret = search(v, w, currentW, C, idx + 1) + search(v, w, currentW + w[idx], C, idx + 1);

	return ret;
}

int main(void) {
	long long N, C, cnt = 0;
	vector<int> w, w1, w2;
	vector<long long> v1, v2;
	cin >> N >> C;

	for (int i = 0; i < N; ++i) {
		int tmp;
		cin >> tmp;
		w.push_back(tmp);
	}

	sort(w.begin(), w.end());
	
	w1 = vector<int>(w.begin(), w.begin() + w.size() / 2);
	w2 = vector<int>(w.begin() + w.size() / 2, w.end());

	cnt += search(v1, w1, 0, C, 0);
	cnt += search(v2, w2, 0, C, 0);
	cnt--;

	sort(v1.begin(), v1.end());
	sort(v2.begin(), v2.end());

	for (int i = 0; i < v1.size(); ++i) {
		int plus = v2.size();

		for (int j = v2.size() - 1; j >= 0; --j)
			if (v1[i] + v2[j] <= C)
				break;
			else
				plus--;

		if (plus == 0)
			break;

		cnt += plus;
	}

	cout << cnt;
	return 0;
}
