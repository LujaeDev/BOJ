#include<iostream>
#include<string>
using namespace std;
string str[1000];

int main(void) {

	int num, len, i, j ,z;
	
	cin >> num;

	for (int i = 0; i < num; i++)
		cin >> str[i];

	len = str[0].length();

	for (i = 1; i < len; i++) {
		for (j = 0; j < num - 1; j++) {
			for (z = j + 1; z < num; z++)
				if (str[j].substr(len - i).compare(str[z].substr(len - i)) == 0)
					break;
			if (z != num)
				break;
		}
		if (j == num - 1 && z == num)
			break;
	}

	cout << i;
	return 0;
}
