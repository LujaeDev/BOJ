import sys
import copy
INF = 10 ** 9 + 5


def selectMinIndex(li, idx1, idx2):
    ret = idx2
    if li[idx1] <= li[idx2]:
        ret = idx1
    return ret


class Seg:
    def __init__(self, A):
        self.n = len(A)
        self.tree = [self.n for i in range(4 * self.n)]
        self.li = copy.deepcopy(A)
        self.li.append(INF)
        self.initTree(1, 0, self.n - 1)

    def initTree(self, node, start, end):
        if start == end:
            self.tree[node] = start
            return self.tree[node]
        mid = int((start + end) / 2)
        self.tree[node] = selectMinIndex(self.li, self.initTree(2 * node, start, mid), self.initTree(2 * node + 1, mid + 1, end))
        return self.tree[node]

    def update(self, node, start, end, idx, val):
        if start > idx or end < idx:
            return self.tree[node]
        if start == idx and end == idx:
            self.li[idx] = val
            return self.tree[node]
        mid = int((start + end) / 2)
        self.tree[node] = selectMinIndex(self.li, self.update(2 * node, start, mid, idx, val), self.update(2 * node + 1, mid + 1, end, idx, val))
        return self.tree[node]

    def query(self, node, start, end, left, right):
        if end < left or start > right:
            return self.n
        if left <= start and end <= right:
            return self.tree[node]
        mid = int((start + end) / 2)
        return selectMinIndex(self.li, self.query(2 * node, start, mid, left, right), self.query(2 * node + 1, mid + 1, end, left, right))


N = int(input())
A = list(map(int, sys.stdin.readline().split()))
M = int(input())

segT = Seg(A)
for i in range(M):
    tmp = list(map(int, sys.stdin.readline().split()))
    if tmp[0] == 1:
        segT.update(1, 0, N - 1, tmp[1] - 1, tmp[2])
    else:
        print(segT.query(1, 0, N - 1, tmp[1] - 1, tmp[2] - 1) + 1)
