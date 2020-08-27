//#include<iostream>
//#include<cmath>
//#include<algorithm>
//#define INF 987654321
//using namespace std;
//
//long double valueF(int A, int B, int C, double x) {
//	return A * x + B * sin(x) - C;
//}
//
//double solve(int A, int B, int C) {
//	long double hi = INF, lo = -INF, mid;
//	
//	for(int i = 0 ; i < 360; i++){
//		mid = (lo + hi) / 2;
//		if (valueF(A, B, C, mid) > 0)
//			hi = mid;
//		else
//			lo = mid;
//
//		mid = (hi + lo) / 2;
//	}
//
//	return (hi + lo) / 2;
//}
//
//int main(void) {
//	int A, B, C;
//	double tmp;
//	cin >> A >> B >> C;
//	
//	printf("%.6f", solve(A, B, C));
//
//	return 0;
//}