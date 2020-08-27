#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int arr[1000000], p[1000000];
vector<int> v, ret;

int main(void) {
	int num;
	vector<int>::iterator low;

	cin >> num;

	for (int i = 0; i < num; ++i)
		scanf("%d", &arr[i]);

	for (int here = 0; here < num; here++) {
		if (v.empty()) {
			v.push_back(arr[here]);
			p[here] = 0;
		}
		else {
			if (v.back() < arr[here]) {
				v.push_back(arr[here]);
				p[here] = v.size() - 1;
			}
			else {
				low = lower_bound(v.begin(), v.end(), arr[here]);
				*low = arr[here];
				p[here] = low - v.begin();
			}
		}
	}

	cout << v.size() << endl;
	int cnt = v.size() - 1;

	for (int i = num - 1; i >= 0; i--) {
		if (p[i] == cnt) {
			ret.push_back(arr[i]);
			cnt--;
		}
		if (cnt == -1)
			break;
	}
	
	for (auto i : ret) {
		printf("%d ", ret.back());
		ret.pop_back();
	}
	return 0;
}
