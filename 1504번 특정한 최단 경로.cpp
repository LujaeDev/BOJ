#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#define INF 987654321
using namespace std;

vector<vector<pair<int, int>>> adj;

vector<int> dijstra(int start, int N) {
	vector<int> dist(N + 1, INF);
	priority_queue<pair<int, int>> pq;

	dist[start] = 0;
	pq.push(make_pair(0, start));

	while (!pq.empty()) {
		int here = pq.top().second;
		int cost = -pq.top().first;
		pq.pop();

		if (dist[here] < cost)
			continue;
		
		for (int i = 0; i < adj[here].size(); ++i) {
			int there = adj[here][i].first;
			int nextDist = cost + adj[here][i].second;

			if (nextDist < dist[there]) {
				dist[there] = nextDist;
				pq.push(make_pair(-nextDist, there));
			}
		}
	}

	return dist;
}

int solve(int N, int v1, int v2) {
	long long ret = -1;
	vector<int> from1 = dijstra(1, N), fromV1 = dijstra(v1, N), fromV2 = dijstra(v2, N);

	long long case1 = (long long)from1[v1] + fromV1[v2] + fromV2[N];
	long long case2 = (long long)from1[v2] + fromV2[v1] + fromV1[N];

	ret = min(case1, case2);

	return ret >= INF? -1 : ret;
}

int main(void) {
	int N, E, c, from , to, v1, v2;

	cin >> N >> E;

	adj = vector<vector<pair<int, int>>>(N + 1);
	for (int i = 0; i < E; ++i) {
		cin >> from >> to >> c;

		adj[from].push_back(make_pair(to, c));
		adj[to].push_back(make_pair(from, c));
	}

	cin >> v1 >> v2;

	cout << solve(N, v1, v2);
	return 0;
}
