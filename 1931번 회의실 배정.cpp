//#include<iostream>
//#include<algorithm>
//#include<vector>
//using namespace std;
//
//vector<pair<int, int>> v;
//
//int solve() {
//	int ret = 0, meetingE = -1;
//
//	for (int i = 0; i < v.size(); i++) {
//		if (v[i].second >= meetingE) {
//			ret++;
//			meetingE = v[i].first;
//		}
//	}
//
//	return ret;
//}
//int main(void) {
//	int N, s, e;
//
//	cin >> N;
//	
//	for (int i = 0; i < N; i++) {
//		cin >> s >> e;
//		v.push_back(make_pair(e, s));
//	}
//	sort(v.begin(), v.end());
//	
//	cout << solve();
//	return 0;
//}