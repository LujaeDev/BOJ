//#include<iostream>
//#include<vector>
//#include<algorithm>
//#include<math.h>
//using namespace std;
//
//void Hanoi(int k, int from, int aux, int to) {
//	if (k == 1) {
//		cout << from << " " << to << "\n";
//		return;
//	}
//	
//	Hanoi(k - 1, from, to, aux);
//	cout << from << " " << to << "\n";
//	Hanoi(k - 1, aux, from, to);
//
//}
//int main(void) {
//	int k;
//
//	cin >> k;
//
//	cout << (int)pow(2, k) - 1 << endl;
//	Hanoi(k, 1, 2, 3);
//
//	return 0;
//}