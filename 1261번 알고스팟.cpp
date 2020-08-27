//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<queue>
//#define INF 987654321
//using namespace std;
//
//int dx[4] = { 1, 0, -1, 0 }, dy[4] = {0, -1, 0, 1};
//vector < vector<pair<int, int>>> adj(10000);
//string arr[100];
//
//bool isRange(int x, int y, int N, int M) {
//	return x >= 0 && y >= 0 && x < M && y < N;
//}
//
//void makeG(int M, int N) {
//	for(int i =0 ;i < N; i++)
//		for(int j =0; j < M; j++)
//			for(int idx = 0; idx < 4; ++idx)
//				if (isRange(j + dx[idx], i + dy[idx], N , M)) 
//					adj[i * M + j].push_back(make_pair(((i + dy[idx]) * M + j + dx[idx]), arr[i + dy[idx]][j + dx[idx]] - '0'));
//}
//
//vector<int> dijkstra(int start, int N, int M) {
//	vector<int> dist(N * M, INF);
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
//			int nextDist = dist[here] + adj[here][i].second;
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
//int solve(int N, int M) {
//	makeG(M, N);
//	vector<int> ret = dijkstra(0, N, M);
//
//	return ret[M * (N - 1) + M - 1];
//}
//
//int main(void) {
//	int M, N;
//
//	cin >> M >> N;
//
//	for (int i = 0; i < N; i++)
//		cin >> arr[i];
//
//	cout << solve(N, M);
//	return 0;
//}