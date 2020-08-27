//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<string>
//
//using namespace std;
//
//int findCntB(int N, int K) {
//	int x = 0;
//	for (int x = 0; x < N; x++)
//		if (x * (N - x) >= K)
//			return x;
//	return -1;
//}
//
//bool pos(const int cntB, int currentV, const int K, vector<int>& B, const int maxD) {
//	if (cntB == B.size())
//		if (currentV == K)
//			return true;
//		else
//			return false;
//
//	for (int i = B.empty() ? maxD : B.back(); i >= 0; i--) {
//		B.push_back(i);
//		if (pos(cntB, currentV + i, K, B, maxD))
//			return true;
//		B.pop_back();
//	}
//
//	return false;
//}
//
//string solve(int N, int K) {
//	string ret;
//	int cntB = findCntB(N, K);
//	if (cntB == -1)
//		return "-1";
//	if (cntB == 0) {
//		ret = "B";
//		for (int i = 0; i < N - 1; i++)
//			ret += "A";
//		return ret;
//	}
//
//	int cntA = N - cntB, currentCntA = 0;
//	vector<int> B;
//	pos(cntB, 0, K, B, cntA);
//	
//	while (!B.empty()) {
//		if (currentCntA == B.back()) {
//			ret += "B";
//			B.pop_back();
//		}
//		else {
//			ret += "A";
//			currentCntA++;
//		}
//	}
//	while (ret.size() < N)
//		ret += "A";
//	return ret;
//}
//int main(void) {
//	int N, K;
//
//	cin >> N >> K;
//
//	cout << solve(N, K);
//	return 0;
//}