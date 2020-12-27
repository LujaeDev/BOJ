#include<iostream>
#include<algorithm>
#include<cstring>

using namespace std;

int arr[500][500], cache[500][500];

int MaxPath(int y, int x, int num) {
	int &ret = cache[y][x];

	if (y == num - 1)
		return arr[y][x];
	else if (ret != -1)
		return ret;

	return ret = arr[y][x] + max(MaxPath(y + 1, x, num), MaxPath(y + 1, x + 1, num));
}
int main(void) {
	int num;

	scanf("%d", &num);

	for (int i = 0; i < num; i++)
		for (int j = 0; j <= i; j++)
			scanf("%d", &arr[i][j]);

	memset(cache, -1, sizeof(cache));
	cout << MaxPath(0,0, num);
	return 0;
}
