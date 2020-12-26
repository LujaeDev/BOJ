#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#define INF 987654321
using namespace std;

vector<vector<pair<int, int>>> adj;
vector<int>trace;

vector<int> dijstra(int start, int N) {
	trace = vector<int>(N + 1);
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
			int newDist = cost + adj[here][i].second;

			if (newDist < dist[there]) {
				dist[there] = newDist;
				pq.push(make_pair(-newDist, there));
				trace[there] = here;
			}
		}
	}

	return dist;
}

void solve(int s, int e, int N) {
	vector<int> dist = dijstra(s, N);
	vector<int> path;

	int ret = dist[e], here = e;

	cout << ret << endl;
	
	path.push_back(e);
	while (here != s) {
		path.push_back(trace[here]);
		here = trace[here];
	}

	cout << path.size() << endl;
	for (int i = path.size() - 1; i >= 0; i--)
		printf("%d ", path[i]);
}

int main(void) {
	int n, m, c, from, to, s, e;

	cin >> n >> m;

	adj = vector<vector<pair<int, int>>>(n + 1);

	for (int i = 0; i < m; ++i) {
		cin >> from >> to >> c;

		adj[from].push_back(make_pair(to, c));
	}

	cin >> s >> e;

	solve(s, e, n);
	return 0;
}
