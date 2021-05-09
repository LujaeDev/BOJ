import sys


class Seg:
    def __init__(self, N):
        self.tree = [0 for i in range(N * 4)]
        self.lazy = [0 for i in range(N * 4)]
        self.size = N

    def update_lazy(self, node, start, end):
        if self.lazy[node] != 0:
            self.tree[node] = (end - start + 1) - self.tree[node]
            if start != end:
                self.lazy[node * 2] = 1 if self.lazy[node * 2] == 0 else 0
                self.lazy[node * 2 + 1] = 1 if self.lazy[node * 2 + 1] == 0 else 0
            self.lazy[node] = 0

    def update_range(self, node, start, end, left, right):
        self.update_lazy(node, start, end)
        if end < left or start > right:
            return self.tree[node]
        if left <= start and end <= right:
            self.tree[node] = (end - start + 1) - self.tree[node]
            if start != end:
                self.lazy[node * 2] = 1 if self.lazy[node * 2] == 0 else 0
                self.lazy[node * 2 + 1] = 1 if self.lazy[node * 2 + 1] == 0 else 0
            return self.tree[node]

        mid = int((start + end) / 2)
        self.tree[node] = self.update_range(node * 2, start, mid, left, right) + self.update_range(node * 2 + 1, mid + 1, end, left, right)
        return self.tree[node]
        
    def query(self, node, start, end, left, right):
        self.update_lazy(node, start, end)
        
        if end < left or start > right:
            return 0
        if left <= start and end <= right:
            return self.tree[node]
        mid = int((start + end) / 2)
        return self.query(node * 2, start, mid, left, right) + self.query(node * 2 + 1, mid + 1, end, left, right)
        


N, M = map(int, sys.stdin.readline().split())
seg = Seg(N)

for i in range(M):
    li = list(map(int, sys.stdin.readline().split()))
    
    if li[0] == 0:
        seg.update_range(1, 0, N - 1, li[1] - 1, li[2] - 1)
    else:
        print(seg.query(1, 0, N - 1, li[1] - 1, li[2] - 1))
