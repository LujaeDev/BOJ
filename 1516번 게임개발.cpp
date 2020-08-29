#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<vector<int>> adj;
vector<bool> isFisrt;
int Time[501];
int ret[501];

void dfs(int here, int currentTime) {
	if (ret[here] > currentTime)
		return;

	ret[here] = max(ret[here], currentTime);
	
	for (int i = 0; i < adj[here].size(); ++i) {
		int there = adj[here][i];

		dfs(there, currentTime + Time[there]);
	}
}

void solve(int N) {
	for (int i = 1; i <= N; ++i)
		ret[i] = Time[i];

	for (int i = 1; i <= N; ++i)
		if(isFisrt[i])
			dfs(i, Time[i]);
	
	for (int i = 1; i <= N; ++i)
		printf("%d\n", ret[i]);
}

int main(void) {
	int N, t, tmp;

	cin >> N;
	
	adj = vector<vector<int>>(N + 1);
	isFisrt = vector<bool>(N + 1, true);

	for (int i = 1; i <= N; ++i) {
		scanf("%d", &Time[i]);

		cin >> tmp;
		
		while (tmp != -1) {
			isFisrt[i] = false;
			adj[tmp].push_back(i);
			scanf("%d", &tmp);
		}
	}
	solve(N);

	return 0;
}