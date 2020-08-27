//#include<iostream>
//#include<vector>
//#include<algorithm>
//#include<cstring>
//using namespace std;
//
//#define INF 987654321
//int W[16][16];
//int cache[16][1 << 16];
//
//int TSP(int pos, int visited, int num) {
//	int& ret = cache[pos][visited];
//
//	if (visited == (1 << num) - 1) {
//		if (W[pos][0] == 0)
//			return INF;
//		return W[pos][0];
//	}
//	else if (cache[pos][visited] != -1)
//		return cache[pos][visited];
//
//	ret = INF;
//
//	for (int next = 1; next < num; next++) {
//		if (!(visited & (1 << next)) && W[pos][next] != 0)
//			ret = min(ret, TSP(next, visited | (1 << next), num) + W[pos][next]);
//	}
//
//	return cache[pos][visited] = ret;
//}
//
//int main(void) {
//	int num;
//
//	cin >> num;
//
//	for (int i = 0; i < num; i++)
//		for (int j = 0; j < num; j++)
//			scanf("%d", &W[i][j]);
//
//	memset(cache, -1, sizeof(cache));
//
//	
//	cout << TSP(0, 1, num);
//}