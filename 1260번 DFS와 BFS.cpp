//#include<iostream>
//#include<vector>
//#include<queue>
//#include<algorithm>
//
//using namespace std;
//
//vector<vector<int>> adj;
//vector<bool> visited, discovered;
//vector<int> d, b;
//
//void dfs(int here) {
//	visited[here] = true;
//	d.push_back(here);
//
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (!visited[there])
//			dfs(there);
//	}
//}
//
//void bfs(int v) {
//	queue<int> q;
//	q.push(v);
//	discovered[v] = true;
//
//	while (!q.empty()) {
//		int here = q.front();
//		q.pop();
//		b.push_back(here);
//
//		for (int i = 0; i < adj[here].size(); i++) {
//			if (!discovered[adj[here][i]]) {
//				q.push(adj[here][i]);
//				discovered[adj[here][i]] = true;
//			}
//		}
//	}
//}
//
//void solve(int n, int v) {
//	visited = discovered = vector<bool>(n + 1, false);
//
//	dfs(v); bfs(v);
//
//	for (int i = 0; i < d.size(); i++)
//		cout << d[i] << " ";
//	cout << endl;
//	for (int i = 0; i < b.size(); i++)
//		cout << b[i] << " ";
//}
//int main(void) {
//	int n, m, v;
//
//	cin >> n >> m >> v;
//	adj = vector<vector<int>>(n + 1);
//
//	for (int i = 0; i < m; i++) {
//		int h, t;
//		cin >> h >> t;
//
//		adj[h].push_back(t);
//		adj[t].push_back(h);
//	}
//
//	for (int i = 1; i <= n; i++)
//		sort(adj[i].begin(), adj[i].end());
//
//	solve(n, v);
//	return 0;
//}