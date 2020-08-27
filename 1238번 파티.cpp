//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<queue>
//#define INF 987654321
//using namespace std;
//
//vector<vector<pair<int, int>>> adj;
//
//vector<int> dijstra(int start, int N) {
//	vector<int> dist(N + 1, INF);
//	priority_queue<pair<int, int>> pq;
//
//	dist[start] = 0;
//	pq.push(make_pair(0, start));
//
//	while (!pq.empty()) {
//		int here = pq.top().second;
//		int cost = -pq.top().first;
//		pq.pop();
//
//		if (dist[here] < cost)
//			continue;
//
//		for (int i = 0; i < adj[here].size(); i++) {
//			int there = adj[here][i].first;
//			int nextDist = adj[here][i].second + cost;
//
//			if (dist[there] > nextDist) {
//				dist[there] = nextDist;
//				pq.push(make_pair(-nextDist, there));
//			}
//		}
//	}
//
//	return dist;
//}
//
//int solve(int N, int X) {
//	vector<int> go, back = dijstra(X, N);
//	int ret = 0;
//
//	for (int i = 1; i <= N; ++i) {
//		if (i != X) {
//			go = dijstra(i, N);
//			ret = max(go[X] + back[i], ret);
//		}
//	}
//
//	return ret;
//}
//int main(void) {
//	int N, X, M, T, from, to;
//
//	cin >> N >> M >> X;
//
//	adj = vector<vector<pair<int, int>>>(N + 1);
//
//	for (int i = 0; i < M; i++) {
//		cin >> from >> to >> T;
//
//		adj[from].push_back(make_pair(to, T));
//	}
//
//	cout << solve(N, X);
//	return 0;
//}