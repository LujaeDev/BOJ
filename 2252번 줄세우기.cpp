//#include<iostream>
//#include<algorithm>
//#include<vector>
//using namespace std;
//
//vector<vector<int>> adj;
//vector<bool> visited;
//
//
//void dfs(int here, vector<int>& order) {
//	visited[here] = true;
//
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (!visited[there])
//			dfs(there, order);
//	}
//	order.push_back(here);
//}
//
//void solve() {
//	vector<int> order;
//
//	visited = vector<bool>(adj.size(), false);
//
//	for (int i = 1; i < adj.size(); i++)
//		if (!visited[i])
//			dfs(i, order);
//
//	for (int i = order.size() - 1; i >= 0; i--)
//		printf("%d ", order[i]);
//}
//int main(void) {
//	int N, M, a, b;
//	cin >> N >> M;
//	
//	adj = vector<vector<int>>(N + 1);
//
//	for (int i = 0; i < M; i++) {
//		scanf("%d %d", &a, &b);
//
//		adj[a].push_back(b);
//	}
//
//	solve();
//	return 0;
//}