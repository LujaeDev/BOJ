#include<iostream>
#include<vector>
#include<string>
#include<algorithm>

using namespace std;

void Cal(string s, int* idx_0, int* idx_1){
	char prev = s[0];

	for (string::iterator it = s.begin(); it != s.end(); it++) {
		if (*it != prev) {
			if (prev == '0')
				(*idx_0)++;
			else
				(*idx_1)++;
		}
		if(it + 1 == s.end())
			if (*it == '0')
				(*idx_0)++;
			else
				(*idx_1)++;
		prev = *it;
	}
}

int Cor(string s) {
	char prev = s[0];
	for (string::iterator it = s.begin(); it != s.end(); it++) {
		if (*it != prev)
			return 0;
		prev = *it;
	}

	return 1;
}
int main(void) {
	string s;
	int idx_0 = 0, idx_1 = 0;
	cin >> s;

	if (Cor(s))
		printf("0");
	else {
		Cal(s, &idx_0, &idx_1);
		printf("%d", min(idx_0, idx_1));
	}
	return 0;
}
