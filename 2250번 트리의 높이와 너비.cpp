//#include<iostream>
//#include<algorithm>
//#include<vector>
//
//using namespace std;
//
//typedef struct Tree{
//	int num, level, posX;
//	Tree* left, *right;
//};
//
//int firstX[10001];
//int maxW[10001];
//
//void makeTree(Tree* root, int num, int leftV, int rightV) {
//	if (root == NULL)
//		return;
//	if (root->num == num) {
//		if (leftV != -1)
//			root->left = new Tree{ leftV, -1, NULL, NULL };
//		if(rightV != -1)
//			root->right = new Tree{ rightV, -1, NULL, NULL };
//		return;
//	}
//	makeTree(root->left, num, leftV, rightV);
//	makeTree(root->right, num, leftV, rightV);
//}
//
//void assignPosX(Tree* root, int *x) {
//	if (root == NULL)
//		return;
//
//	assignPosX(root->left, x);
//	root->posX = (*x)++;
//	if (firstX[root->level] == 0)
//		firstX[root->level] = root->posX;
//	maxW[root->level] = root->posX - firstX[root->level] + 1;
//	assignPosX(root->right, x);
//}
//
//void solve(Tree *root) {
//	int x = 1;
//	//높이 할당이 필요함
//
//	assignPosX(root, &x);
//	int ret = -1, level  = 1;
//	
//	for (int i = 1; maxW[i] != 0; i++) {
//		if (ret < maxW[i]) {
//			ret = maxW[i];
//			level = i;
//		}
//	}
//
//	cout << level << " " << ret;
//}
//
//int main(void) {
//	int N, num, leftV, rightV;
//	
//	cin >> N;
//
//	while (--N) {
//		scanf("%d %d %d", &num, &leftV, &rightV);
//		makeTree(&root, num, leftV, rightV);
//	}
//
//	solve(&root);
//
//	return 0;
//}