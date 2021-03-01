class DisjointSet:

    def __init__(self, n):
        self.parent = [i for i in range(0, n + 1)]
        self.rank = [0 for j in range(0, n + 1)]

    def find(self, u):
        if u == self.parent[u]:
            return u
        self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        u = self.find(u)
        v = self.find(v)

        if u == v:
            return

        if self.rank[u] > self.rank[v]:
            self.parent[v] = u
        elif self.rank[u] < self.rank[v]:
            self.parent[u] = v
        else:
            self.parent[v] = u
            self.rank[u] += 1


n, m = map(int, input().split(" "))

ds = DisjointSet(n)

for i in range(m):
    (c, a, b) = map(int, input().split(" "))

    if c == 0:
        ds.union(a, b)
    elif c == 1:
        a = ds.find(a)
        b = ds.find(b)

        if a == b:
            print("YES")
        else:
            print("NO")