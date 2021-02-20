MOD = 10007
cache = [[-1 for j in range(53)] for i in range(53)]


def combination(n, r):
    if n == r or r == 0:
        return 1
    else:
        return combination(n - 1, r - 1) + combination(n - 1, r)


def selectCnt(line, cnt):
    if cnt == 0:
        return 1
    elif cnt < 0 or line < 0:
        return 0
    if cache[line][cnt] != -1:
        return cache[line][cnt]

    ret = 0
    for i in range(0, 4):
        ret += combination(4, i) * selectCnt(line - 1, cnt - i)

    cache[line][cnt] = ret
    return ret


N = int(input())

ret = 0

for i in range(1, N // 4 + 1):
    if N - i * 4 > 3 * (13 - i):
        continue
    ret += combination(13, i) * selectCnt(13 - i, N - i * 4)
    ret %= MOD

print(ret)