////#include<iostream>
////#include<algorithm>
////#include<cstring>
////
////using namespace std;
////char cnt[1000000001];
////
////int ans(int w[], int currentWeight, int N, int C, int prev) {
////	if (prev == N - 1)
////		return currentWeight <= C;
////	int ret = 0;
////
////	ret = ans(w, currentWeight + w[prev + 1], N, C, prev + 1) + ans(w, currentWeight, N, C, prev + 1);
////	return ret;
////}
////
////int main(void) {
////	int N, C;
////	int w[30];
////
////	cin >> N >> C;
////
////	for (int i = 0; i < N; i++)
////		cin >> w[i];
////
////	cout << ans(w, 0, N, C, -1);
////	return 0;
////}
//
//#include<iostream>
//#include<algorithm>
//
//using namespace std;
//
//int w[30];
//
//int sum(int start, int end) {
//	int s = 0;
//
//	for (int i = start; i < end; i++)
//		s += w[i];
//	
//	return s;
//}
//
//int solve(int start, int end, int currentW) {
//	int mid = (start + end) / 2;
//	
//	solve(start, mid) + solve(mid, end);
//	return 0;
//}
//int main(void) {
//	int N, C;
//
//	cin >> N >> C;
//
//	for (int i = 0; i < N; i++)
//		cin >> w[i];
//
//	sort(w, w + N);
//	reverse(w, w + N);
//
//	cout << solve();
//}