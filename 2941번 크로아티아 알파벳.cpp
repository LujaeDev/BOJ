//#include<iostream>
//#include<string>
//using namespace std;
//
//string forma[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//
//int idxForma(const string &s) {
//	int idx = -1;
//	
//	for (int i = 0; i < 8; i++) {
//		if (s.size() < forma[i].size())
//			continue;
//		if (s.substr(0, forma[i].size()) == forma[i])
//			idx = i;
//	}
//	return idx;
//}
//int main(void) {
//	string str;
//	int ret = 0;
//	cin >> str;
//
//	while (!str.empty()) {
//		int idx = idxForma(str);
//		if (idx == -1)
//			str = str.substr(1);
//		else
//			str = str.substr(forma[idx].size());
//		ret++;
//	}
//
//	cout << ret;
//	return 0;
//}