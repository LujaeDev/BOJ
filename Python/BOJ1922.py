from sys import stdin
from queue import PriorityQueue


def prim(adj):
    dist = [987654321 for i in range(len(adj))]
    belong = [False for i in range(len(adj))]

    pq = PriorityQueue()
    ret = 0

    belong[1] = True
    for (j, w) in adj[1]:
        pq.put((w, j))

    while not pq.empty():
        (cost, here) = pq.get()

        if cost > dist[here] or belong[here]:
            continue

        ret += cost
        belong[here] = True

        for (v, w) in adj[here]:
            if w < dist[v] and not belong[v]:
                dist[v] = w
                pq.put((w, v))

    return ret


N = int(input())
M = int(input())

adj = [[] for i in range(N + 1)]

for i in range(M):
    u, v, w = map(int, stdin.readline().split(" "))
    adj[u].append((v, w))
    adj[v].append((u, w))

print(prim(adj))