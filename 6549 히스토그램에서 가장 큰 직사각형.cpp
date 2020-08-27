//#include<iostream>
//#include<algorithm>
//#include<stack>
//
//using namespace std;
//int h[100001];
//
//long long solve(int n) {
//	long long ret = 0;
//
//	stack<int> remain;
//	h[n] = 0;
//
//	for (int i = 0; i < n + 1; i++) {
//		while (!remain.empty() && h[remain.top()] >= h[i]) {
//			int idx = remain.top();
//			remain.pop();
//
//			int width = 0;
//
//			if (remain.empty())
//				width = i;
//			else
//				width = i - remain.top() - 1;
//			
//			ret = max(ret, (long long)h[idx] * width);
//		}
//
//		remain.push(i);
//	}
//	
//	return ret;
//}
//
//int main(void) {
//	int n = 1;
//
//	scanf("%d", &n);
//
//	while (n != 0) {
//		for (int i = 0; i < n; i++)
//			scanf("%d", &h[i]);
//		
//		printf("%lld\n", solve(n));
//		scanf("%d", &n);
//	}
//}