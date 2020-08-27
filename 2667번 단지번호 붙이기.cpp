#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
string arr[25];
vector<vector<int>> adj;
vector<bool> visited;
vector<int> ret;

bool range(int y, int x, int N) {
	return !(y < 0 || x < 0 || y >= N || x >= N);
}

void DFS(int hereY, int hereX, int N, vector<bool>& visited) {
	int here = hereY * N + hereX;
	visited[here] = true;

	for (int i = 0; i < adj[here].size(); i++) {
		int there = adj[here][i];

		if (!visited[there])
			DFS(there / N, there % N, N, visited);
	}

	ret.push_back(here);
}

void solve(int N) {
	int cnt = 0;
	vector<int> s;
	visited = vector<bool>(N * N, false);

	for(int i = 0; i < N; i++)
		for (int j = 0; j < N; j++) {
			if (arr[i][j] == '1' && !visited[N * i + j]) {
				cnt++;
				DFS(i, j, N, visited);
				s.push_back(ret.size());
				ret.clear();
			}
		}

	cout << cnt << endl;
	sort(s.begin(), s.end());
	for (int i = 0; i < s.size(); i++)
		cout << s[i] << endl;
}

bool check(int y, int x) {
	return arr[y][x] == '1';
}
int main(void) {
	int N, here;
	string str;
	cin >> N;

	adj = vector<vector<int>>(N * N);

	for (int i = 0; i < N; i++)
		cin >> arr[i];

	for (int i = 0; i < N; i++){
		for (int j = 0; j < arr[i].size(); j++) {
			if (arr[i][j] == '1') {
				here = i * N + j;

				if (range(i - 1, j, N) && check(i - 1, j)) {
					adj[here].push_back(N * (i - 1) + j);
					adj[N * (i - 1) + j].push_back(here);
				}
				if (range(i + 1, j, N) && check(i + 1, j)) {
					adj[here].push_back(N * (i + 1) + j);
					adj[N * (i + 1) + j].push_back(here);
				}
				if (range(i, j - 1, N) && check(i, j - 1)) {
					adj[here].push_back(N * i + j - 1);
					adj[N * i + j - 1].push_back(here);
				}
				if (range(i, j + 1, N) && check(i, j + 1)) {
					adj[here].push_back(N * i + j + 1);
					adj[N * i + j + 1].push_back(here);
				}
			}
		}
	}
	
	solve(N);
}
