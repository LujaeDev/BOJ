//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<cstring>
//
//using namespace std;
//
//int cache[31];
//int pos[31];
//
//int dp(vector<int> &v, int current_idx, int current_w,int max_w) {
//	int &ret = pos[current_idx];
//
//	if (current_idx = v.size())
//		return 0;
//	ret = 1;
//
//	for (int next = current_idx + 1; next < v.size(); next++) {
//		if (current_w + v[next] <= max_w)
//			if (ret != -1)
//				return ret;
//			else
//				ret = 1 + dp(v, next, current_w + v[next], max_w);
//	}
//
//	return ret;
//}
//
//int main(void) {
//	int tmp, num, max_w,ret = 0, current_w, cnt, idx;
//	vector<int> v;
//
//	cin >> num >> max_w;
//
//	for (int i = 0; i < num; i++){
//		scanf("%d", &tmp);
//		v.push_back(tmp);
//	}
//
//	sort(v.begin(), v.end());
//
//	cache[v.size() - 1] = (v[v.size() - 1] <= max_w);
//
//	for (int i = v.size() - 1 - 1; i >= 0; i--) {
//		memset(pos, -1, sizeof(pos));
//		cache[i] = cache[i + 1] + dp(v, i, 0, max_w);;
//	}
//
//	cout << cache[0] + 1;
//	return 0;
//}
