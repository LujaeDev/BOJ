#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

vector<vector<int>> adj;
vector<bool> visited;

void DFS(int here) {
	visited[here] = true;
	for (int i = 0; i < adj[here].size(); i++) {
		int there = adj[here][i];
		if (!visited[there])
			DFS(there);
	}
}

int solve(int N) {
	int cnt = 0;
	visited = vector<bool>(N + 1, false);

	for (int i = 1; i <= N; i++) {
		if (!visited[i]) {
			cnt++;
			DFS(i);
		}
	}

	return cnt;
}
int main() {
	int N, M;
	int here, there;

	cin >> N >> M;
	adj = vector<vector<int>>(N + 1);
	
	for (int i = 0; i < M; i++) {
		cin >> here >> there;

		adj[here].push_back(there);
		adj[there].push_back(here);
	}

	cout << solve(N);
}
