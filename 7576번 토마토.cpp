//#include<iostream>
//#include<algorithm>
//#include<vector>
//
//using namespace std;
//
//vector<vector<int>> adj;
//vector<bool> visited;
//int N, M, arr[1000][1000];
//int direction[4][2] = { {0, 1 }, {-1, 0}, {0, -1}, {1 , 0} };
//
//bool check(int y, int x) {
//	return !(y < 0 || x < 0 || y >= N || x >= M) && arr[y][x] == 0;
//}
//
//void DFS(int here, vector<int>& pos) {
//	visited[here] = true;
//
//	if (arr[here / M][here % M] == 0) {
//		arr[here / M][here % M] = 1;
//		pos.push_back(here);
//		return;
//	}
//
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (!visited[there])
//			DFS(there, pos);
//	}
//}
//
//bool hasNoZero() {
//	for (int i = 0; i < N; i++)
//		for (int j = 0; j < M; j++)
//			if (arr[i][j] == 0)
//				return false;
//
//	return true;
//}
//
//int solve() {
//	int day = 0;
//	vector<int> pos, beforePos;
//	visited = vector<bool>(N * M, false);
//
//	for (int i = 0; i < N; i++)
//		for (int j = 0; j < M; j++)
//			if (arr[i][j] == 1) {
//				pos.push_back(i * M + j);
//				visited[i * M + j] = true;
//			}
//
//	while (!pos.empty()) {
//		day++;
//		beforePos = pos;
//		pos.clear();
//		for (int i = 0; i < beforePos.size(); i++)
//			DFS(beforePos[i], pos);
//	}
//
//	if (hasNoZero())
//		return day - 1;
//	else
//		return -1;
//}
//
//int main(void) {
//	
//	cin >> M >> N;
//
//	for (int i = 0; i < N; i++)
//		for (int j = 0; j < M; j++)
//			cin >> arr[i][j];
//
//	adj = vector<vector<int>>(N * M);
//
//	for(int i = 0; i < N; i++)
//		for (int j = 0; j < M; j++) {
//			if (arr[i][j] != -1) {
//				int here = i * M + j;
//				for (int k = 0; k < 4; k++) {
//					int thereY = i + direction[k][0];
//					int thereX = j + direction[k][1];
//
//					if (check(thereY, thereX)) {
//						int there = thereY * M + thereX;
//
//						adj[here].push_back(there);
//						adj[there].push_back(here);
//					}
//				}
//			}
//		}
//
//	cout << solve();
//	return 0;
//}