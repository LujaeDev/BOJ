MOD = 10007
cache = [[-1 for j in range(53)] for i in range(53)]
dp = [[-1 for j in range(53)] for i in range(53)]


def combination(n, r):
    if n == r or r == 0:
        return 1
    if cache[n][r] != -1:
        return cache[n][r]

    cache[n][r] = combination(n - 1, r - 1) + combination(n - 1, r)
    return cache[n][r]


def cal(line, num):
    if num == 0:
        return 1
    elif num < 0 or line == 0:
        return 0
    if dp[line][num] != -1:
        return dp[line][num]

    ret = 0
    for i in range(0, 4):
        ret += combination(4, i) * cal(line - 1, num - i)

    dp[line][num] = ret
    return ret


N = int(input())
print(0 if N < 4 else (combination(52, N) - cal(13, N)) % MOD)
