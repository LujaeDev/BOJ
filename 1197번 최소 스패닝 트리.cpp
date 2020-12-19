#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#define INF 987654321 
using namespace std;
vector<vector<pair<int, int>>> adj;

int solve(int V) {
	int ret = 0;
	vector<int> dist(V + 1, INF);
	vector<bool> visited(V + 1, false);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	
	dist[1] = 0;
	pq.push(make_pair(0, 1));

	while (!pq.empty()) {
		int here = pq.top().second;
		int cost = pq.top().first;
		pq.pop();

		if (cost > dist[here] || visited[here] == true)
			continue;

		ret += cost;
		visited[here] = true;

		for (int i = 0; i < adj[here].size(); ++i) {
			int there = adj[here][i].first;
			int nextDist = adj[here][i].second;

			if (dist[there] > nextDist) {
				dist[there] = nextDist;
				pq.push(make_pair(nextDist, there));
			}
		}
	}

	return ret;
}

int main(void) {
	int V, E, v1, v2, w;

	cin >> V >> E;

	adj = vector<vector<pair<int, int>>>(V + 1);

	for (int i = 0; i < E; ++i) {
		scanf("%d %d %d", &v1, &v2, &w);

		adj[v1].push_back(make_pair(v2, w));
		adj[v2].push_back(make_pair(v1, w));
	}

	cout << solve(V);
	return 0;
}