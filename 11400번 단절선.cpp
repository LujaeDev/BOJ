//#include<iostream>
//#include<algorithm>
//#include<vector>
//using namespace std;
//
//vector<vector<int>> adj;
//vector<int> discovered;
//vector<pair<int, int>> cutE;
//int cnt;
//int findCutEdge(int here, int parent) {
//	int subtree, ret = discovered[here] = cnt++;
//
//	for (int i = 0; i < adj[here].size(); i++) {
//		int there = adj[here][i];
//
//		if (there == parent)
//			continue;
//		
//		if (discovered[there] == -1) {
//			subtree = findCutEdge(there, here);
//
//			if (discovered[here] < subtree) {
//				int l = here < there ? here : there;
//				int h = here > there ? here : there;
//
//				cutE.push_back(make_pair(l, h));
//			}
//			ret = min(ret, subtree);
//		}
//		else
//			ret = min(ret, discovered[there]);
//	}
//
//	return ret;
//}
//
//void solve(int V) {
//	discovered = vector<int>(V + 1, -1);
//
//	findCutEdge(1, -1);
//
//	sort(cutE.begin(), cutE.end());
//
//	cout << cutE.size() << endl;
//	for (int i = 0; i < cutE.size(); i++)
//		printf("%d %d\n", cutE[i].first, cutE[i].second);
//}
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