import itertools

posChicken = []
posHouse = []

def sol(arr, N, M):
    ret = 987654321
    combination = itertools.combinations(posChicken, M)

    for comb in combination:
        tmpRet = 0

        for ph in posHouse:
            phR = int(ph / N)
            phC = ph % N
            distance = 987654321

            for pc in comb:
                pcR = int(pc / N)
                pcC = pc % N

                distance = min(distance, abs(phR - pcR) + abs(phC - pcC))
            tmpRet += distance

        ret = min(ret, tmpRet)

    return ret

N, M = map(int, input().split())
arr = [[] for i in range(N)]

for i in range(N):
    arr[i] = list(map(int, input().split()))

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            posHouse.append(i * N + j)
        elif arr[i][j] == 2:
            posChicken.append(i * N + j)

print(sol(arr, N, M))