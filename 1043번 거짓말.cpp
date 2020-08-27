//#include<iostream>
//#include<algorithm>
//#include<vector>
//using namespace std;
//
//int isCheckedParty[51];
//bool knowCheck[51];
//vector<vector<int>> adj, p;
//
//int solve(vector<int> &know, int m) {
//	int cnt = 0;
//
//	for (int i = 0; i < know.size(); i++) {
//		int currentKnow = know[i];
//		for (int j = 0; j < adj[currentKnow].size(); j++) {
//			if (isCheckedParty[adj[currentKnow][j]])
//				continue;
//			int adjParty = adj[currentKnow][j];
//
//			for (int z = 0; z < p[adjParty].size(); z++)
//				if (!knowCheck[p[adjParty][z]]) {
//					know.push_back(p[adjParty][z]);
//					knowCheck[p[adjParty][z]] = true;
//				}
//
//			isCheckedParty[adjParty] = 1;
//		}
//	}
//
//	for (int i = 1; i <= m; i++)
//		if (isCheckedParty[i] == 0)
//			cnt++;
//	
//	return cnt;
//}
//
//int main(void) {
//	int N, M, K, k, tmp, num;
//	vector<int> know;
//
//	cin >> N >> M >> K;
//	adj = vector<vector<int>>(N + 1);
//	p = vector<vector<int>>(M + 1);
//
//	for (int i = 0; i < K; i++) {
//		cin >> tmp;
//		know.push_back(tmp);
//		knowCheck[tmp] = true;
//	}
//
//	for (int i = 1; i <= M; i++) {
//		cin >> num;
//		
//		for (int j = 0; j < num; j++) {
//			cin >> tmp;
//			adj[tmp].push_back(i);
//			p[i].push_back(tmp);
//		}
//	}
//
//	cout << solve(know, M);
//	return 0;
//}