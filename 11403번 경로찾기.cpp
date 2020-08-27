//#include<iostream>
//#include<algorithm>
//#include<cstring>
//#include<vector>
//
//using namespace std;
//
//int arr[100][100];
//int adj[100][100];
//bool visited[100];
//
//void DFS(int here, int N, bool first) {
//	if(!first)
//		visited[here] = true;
//
//	for (int i = 0; i < N; i++) {
//		if (adj[here][i] == 1 && !visited[i])
//			DFS(i, N, false);
//	}
//}
//void solve(int N) {
//	for (int i = 0; i < N; i++) {
//		memset(visited, false, sizeof(visited));
//		DFS(i, N, true);
//		for (int j = 0; j < N; j++)
//			if (visited[j])
//				cout << "1 ";
//			else
//				cout << "0 ";
//		cout << endl;
//	}
//}
//int main(void) {
//	int N;
//
//	cin >> N; 
//
//	for (int i = 0; i < N; i++)
//		for (int j = 0; j < N; j++) {
//			cin >> arr[i][j];
//
//			if (arr[i][j] == 1) {
//				adj[i][j] = 1;
//			}
//		}
//
//
//	solve(N);
//	return 0;
//}