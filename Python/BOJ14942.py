import sys


def initParent(here):
    visited[here] = True

    for there, d in adj[here]:
        if visited[there]:
            continue
            
        p[there][0] = here
        dist[there][0] = d
        initParent(there)

        
def sol(st):
    currentEnergy = 0
    here = st
    
    for i in range(19, -1, -1):
        if energy[st] >= currentEnergy + dist[here][i]:
            currentEnergy += dist[here][i]
            ret = p[here][i]
            here = p[here][i]

    return here
    

n = int(input())
energy = [0]
adj = [[] for i in range(n + 1)]
p = [[-1 for j in range(20)] for i in range(n + 1)]
visited = [False for i in range(n + 1)]
dist = [[0 for j in range(20)] for i in range(n + 1)]

for i in range(n):
    energy.append(int(sys.stdin.readline()))

for i in range(n - 1):
    a, b, c = map(int, sys.stdin.readline().split(" "))
    
    adj[a].append((b, c))
    adj[b].append((a, c))
    
initParent(1)
    
for i in range(1, 20):
    for j in range(1, n + 1):
        if p[j][i - 1] != -1:
            p[j][i] = p[p[j][i - 1]][i - 1]

dist[1][0] = 987654321
for i in range(1, 20):
    for j in range(1, n + 1):
        if p[j][i - 1] != -1:
            dist[j][i] = dist[j][i - 1] + dist[p[j][i - 1]][i - 1]
        else:
            dist[j][i] = 987654321
    
for i in range(1, n + 1):
    print(sol(i))
