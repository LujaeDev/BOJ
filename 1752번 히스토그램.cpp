#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> h;

int solve(int left, int right) {
	if (left == right)
		return h[left];
	int mid = (left + right) / 2;
	int ret = max(solve(left, mid), solve(mid + 1, right));

	int lo = mid, hi = mid + 1;
	int height = min(h[lo], h[hi]);
	ret = max(ret, (hi - lo + 1) * height);
	while (lo > left || hi < right) {
		if (hi < right && (lo == left || h[hi + 1] > h[lo - 1]))
			height = min(height, h[++hi]);
		else 
			height = min(height, h[--lo]);
		
		ret = max(ret, (hi - lo + 1) * height);
	}

	return ret;
}

int main(void) {
	int n, tmp;

	cin >> n;

	for (int i = 0; i < n; ++i) {
		scanf("%d", &tmp);

		h.push_back(tmp);
	}

	cout << solve(0, n - 1);
	return 0;
}