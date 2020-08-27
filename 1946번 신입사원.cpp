//#include<iostream>
//#include<vector>
//#include<algorithm>
//
//using namespace std;
//
//int solve(const vector<pair<int, int>> &v) {
//	int ret = v.size(), minR = 987654321; 
//
//	for (int i = 0; i < v.size(); i++) {
//		if (v[i].second > minR)
//			ret--;
//		else
//			minR = v[i].second;
//	}
//
//	return ret;
//}
//
//int main(void) {
//	ios_base::sync_with_stdio(false);
//	int T, N, tmp1, tmp2;
//	vector<pair<int, int>> v;
//
//	cin >> T;
//
//	while (T--) {
//		cin >> N;
//
//		v.clear();
//
//		for (int i = 0; i < N; i++) {
//			cin >> tmp1 >> tmp2;
//
//			v.push_back(make_pair(tmp1, tmp2));
//		}
//		sort(v.begin(), v.end());
//
//		cout << solve(v) << endl;
//	}
//
//	return 0;
//}