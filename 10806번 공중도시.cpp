//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<cstring>
//using namespace std;
//
//vector<vector<int>> adj;
//vector<int> discovered, depth;
//vector<pair<int, int>> cutE, retE;
//int cnt, children[1000001];
//
//int findCutEdge(int here, int parent, int d) {
//	int subtree, ret = discovered[here] = cnt++;
//	int check = 0;
//	depth[here] = d;
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (discovered[there] == -1) {
//			children[here]++;
//			subtree = findCutEdge(there, here, d + 1);
//
//			if (discovered[here] < subtree)
//				cutE.push_back(make_pair(here, there));
//
//			ret = min(ret, subtree);
//		}
//
//		if (there == parent) {
//			if (check >= 1)
//				ret = min(ret, discovered[there]);
//			check++;
//		}
//
//		else
//			ret = min(ret, discovered[there]);
//	}
//
//	return ret;
//}
//bool com(pair<int, int> a, pair<int, int> b) {
//	return depth[a.second] > depth[b.second];
//}
//
//void solve(int V) {
//	int u, v, small, big;
//	depth = discovered = vector<int>(V + 1, -1);
//
//	findCutEdge(1, -1, 0);
//
//	while (cutE.size() != 0) {
//		int from, to;
//		sort(cutE.begin(), cutE.end(), com);
//
//		from = cutE.front().second;
//
//		if (cutE.size() == 1)
//			to = 1;
//		else if (children[cutE.back().first] == 1)
//			to = cutE.back().first;
//		else
//			to = cutE.back().second;
//		
//		retE.push_back(make_pair(from, to));
//		
//		adj[from].push_back(to);
//		adj[to].push_back(from);
//		
//		cutE.clear();
//		cnt = 0;
//		depth = discovered = vector<int>(V + 1, -1);
//		memset(children, 0, sizeof(children));
//		
//		findCutEdge(1, -1, 0);
//	}
//
//	cout << retE.size() << endl;
//
//	for (int i = 0; i < retE.size(); i++) {
//		small = min(retE[i].first, retE[i].second);
//		big = max(retE[i].first, retE[i].second);
//		printf("%d %d\n", small, big);
//	}
//}
//
//int main(void) {
//	int V, E, tmp1, tmp2;
//
//	cin >> V >> E;
//	adj = vector<vector<int>>(V + 1);
//
//	for (int i = 0; i < E; i++) {
//		scanf("%d %d", &tmp1, &tmp2);
//
//		adj[tmp1].push_back(tmp2);
//		adj[tmp2].push_back(tmp1);
//	}
//
//	solve(V);
//
//	return 0;
//}