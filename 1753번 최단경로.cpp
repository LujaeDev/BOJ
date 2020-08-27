//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<queue>
//using namespace std;
//#define INF 987654321
//
//vector<vector<pair<int, int>>> adj;
//
//vector<int> dijkstra(int start, int V) {
//	vector<int> dist(V + 1, INF);
//
//	priority_queue<pair<int, int>> pq;
//	dist[start] = 0;
//
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
//			int nextDist = cost + adj[here][i].second;
//
//			if (nextDist < dist[there]) {
//				pq.push(make_pair(-nextDist, there));
//				dist[there] = nextDist;
//			}
//		}
//	}
//
//	return dist;
//}
//void solve(int V, int start) {
//	vector<int> dist = dijkstra(start, V);
//
//	for (int i = 1; i <= V; i++)
//		if (dist[i] != INF)
//			printf("%d\n", dist[i]);
//		else
//			printf("INF\n");
//}
//int main(void) {
//	int V, E, start, from ,to, w;
//
//	cin >> V >> E;
//	cin >> start;
//
//	adj = vector<vector<pair<int, int>>>(V + 1);
//
//	for (int i = 0; i < E; i++) {
//		scanf("%d %d %d", &from, &to, &w);
//
//		adj[from].push_back(make_pair(to, w));
//	}
//	
//	solve(V, start);
//	return 0;
//}