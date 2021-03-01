from itertools import combinations


def isRange(x, y):
    return 0 <= x < M and 0 <= y < N


def dfs(visited, x , y):
    if visited[y][x] or state[y][x] == 1:
        return

    global cntT

    visited[y][x] = True
    if state[y][x] == 0:
        cntT += 1

    for i in range(4):
        if isRange(x + dx[i], y + dy[i]):
            dfs(visited, x + dx[i], y + dy[i])


def allDfs():
    visited = [[False for j in range(M)] for i in range(N)]
    global cntT
    cntT = 0

    for (i, j) in pos2:
        if not visited[i][j]:
            dfs(visited, j, i)


def sol():
    ret = 0
    com = combinations(pos0, 3)

    for com1 in com:
        for com2 in com1:
            state[com2[0]][com2[1]] = 1

        allDfs()
        ret = max(ret, len(pos0) - cntT - 3)

        for com2 in com1:
            state[com2[0]][com2[1]] = 0

    return ret


N, M = map(int, input().split(" "))
state = []
pos0 = []
pos2 = []
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

for i in range(N):
    state.append(list(map(int, input().split(" "))))

for i in range(N):
    for j in range(M):
        if state[i][j] == 0:
            pos0.append((i, j))
        elif state[i][j] == 2:
            pos2.append((i, j))

print(sol())