#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

bool compare(int a, int b) {
	return a > b;
}

int MaxWeight(vector<int>& w) {
	int max_w = 0;

	for (int i = 0; i < w.size(); i++)
		max_w = max(max_w, w[i] * (i + 1));

	return max_w;
}
int main(void) {
	int num, tmp;
	vector<int> w;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d", &tmp);
		w.push_back(tmp);
	}

	sort(w.begin(), w.end(), compare);
	
	printf("%d", MaxWeight(w));
	return 0;
}
