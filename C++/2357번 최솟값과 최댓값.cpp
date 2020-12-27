#include<iostream>
#include<algorithm>
#include<vector>
#define INF 2000000000
#define RINF -INF
using namespace std;

typedef struct Data {
	int maxV;
	int minV;

	Data() {
		maxV = RINF;
		minV = INF;
	}

	Data(int maxValue, int minValue) {
		maxV = maxValue;
		minV = minValue;
	}
}Data;

class St {
public:
	St(const vector<int>& arr) {
		size = arr.size();
		rangeData.resize(4 * size);

		init(arr, 1, 0, size - 1);
	}

	Data query(int start, int end) {
		return query(start - 1, end - 1, 1, 0, size - 1);
	}
private:
	vector<Data> rangeData;
	int size;

	Data init(const vector<int>& arr, int node, int left, int right) {
		if (left == right)
			return rangeData[node] = Data(arr[left], arr[left]);

		int mid = (left + right) / 2;
		Data leftD = init(arr, 2 * node, left, mid);
		Data rightD = init(arr, 2 * node + 1, mid + 1, right);

		int maxV = max(leftD.maxV, rightD.maxV);
		int minV = min(leftD.minV, rightD.minV);

		return rangeData[node] = Data(maxV, minV);
	}

	Data query(int start, int end, int node, int left, int right) {
		if (end < left || start > right)
			return Data(RINF, INF);
		if (start <= left && right <= end)
			return rangeData[node];

		int mid = (left + right) / 2;
		Data leftD = query(start, end, 2 * node, left, mid);
		Data rightD = query(start, end, 2 * node + 1, mid + 1, right);

		int maxV = max(leftD.maxV, rightD.maxV);
		int minV = min(leftD.minV, rightD.minV);

		return Data(maxV, minV);
	}
};

int main(void) {
	int N, M, tmp, s, e;
	vector<int> arr;

	cin >> N >> M;

	for (int i = 0; i < N; ++i) {
		scanf("%d", &tmp);

		arr.push_back(tmp);
	}

	St st(arr);

	for (int i = 0; i < M; ++i) {
		scanf("%d %d", &s, &e);

		Data retD = st.query(s, e);

		printf("%d %d\n", retD.minV, retD.maxV);
	}

	return 0;
}
