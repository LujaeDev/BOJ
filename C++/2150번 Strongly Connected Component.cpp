#include<iostream>
#include<algorithm>
#include<vector>
#include<stack>
using namespace std;

vector<vector<int>> adj, retS;
vector<int> discovered, sccId;
stack<int> st;
int cntV, cntSCC;

int scc(int here) {
	int ret = discovered[here] = cntV++;
	st.push(here);

	for (int i = 0;  i < adj[here].size(); i++) {
		int there = adj[here][i];

		if (discovered[there] == -1)
			ret = min(ret, scc(there));
		else if (sccId[there] == -1)
			ret = min(ret, discovered[there]);
	}

	if (ret == discovered[here]) {
		vector<int> v;
		while (1) {
			int tmp = st.top();
			st.pop();
			
			v.push_back(tmp);
			sccId[tmp] = cntSCC;

			if (tmp == here) {
				sort(v.begin(), v.end());
				retS.push_back(v);
				break;
			}
		}
		cntSCC++;
	}

	return ret;
}
bool com(const vector<int>& a, const vector<int>& b) {
	return a[0] < b[0];
}

void solve(int V) {
	sccId = discovered = vector<int>(V + 1, -1);

	for (int i = 1; i <= V; i++)
		if (discovered[i] == -1)
			scc(i);
	
	sort(retS.begin(), retS.end(), com);
	cout << retS.size() << endl;
	for (int i = 0; i < retS.size(); i++) {
		for (int j = 0; j < retS[i].size(); j++)
			printf("%d ", retS[i][j]);
		printf("-1\n");
	}
}
int main(void) {
	int V, E, A, B;

	cin >> V >> E;
	adj = vector<vector<int>>(V + 1);
	for (int i = 0; i < E; i++) {
		cin >> A >> B;

		adj[A].push_back(B);
	}
	solve(V);
	return 0;
}
