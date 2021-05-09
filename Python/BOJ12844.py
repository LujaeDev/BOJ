import copy
import sys


class Seg:
    def __init__(self, li, n):
        self.tree = [0 for i in range(4 * n)]
        self.lazy = [0 for i in range(4 * n)]
        self.A = copy.deepcopy(li)
        self.initTree(1, 0, n - 1)

    def initTree(self, node, start, end):
        if start == end:
            self.tree[node] = self.A[start]
            return self.tree[node]
        mid = int((start + end) / 2)
        self.tree[node] = self.initTree(2 * node, start, mid) ^ self.initTree(2 * node + 1, mid + 1, end)
        return self.tree[node]

    def update_lazy(self, node, start, end):
        if self.lazy[node] != 0:
            if (end - start + 1) % 2 == 1:
                self.tree[node] ^= self.lazy[node]
            if start != end:
                self.lazy[2 * node] ^= self.lazy[node]
                self.lazy[2 * node + 1] ^= self.lazy[node]
        self.lazy[node] = 0

    def update_range(self, node, start, end, left, right, k):
        self.update_lazy(node, start, end)

        if end < left or start > right:
            return self.tree[node]
        if left <= start and end <= right:
            if (end - start + 1) % 2 == 1:
                self.tree[node] ^= k
            if start != end:
                self.lazy[2 * node] ^= k
                self.lazy[2 * node + 1] ^= k
            return self.tree[node]
        mid = int((start + end) / 2)
        self.tree[node] = self.update_range(2 * node, start, mid, left, right, k) ^ self.update_range(2 * node + 1, mid + 1, end, left, right, k)
        return self.tree[node]

    def query(self, node, start, end, left, right):
        self.update_lazy(node, start, end)

        if left <= start and end <= right:
            return self.tree[node]
        if start > right or end < left:
            return 0
        
        mid = int((start + end) / 2)
        return self.query(2 * node, start, mid, left, right) ^ self.query(2 * node + 1, mid + 1, end, left, right)


N = int(input())
li = list(map(int, sys.stdin.readline().split()))
M = int(input())

seg = Seg(li, N)
for i in range(M):
    comLi = list(map(int, sys.stdin.readline().split()))
    if len(comLi) == 4:
        seg.update_range(1, 0, N - 1, comLi[1], comLi[2], comLi[3])
    else:
        print(seg.query(1, 0, N - 1, comLi[1], comLi[2]))
