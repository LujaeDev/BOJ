#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>

//548ÀÏ¶§ ¹®Á¦
using namespace std;
int num[54774];

int getCnt(int num, const vector<int>& prime) {
	int idx = 0, cnt = 0;
	vector<int> v;

	while (idx < prime.size() && prime[idx] * prime[idx] < num) {
		int a = prime[idx] * prime[idx];

		cnt += (num - 1) / a;

		for (int i = 0; i < v.size(); i++) {
			int overlap = ((int)(num - 1) / a ) / v[i];
			
			if (overlap == 0)
				break;

			cnt -= overlap;
		}

		v.push_back(a);
		idx++;
	}

	return cnt;
}

int solve(int start, int K, const vector<int>& prime) {
	int end = start + K;
	int idx = 0, cnt = 0;

	cnt = getCnt(end, prime) - getCnt(start, prime);

	if (cnt == 0)
		return end - 1;

	return solve(end, cnt, prime);
}

int main(void) {
	int idx = 0, cnt = 0;
	vector<int> prime;
	long long K;
	cin >> K;
	//K = 1000000000;
	for (long long i = 2; i * i <= (3 * K); i++)
		num[i] = i;
	
	for (long long i = 2; i * i <= (3 * K); i++) {
		if (num[i] == 0)
			continue;

		prime.push_back(num[i]);

		for (long long j = i * 2; j * j <= (3 * K); j += i)
			num[j] = 0;
	}

	cout << solve(1, K, prime);
	/*for (int i = 1; i <= 1000; i++)
		cout << i << " " << solve(1, i, prime) << endl;*/
	return 0;
}
