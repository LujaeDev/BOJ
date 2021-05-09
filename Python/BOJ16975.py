import sys
import copy

class Seg:
    def __init__(self, A, N):
        self.A = copy.deepcopy(A)
        self.tree = [0 for i in range(4 * N)]
        self.lazy = [0 for i in range(4 * N)]
        self.initTree(1, 0, N - 1)
        
    def initTree(self, node, start ,end):
        if start == end:
            self.tree[node] = self.A[start]
            return
        
        mid = int((start + end) / 2)
        self.initTree(2 * node, start, mid)
        self.initTree(2 * node + 1, mid + 1, end)
        
    def update_lazy(self, node, start, end):
        if self.lazy[node] != 0:
            if start != end:
                self.lazy[2 * node] += self.lazy[node]
                self.lazy[2 * node + 1] += self.lazy[node]
            else:
                self.tree[node] += self.lazy[node]
            self.lazy[node] = 0
            
    def update_range(self, node, start, end, left, right, K):
        self.update_lazy(node, start, end)
        
        if end < left or start > right:
            return
        if left <= start and end <= right:
            self.tree[node] += K
            if start != end:
                self.lazy[2 * node] += K
                self.lazy[2 * node + 1] += K
            return
        mid = int((start + end) / 2)
        self.update_range(2 * node, start, mid, left, right, K)
        self.update_range(2 * node + 1, mid + 1, end, left, right, K)
    
    def query(self, node, start, end, left, right):
        self.update_lazy(node, start, end)
        if left <= start and end <= right:
            return self.tree[node]
        if end < left or start > right:
            return 0
        mid = int((start + end) / 2)
        return self.query(2 * node, start, mid, left, right) + self.query(2 * node + 1, mid + 1, end, left, right)
    
N = int(input())
li = list(map(int, sys.stdin.readline().split()))
M = int(input())
seg = Seg(li, N)
for i in range(M):
    tmp = list(map(int, sys.stdin.readline().split()))
    if tmp[0] == 1:
        seg.update_range(1, 0, N - 1, tmp[1] - 1, tmp[2] - 1, tmp[3])
    else:
        print(seg.query(1, 0, N - 1, tmp[1] - 1, tmp[1] - 1))
