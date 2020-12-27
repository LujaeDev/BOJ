#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int Func1(int* arr, int* op, int *cnt, int current, int idx, int num) {
	int ret = -1000000095;
	if (idx == num)
		return current;
	for (int i = 0; i < 4; i++) {
		if (op[i] > cnt[i]) {
			cnt[i]++;
			if(i == 0)
				ret = max(ret, Func1(arr, op, cnt, current + arr[idx], idx + 1, num));
			else if (i == 1)
				ret = max(ret, Func1(arr, op, cnt, current - arr[idx], idx + 1, num));
			else if (i == 2)
				ret = max(ret, Func1(arr, op, cnt, current * arr[idx], idx + 1, num));
			else
				ret = max(ret, Func1(arr, op, cnt, current / arr[idx], idx + 1, num));

			cnt[i]--;
		}
	}

	return ret;
}
int Func2(int* arr, int* op, int* cnt, int current, int idx, int num) {
	int ret = 1000000095;
	if (idx == num)
		return current;

	for (int i = 0; i < 4; i++) {
		if (op[i] > cnt[i]) {
			cnt[i]++;

			if (i == 0)
				ret = min(ret, Func2(arr, op, cnt, current + arr[idx], idx + 1, num));
			else if (i == 1)
				ret = min(ret, Func2(arr, op, cnt, current - arr[idx], idx + 1, num));
			else if (i == 2)
				ret = min(ret, Func2(arr, op, cnt, current * arr[idx], idx + 1, num));
			else
				ret = min(ret, Func2(arr, op, cnt, current / arr[idx], idx + 1, num));

			cnt[i]--;
		}
	}

	return ret;
}
int main(void) {
	int num, arr[11], op[4], cnt[4] = {0};
	int Max, Min;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) 
		scanf("%d", &arr[i]);
	
	for (int i = 0; i < 4; i++)
		scanf("%d", &op[i]);

	printf("%d\n", Func1(arr, op, cnt, arr[0], 1, num));
	printf("%d", Func2(arr, op, cnt, arr[0], 1, num));
	return 0;
}
