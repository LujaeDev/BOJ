//#include<iostream>
//#include<algorithm>
//
//using namespace std;
//
//typedef struct BiTree{
//	int key;
//	BiTree* left, * right;
//};
//
//BiTree* makeTree(BiTree* root, int key) {
//	if (root == NULL)
//		return new BiTree{ key, NULL, NULL };
//	
//	if (key > root->key)
//		root->right = makeTree(root->right, key);
//	if (key < root->key)
//		root->left = makeTree(root->left, key);
//	return root;
//}
//
//void solve(BiTree* root) {
//	if (root == NULL)
//		return;
//	solve(root->left);
//	solve(root->right);
//	printf("%d\n", root->key);
//}
//
//int main(void) {
//	int key;
//
//	cin >> key;
//
//	BiTree root = { key, NULL, NULL };
//
//	while (cin >> key) {
//		makeTree(&root, key);
//	}
//
//	solve(&root);
//	return 0;
//}