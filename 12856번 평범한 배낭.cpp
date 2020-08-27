//#include<iostream>
//#include<algorithm>
//#include<cstring>
//
//using namespace std;
//
//int cache[100001][101],w[100], v[100];
//
//int solve(int currentW, int idx, int N, int K) {
//	if (currentW > K)
//		return -987654321;
//
//	int& ret = cache[currentW][idx + 1];
//
//	if (ret != -1)
//		return ret;
//
//	ret = 0;
//
//	for (int next = idx + 1; next < N; next++)
//		ret = max(ret, v[next] + solve(currentW + w[next], next, N, K));
//
//	return ret;
//}
//
//int main(void) {
//	int N, K;
//
//	cin >> N >> K;
//	for (int i = 0; i < N; i++)
//		cin >> w[i] >> v[i];
//
//	memset(cache, -1, sizeof(cache));
//
//	cout << solve(0, -1, N, K);
//	return 0;
//}