#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

vector<vector<int>> adj(1001);
int mat[1001][1001];
int INF = 987654321;
int num = 0;

vector<int> bfs(int start) {
	vector<bool> discovered = vector<bool>(num, false);
	vector<int> dist = vector<int>(num, INF);
	queue<pair<int, int>> que = queue<pair<int, int>>();

	que.push(make_pair(start, 0));

	dist[start] = 0;

	while (!que.empty()) {
		int here = que.front().first;
		int beforeDist = que.front().second;
		que.pop();

		for (int i = 0; i < adj[here].size(); ++i) {
			int there = adj[here][i];

			if (!discovered[there]) {
				dist[there] = beforeDist + 1;
				discovered[there] = true;

				if (here != there)
					que.push(make_pair(there, dist[there]));
			}
		}

		beforeDist++;
	}

	return dist;
}

int sol() {
	int ret = 0;

	for (int i = 0; i < num; ++i) {
		vector<int> dist = bfs(i);

		for (int j = 0; j < num; ++j)
			ret = max(ret, dist[j]);
	}

	return ret < INF ? ret : 0;
}

int main(void) {

	scanf("%d", &num);

	for (int i = 0; i < num; ++i)
		for (int j = 0; j < num; ++j) {
			scanf("%d", &mat[i][j]);

			if (mat[i][j] != 0)
				adj[i].push_back(j);
		}

	printf("%d", sol());
}