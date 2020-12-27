#include<iostream>

using namespace std;

int Array_CntDigit[10];

int Over_0() {
	for (auto i : Array_CntDigit)
		if (i > 0)
			return 1;
	return 0;
}

void Decrease() {
	for (auto &i : Array_CntDigit)
		i -= 1;
	
	Array_CntDigit[6] -= 1;
}

int main(void) {
	int num, ret = 0;

	cin >> num;

	while (1) {
		Array_CntDigit[num % 10] += 1;
		num /= 10;
		if (num == 0)
			break;
	}

	Array_CntDigit[6] += Array_CntDigit[9];
	Array_CntDigit[9] = 0;

	while (Over_0()) {
		ret += 1;
		Decrease();
	}

	cout << ret;
	return 0;
}
