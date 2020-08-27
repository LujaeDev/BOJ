#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

int main(void) {
	int cnt = 0, minCnt = 1000;
	string A, B;

	cin >> A >> B;

	for (int i = 0; i <= B.size() - A.size(); i++) {
		cnt = 0;

		for (int j = 0; j < A.size(); j++)
			if (A[j] != B[i + j])
				cnt++;
		
		minCnt = min(minCnt, cnt);
	}

	cout << minCnt;
	return 0;
}
