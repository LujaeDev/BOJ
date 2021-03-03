import sys
from sys import stdin

sys.setrecursionlimit(10 ** 5 + 10)
def treeDfs(here, currentDepth):
    depth[here] = currentDepth
    visited[here] = True

    for there in adj[here]:
        if not visited[there]:
            parent[there][0] = here
            treeDfs(there, currentDepth + 1)


N = int(input())
visited = [False for i in range(N + 1)]
depth = [0 for i in range(N + 1)]
parent = [[-1 for j in range(20)] for i in range(N + 1)]
adj = [[] for i in range(N + 1)]


for i in range(N - 1):
    u, v = map(int, stdin.readline().split(" "))

    adj[u].append(v)
    adj[v].append(u)

treeDfs(1, 0)
for i in range(1, 20):
    for j in range(1, N + 1):
        parent[j][i] = parent[parent[j][i - 1]][i - 1]

M = int(input())
for i in range(M):
    (u, v) = map(int, stdin.readline().split(" "))

    if depth[u] > depth[v]:
        tmp = u
        u = v
        v = tmp

    diff = depth[v] - depth[u]

    idx = 0
    while diff > 0:
        if diff % 2 == 1:
            v = parent[v][idx]
        diff = int(diff / 2)
        idx += 1

    if u != v:
        for j in range(19, -1, -1):
            if parent[u][j] != -1 and parent[u][j] != parent[v][j]:
                u = parent[u][j]
                v = parent[v][j]

        u = parent[u][0]

    print(u)