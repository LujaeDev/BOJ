//#include<iostream>
//#include<string>
//#include<vector>
//
//using namespace std;
//
//char arr[64][65];
//
//bool CheckUni(int y, int x, int size) {
//	char first = arr[y][x];
//
//	for (int i = y; i < y + size; i++)
//		for (int j = x; j < x + size; j++)
//			if (first != arr[i][j])
//				return false;
//
//	return true;
//}
//
//void Compress(int y, int x, int size) {
//	if (CheckUni(y, x, size))
//		printf("%c", arr[y][x]);
//	else {
//		printf("(");
//		int half = size / 2;
//		Compress(y, x, half);
//		Compress(y, x + half, half);
//		Compress(y + half, x, half);
//		Compress(y + half, x + half, half);
//		printf(")");
//	}
//}
//
//int main(void) {
//	int num;
//
//	scanf("%d", &num);
//	
//	for (int i = 0; i < num; i++)
//		scanf("%s", arr[i]);
//
//	Compress(0, 0, num);
//	return 0;
//}