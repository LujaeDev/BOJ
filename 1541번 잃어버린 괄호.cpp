//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<string>
//
//using namespace std;
//
//int main(void) {
//	string str, tmp;
//	vector<int> m, p;
//	int idx = 0, ret = 0;
//
//	cin >> str;
//	
//	while (idx < str.size() && str[idx] != '-') {
//		if (str[idx] == '+' || str[idx] == '0') {
//			idx++;
//			continue;
//		}
//		p.push_back(stoi(&str[idx]));
//		idx += to_string(p.back()).size();
//		ret += p.back();
//	}
//
//	while (idx < str.size()) {
//		if (str[idx] == '+' || str[idx] == '-' || str[idx] == '0') {
//			idx++;
//			continue;
//		}
//		m.push_back(stoi(&str[idx]));
//		idx += to_string(m.back()).size();
//		ret -= m.back();
//	}
//
//	cout << ret;
//	return 0;
//}