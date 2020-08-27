//#include<iostream>
//#include<algorithm>
//#include<vector>
//using namespace std;
//
//vector<vector<int>> adj;
//vector<bool> visited;
//
//int dx[8] = { -1, -1, -1, 0, 0, 1, 1, 1 };
//int dy[8] = { -1, 0, 1, -1, 1, -1, 0, 1 };
//
//bool canLink(int x, int y, int h, int w, const vector<vector<int>>& v) {
//	return y >= 0  && y < h && x >= 0 && x < w && v[y][x] == 1;
//}
//
//void makeGrapgh(const vector<vector<int>>& v) {
//	int h = v.size(), w = v[0].size(); 
//	adj = vector<vector<int>>(w * h);
//
//	for(int i = 0; i < h; i++)
//		for(int j = 0; j < w; j++)
//			if (v[i][j] == 1) {
//				for (int y = 0; y < 8; y++)
//					for (int x = 0; x < 8; x++)
//						if (canLink(j + dx[x], i + dy[y], h, w, v)) {
//							adj[w * i + j].push_back(w * (i + dy[y]) + j + dx[x]);
//							adj[w * (i + dy[y]) + j + dx[x]].push_back(w * i + j);
//						}
//			}
//}
//
//void dfs(int here) {
//	visited[here] = true;
//
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (!visited[there])
//			dfs(there);
//	}
//}
//
//int solve(int h, int w, const vector<vector<int>> &v) {
//	visited = vector<bool>(h * w, false);
//	makeGrapgh(v);
//
//	int ret = 0;
//
//	for(int i = 0; i < h; i++)
//		for(int j = 0; j < w; j++)
//			if (v[i][j] == 1 && !visited[i * w + j]) {
//				dfs(i * w + j);
//				ret++;
//			}
//	
//	return ret;
//}
//int main(void) {
//	int w = 1, h = 1, tmp;
//	cin >> w >> h;
//
//	while (!(w == 0 && h == 0)) {
//		vector<vector<int>> v(h);
//
//		for (int i = 0; i < h; i++)
//			for (int j = 0; j < w; j++) {
//				cin >> tmp;
//				v[i].push_back(tmp);
//			}
//
//		cout << solve(h , w , v) << endl;
//		cin >> w >> h;
//	}
//	return 0;
//}