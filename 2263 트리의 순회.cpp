//#include<iostream>
//#include<algorithm>
//#include<vector>
//
//using namespace std;
//
//int in[100001], inIdx[100001];
//int post[100001], postIdx[100001];
//
//void preOrder(int start, int end) {
//	if (start >= end)
//		return;
//	
//	int maxIdx = postIdx[in[start]], next = in[start];
//	int nextIdx = start;
//
//	for (int i = start; i < end; i++) {
//		if (postIdx[in[i]] > maxIdx) {
//			maxIdx = postIdx[in[i]];
//			next = in[i];
//			nextIdx = i;
//		}
//	}
//
//	printf("%d ", next);
//	preOrder(start, nextIdx);
//	preOrder(nextIdx + 1, end);
//}
//int main(void) {
//	int N, tmp;
//
//	cin >> N;
//
//	for (int i = 0; i < N; i++) {
//		scanf("%d", &in[i]);
//		inIdx[in[i]] = i;
//	}
//	for (int i = 0; i < N; i++) {
//		scanf("%d", &post[i]);
//		postIdx[post[i]] = i;
//	}
//
//	preOrder(0, N);
//	return 0;
//}