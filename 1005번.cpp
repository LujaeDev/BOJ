#include<iostream>
#include<algorithm>
#include<vector>
#define INF 987654321
using namespace std;
int D[1001];
vector<vector<int>> adj;
vector<bool> visited;

void dfs(int here, vector<int>& topOrder) {
	visited[here] = true;

	for (int i = 0; i < adj[here].size(); ++i) {
		int there = adj[here][i];

		if (visited[there] == false)
			dfs(there, topOrder);
	}

	topOrder.push_back(here);
}

vector<int> topologicalSort(int N) {
	vector<int> topOrder = vector<int>(N + 1);
	visited = vector<bool>(N + 1, false);

	for (int i = 1; i <= N; ++i)
		if (visited[i] != true)
			dfs(i, topOrder);

	reverse(topOrder.begin(), topOrder.end());

	return topOrder;
}

int sol(int N, int W) {
	vector<long long> dist(N + 1, INF);
	vector<int> topOrder = topologicalSort(N);

	for (int i = 1; i <= N; ++i)
		dist[i] = D[i];

	for (int i = 0; i < topOrder.size(); ++i) {
		int here = topOrder[i];

		for (int j = 0; j < adj[here].size(); ++j) {
			int there = adj[here][j];

			dist[there] = max(dist[there], dist[here] + D[there]);
		}
	}

	return dist[W];
}

int main(void) {
	int T, N, K, X, Y, W;

	cin >> T;

	while (T--) {
		scanf("%d %d", &N, &K);

		for (int i = 1; i <= N; ++i)
			scanf("%d", &D[i]);

		adj = vector<vector<int>>(N + 1);

		for (int i = 1; i <= K; ++i) {
			scanf("%d %d", &X, &Y);

			adj[X].push_back(Y);
		}
		
		scanf("%d", &W);

		cout << sol(N, W) << "\n";
	}

	return 0;
}