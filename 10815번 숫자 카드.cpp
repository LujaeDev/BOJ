#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> myCard;
vector<int> objCard;

int binarySearch(int left, int right, int obj) {
	if (left > right)
		return left;

	int mid = (left + right) / 2;

	if (obj > myCard[mid])
		return binarySearch(mid + 1, right, obj);
	else if (obj < myCard[mid])
		return binarySearch(left, mid - 1, obj);
	else
		return mid;
}

void solve(int N, int M) {
	for (int i = 0; i < M; ++i) {
		int idx = binarySearch(0, N - 1, objCard[i]);
		int ret = 0;

		if (myCard[idx] == objCard[i])
			ret = 1;

		printf("%d ", ret);
	}
}

int main(void) {
	int N, M, tmp;

	cin >> N;

	for (int i = 0; i < N; ++i) {
		scanf("%d", &tmp);
	
		myCard.push_back(tmp);
	}

	sort(myCard.begin(), myCard.end());

	cin >> M;

	for (int i = 0; i < M; ++i) {
		scanf("%d", &tmp);

		objCard.push_back(tmp);
	}

	solve(N, M);
	return 0;
}