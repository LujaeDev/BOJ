#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
vector<vector<int>> adj;

int firstX[10001];
int maxW[10001];
int level[10001];
int leftmost[10001], rightmost[10001];
int parent[10001];

void dfs(int here, int h) {
	level[here] = h;

	for (int i = 0; i < adj[here].size(); ++i)
		if(adj[here][i] != -1)
			dfs(adj[here][i], h + 1);
}

void assignPosX(int here, int *x) {
	if (here == -1)
		return;

	
	assignPosX(adj[here][0], x);
	
	leftmost[level[here]] = min(*x, leftmost[level[here]]);
	maxW[level[here]] = max(maxW[level[here]], *x - leftmost[level[here]] + 1);
	(*x)++;
	
	assignPosX(adj[here][1], x);
}

void solve(int N, int root) {
	int x = 1, w = 0, lev;

	dfs(root, 1);
	assignPosX(root, &x);

	for(int i = 1; i <= N; ++i)
		if (maxW[i] > w) {
			w = maxW[i];
			lev = i;
		}

	printf("%d %d", lev, w);
}

int main(void) {
	int N, num, left, right, root;
	
	scanf("%d", &N);

	adj = vector<vector<int>>(N + 1);

	for (int i = 1; i <= N; ++i)
		leftmost[i] = 987654321;

	for (int i = 0; i < N; ++i) {
		scanf("%d %d %d", &num, &left, &right);

		
		adj[num].push_back(left);
		parent[left] = num;
	
	
		adj[num].push_back(right);
		parent[right] = num;
	}

	for (int i = 1; i <= N; ++i)
		if (parent[i] == 0)
			root = i;

	solve(N, root);

	return 0;
}
