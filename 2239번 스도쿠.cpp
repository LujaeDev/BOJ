#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<pair<int, int>> pos0;
int checkBox[3][3];
int checkRow[9];
int checkCol[9];
int board[9][9];

bool isFull() {
	for (int i = 0; i < 9; ++i)
		for (int j = 0; j < 9; ++j)
			if (board[i][j] == 0)
				return false;

	return true;
}

bool can(int y, int x, int num) {
	if ((checkRow[y] & (1 << num)) != 0)
		return false;
	if ((checkCol[x] & (1 << num)) != 0)
		return false;
	if ((checkBox[y / 3][x / 3] & (1 << num)) != 0)
		return false;

	return true;
}

void solve(int idx) {
	if (idx == pos0.size()) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j)
				printf("%d", board[i][j]);
			printf("\n");
		}

		exit(0);
	}

	int y = pos0[idx].first;
	int x = pos0[idx].second;

	for (int num = 1; num <= 9; ++num) {
		if (can(y, x, num)) {
			checkRow[y] |= (1 << num);
			checkCol[x] |= (1 << num);
			checkBox[y / 3][x / 3] |= (1 << num);
			board[y][x] = num;

			solve(idx + 1);

			checkRow[y] -= (1 << num);
			checkCol[x] -= (1 << num);
			checkBox[y / 3][x / 3] -= (1 << num);
		}
		
		board[y][x] = 0;
	}
}

int main(void) {
	char tmp;

	for (int i = 0; i < 9; ++i) {
		for (int j = 0; j < 9; ++j) {
			cin >> tmp;
			board[i][j] = tmp - '0';

			if (board[i][j] == 0)
				pos0.push_back(make_pair(i, j));

			checkRow[i] |= (1 << board[i][j]);
			checkCol[j] |= (1 << board[i][j]);
			checkBox[i / 3][j / 3] |= (1 << board[i][j]);
		}
	}

	solve(0);

	return 0;
}