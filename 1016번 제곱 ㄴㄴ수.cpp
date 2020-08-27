//#include<iostream>
//#include<algorithm>
//#include<math.h>
//#include<cstring>
//
//using namespace std;
//
//long long arr[1000000];
//int prime[1000005];
//
//int cnt(int size) {
//	int c = 0;
//
//	for (int i = 0; i < size; i++)
//		if (arr[i] != 0)
//			c++;
//
//	return c;
//}
//
//int main(void) {
//	long long in, ax, pos;
//	int size, priSize = 0;
//
//	cin >> in >> ax;
//	size = ax - in + 1;
//
//	for (int i = 0; i < size; i++)
//		arr[i] = in + i;
//
//	for (long long i = 1; i * i <= ax; i++) {
//		prime[i-1] = i;
//	}
//	priSize = sqrt(ax);
//
//	prime[0] = 0;
//
//	for (long long i = 2; i * i <= ax; i++) {
//		int pos = i * 2 - 1;
//
//		if (pos >= priSize || prime[pos] == 0)
//			continue;
//
//		for (int j = pos; j < priSize; j += i)
//			prime[j] = 0;
//	}
//
//	for (int i = 0; i < priSize; i++) {
//		if (prime[i] == 0)
//			continue;
//		long long a = pow(prime[i], 2);
//		pos = in % a == 0 ? 0 : a - in % a;
//
//		if (pos >= size)
//			continue;
//
//		for (long long j = pos; j < size; j += a)
//			arr[j] = 0;
//	}
//
//
//	cout << cnt(size);
//	return 0;
//}