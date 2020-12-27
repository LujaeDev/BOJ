#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>

using namespace std;
int height[300][300];
int adjacentCnt0[300][300];
bool visited[300][300];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, -1, 0, 1 };

bool isRange(int y, int x, int N, int M) {
	return (y >= 0 && y < N) && (x >= 0 && x < M);
}

int sumAllH(int N, int M) {
	int sum = 0;

	for (int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j)
			sum += height[i][j];
	
	return sum;
}

void dfs(int hereY, int hereX, int N, int M) {
	visited[hereY][hereX] = true;

	for (int i = 0; i < 4; ++i) {
		int thereY = hereY + dy[i];
		int thereX = hereX + dx[i];

		if (isRange(thereY, thereX, N, M) && height[thereY][thereX] && !visited[thereY][thereX])
			dfs(thereY, thereX, N, M);
	}

	return;
}

void update(int N, int M) {

	for(int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j) {
			adjacentCnt0[i][j] = 0;

			for (int idx1 = 0; idx1 < 4; ++idx1)
				if (isRange(i + dy[idx1], j + dx[idx1], N, M) && !height[i + dy[idx1]][j + dx[idx1]])
					adjacentCnt0[i][j]++;
		}

	for(int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j) {
			height[i][j] -= adjacentCnt0[i][j];
			if (height[i][j] < 0)
				height[i][j] = 0;
		}
}

int solve(int N, int M) {
	int ret = 0, j;

	while (sumAllH(N, M)) {
		update(N, M);
		ret++;

		memset(visited, false, sizeof(visited));

		for (int i = 0; i < N; ++i) {
			for (j = 0; j < M; ++j)
				if (height[i][j] != 0) {
					dfs(i, j, N, M);
					break;
				}

			if (j < M)
				break;
		}

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < M; ++j)
				if (height[i][j] && visited[i][j] == false)
					return ret;
	}

	return 0;
}

int main(void) {
	int N, M;

	cin >> N >> M;

	for (int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j)
			scanf("%d", &height[i][j]);

	cout << solve(N ,M);
	return 0;
}
