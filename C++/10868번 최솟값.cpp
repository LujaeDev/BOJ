#include<iostream>
#include<algorithm>
#include<vector>
#define INF 2000000000
using namespace std;

class RMQ {
	int size;
	vector<int> rangeMin;

public:
	RMQ(const vector<int>& arr) {
		size = arr.size();
		rangeMin.resize(4 * size);

		init(arr, 1, 0, size - 1);
	}

	int query(int left, int right) {
		return query(left, right, 1, 0, size - 1);
	}

private:
	int init(const vector<int>& arr, int node, int leftNode, int rightNode) {
		if (leftNode == rightNode)
			return rangeMin[node] = arr[leftNode];

		int mid = (leftNode + rightNode) / 2;
		int leftV = init(arr, 2 * node, leftNode, mid);
		int rightV = init(arr, 2 * node + 1, mid + 1, rightNode);

		return rangeMin[node] = min(leftV, rightV);
	}

	int query(int left, int right, int node, int leftNode, int rightNode) {
		if (left > rightNode || right < leftNode)
			return INF;

		if (left <= leftNode && right >= rightNode)
			return rangeMin[node];

		int mid = (leftNode + rightNode) / 2;
		int leftV = query(left, right, 2 * node, leftNode, mid);
		int rightV = query(left, right, 2 * node + 1, mid + 1, rightNode);
		
		return min(leftV, rightV);
	}
};

int main(void) {
	int N, M, tmp, a, b;
	vector<int> arr;

	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; ++i) {
		scanf("%d", &tmp);

		arr.push_back(tmp);
	}

	RMQ rmq(arr);

	for (int i = 0; i < M; ++i) {
		scanf("%d %d", &a, &b);

		printf("%d\n", rmq.query(a - 1, b - 1));
	}
}
