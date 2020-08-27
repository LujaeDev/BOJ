//#include<iostream>
//#include<vector>
//#include<string>
//#include<map>
//using namespace std;
//
//string solve(const string& s, const string& boom) {
//	string ret;
//	map<char, int> order;
//	vector<int> canPrint(s.size(), true);
//	vector<int> st;
//	int lastOrder = -1;
//
//	for (int i = 0; i < boom.size(); i++)
//		order[boom[i]] = i;
//
//	for (int i = 0; i < s.size(); i++) {
//		if (order.find(s[i]) == order.end() || order[s[i]] != 0 && order[s[i]] != lastOrder + 1) {
//			st.clear();
//			lastOrder = -1;
//		}
//		else{
//			lastOrder = order[s[i]];
//			st.push_back(i);
//			if (lastOrder == boom.size() - 1) {
//				for (int j = 0; j < boom.size(); j++) {
//					canPrint[st.back()] = false;
//					st.pop_back();
//				}
//				lastOrder = st.empty() ? -1 : order[s[st.back()]];
//			}
//		}
//	}
//
//	for (int i = 0; i < s.size(); i++)
//		if (canPrint[i])
//			ret += s[i];
//
//	if (ret.size() == 0)
//		return "FRULA";
//	return ret;
//}
//
//int main(void) {
//	string s, boom;
//
//	cin >> s >> boom;
//
//	cout << solve(s, boom);
//	return 0;
//}