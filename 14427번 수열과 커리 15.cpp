#include<iostream>
#include<algorithm>
#include<vector>
#define INF 2000000000
using namespace std;

typedef struct RangeResult{
	int minValue;
	int idx;
	RangeResult() {
		minValue = INF;
		idx = -1;
	}
	RangeResult(int v, int i) {
		minValue = v;
		idx = i;
	}
}RangeResult;

class RMQ {
	int size;
	
public:
	vector<RangeResult> rangeMin;
	RMQ(const vector<int>& arr) {
		size = arr.size();
		rangeMin.resize(4 * size);

		init(arr, 1, 0, size - 1);
	}

	int query(int left, int right) {
		RangeResult ret =  query(left, right, 1, 0, size - 1);

		return ret.idx + 1;
	}

	void update(int idx, int newValue) {
		update(idx, newValue, 1, 0, size - 1);
	}

private:
	RangeResult init(const vector<int>& arr, int node, int leftNode, int rightNode) {
		if (leftNode == rightNode)
			return rangeMin[node] = RangeResult(arr[leftNode], leftNode);

		int mid = (leftNode + rightNode) / 2;
		RangeResult leftRet = init(arr, 2 * node, leftNode, mid);
		RangeResult rightRet = init(arr, 2 * node + 1, mid + 1, rightNode);
		RangeResult ret = leftRet;

		if (rightRet.minValue < leftRet.minValue)
			ret = rightRet;

		return rangeMin[node] = ret;
	}

	RangeResult query(int left, int right, int node, int leftNode, int rightNode) {
		if (left > rightNode || right < leftNode)
			return RangeResult(INF, -1);

		if (left <= leftNode && right >= rightNode)
			return rangeMin[node];

		int mid = (leftNode + rightNode) / 2;

		RangeResult leftRet = query(left, right, 2 * node, leftNode, mid);
		RangeResult rightRet = query(left, right, 2 * node + 1, mid + 1, rightNode);
		RangeResult ret = leftRet;

		if (rightRet.minValue < leftRet.minValue)
			ret = rightRet;

		return ret;
	}

	RangeResult update(int idx, int newValue, int node, int leftNode, int rightNode) {
		if (idx == leftNode && idx == rightNode) {
			rangeMin[node].minValue = newValue;
			return rangeMin[node];
		}

		if (idx < leftNode || idx > rightNode)
			return rangeMin[node];

		int mid = (leftNode + rightNode) / 2;
		RangeResult leftRet = update(idx, newValue, 2 * node, leftNode, mid);
		RangeResult rightRet = update(idx, newValue, 2 * node + 1, mid + 1, rightNode);
		RangeResult ret = leftRet;

		if (rightRet.minValue < leftRet.minValue)
			ret = rightRet;

		return rangeMin[node] = ret;
	}
};

int main(void) {
	int N, M, tmp, command, idx, v;
	vector<int> arr;

	scanf("%d", &N);

	for (int i = 0; i < N; ++i) {
		scanf("%d", &tmp);

		arr.push_back(tmp);
	}

	RMQ rmq(arr);
	
	scanf("%d", &M);
	for (int i = 0; i < M; ++i) {
		scanf("%d", &command);

		if (command == 1) {
			scanf("%d %d", &idx, &v);
			rmq.update(idx - 1, v);
		}
		else if (command == 2)
			printf("%d\n", rmq.rangeMin[1].idx + 1);
	}
}