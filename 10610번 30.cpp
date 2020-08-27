//#include<iostream>
//#include<string>
//using namespace std;
//
//int main(void) {
//	string  n;
//	int digits[10] = { 0 }, digitSum = 0;
//
//	cin >> n;
//
//	for (int i = 0; i < n.size(); i++) {
//		digits[n[i] - '0']++;
//		digitSum += (n[i] - '0');
//	}
//
//	if (digitSum % 3 != 0 || digits[0] == 0)
//		cout << -1;
//	else{
//		for (int i = 9; i >= 0; i--)
//			for (int j = digits[i]; j > 0; j--)
//				printf("%d", i);
//	}
//
//	return 0;
//}