#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;

int main(void) {
	int n, x;
	priority_queue<int, vector<int>, greater<int>> minHeap;
	cin >> n;

	while (n--) {
		scanf("%d", &x);
		if (x != 0)
			minHeap.push(x);
		else {
			int top = minHeap.empty() ? 0 : minHeap.top();
			printf("%d\n", top);
			if(!minHeap.empty())
				minHeap.pop();
		}
	}

	return 0;
}
