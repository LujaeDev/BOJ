#include<iostream>
#include<algorithm>
using namespace std;

int Cnt(char(* arr)[51], char first, int y, int x) {
	char tmp = first;
	int cnt = 0;

	for (int i = y; i < y + 8; i++)
		for (int j = x; j < x + 8; j++) {
			if (tmp != arr[i][j])
				cnt++;
			if (j == x + 7)
				continue;
			if (tmp == 'B')
				tmp = 'W';
			else
				tmp = 'B';
		}

	return cnt;
}
int main(void) {
	int r, c, ret = 100000;
	char arr[50][51];

	scanf("%d %d", &r, &c);
	
	for (int i = 0; i < r; i++){
		scanf("%s", arr[i]);
	}

	for(int i = 0; i <= r - 8; i++)
		for (int j = 0; j <= c - 8; j++) {
			ret = min(ret, Cnt(arr, 'B', i, j));
			ret = min(ret, Cnt(arr, 'W', i, j));
		}

	printf("%d", ret);
	return 0;
}
