#include<iostream>
#include<algorithm>
#include<cstdlib>

#define INF 987654321

using namespace std;

int Disabled[10];

int check(int num) {
	if (num == 0)
		return !Disabled[0];
	while (num > 0) {
		if (Disabled[num % 10])
			return 0;
		num /= 10;
	}

	return 1;
}

int numDigit(int num) {
	int cnt = 0;

	if (num == 0)
		return 1;
	while (num > 0) {
		cnt++;
		num /= 10;
	}

	return cnt;
}

int Sum() {
	int sum = 0;

	for (int i = 0; i < 10; i++)
		sum += Disabled[i];

	return sum;
}
int possibleVlauePlus(int num) {
	int ret = num;

	if (Sum() == 10)
		return INF;
	while (!check(ret) && ret - num < 500000)
		ret++;

	return ret;
}

int possibleVlaueMinus(int num) {
	int ret = num;

	if (Sum() == 10)
		return -INF;
	while (!check(ret) && ret != 0)
		ret--;

	if (check(ret))
		return ret;
	else
		return -INF;
}

int main(void) {
	int numDisabled, obj, tmp, cntButton = 0, cntOnlyOperate = 0;
	int valuePlus, valueMinus;

	cin >> obj;

	cin >> numDisabled;

	for (int i = 0; i < numDisabled; i++) {
		cin >> tmp;
		Disabled[tmp] = 1;
	}

	valuePlus = possibleVlauePlus(obj);
	valueMinus = possibleVlaueMinus(obj);

	cntButton = min(numDigit(valuePlus) + (valuePlus - obj), numDigit(valueMinus) + (obj - valueMinus));
	cntOnlyOperate = abs(obj - 100);

	cout << min(cntButton, cntOnlyOperate);

	return 0;
}
