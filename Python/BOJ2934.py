import sys


class Seg:
    def __init__(self, N):
        self.tree = [0 for i in range(4 * (N + 1))]

    def update_lazy(self, node, s, e, l, r):
        if self.tree[node] != 0:
            if s != e:
                self.tree[2 * node] += self.tree[node]
                self.tree[2 * node + 1] += self.tree[node]
                self.tree[node] = 0

    def update_range(self, node, s, e, l, r):
        self.update_lazy(node, s, e, l, r)

        if e < l or s > r:
            return
        if l <= s and e <= r:
            if s != e:
                self.tree[2 * node] += 1
                self.tree[2 * node + 1] += 1

            return
        
        mid = int((s + e) / 2)
        self.update_range(2 * node, s, mid, l, r)
        self.update_range(2 * node + 1, mid + 1, e, l , r)
        
    def query(self, node, s, e, pos):
        self.update_lazy(node, s, e, pos, pos)
        
        if s > pos or e < pos:
            return 0
        
        if s == e:
            ret = self.tree[node]
            self.tree[node] = 0
            return ret
        
        mid = int((s + e) / 2)
        return self.query(2 * node, s, mid, pos) + self.query(2 * node + 1, mid + 1, e, pos)

N = 100000
M = int(input())
seg = Seg(N)

for i in range(M):
    L, R = map(int, sys.stdin.readline().split())
    
    if R > L + 1:
        seg.update_range(1, 1, N, L + 1, R - 1)
        
    cntL1 = seg.query(1, 1, N, L)
    cntR1 = seg.query(1, 1, N, R)
    
    print(cntL1 + cntR1)
