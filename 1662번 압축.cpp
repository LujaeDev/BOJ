#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int solve(const string& s, int* idx) {
	int ret = 0;

	while (*idx < s.size()) {
		if (s[*idx + 1] == '(') {
			int tmp = s[*idx] - '0';
			*idx += 2;
			ret += tmp * solve(s, idx);
		}
		else if (s[*idx] == ')') {
			*idx += 1;
			return ret;
		}
		else {
			*idx += 1;
			ret += 1;
		}
	}

	return ret;
}

int main(void) {
	string s;
	int idx = 0;
	cin >> s;

	cout << solve(s, &idx);
	return 0;
}
