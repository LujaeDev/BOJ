MOD = 1000000007

N = int(input())
arr = sorted(list(map(int, input().split(" "))))

pow2 = [0 for i in range(0, N)]

pow2[0] = 1
for i in range(1, N):
    pow2[i] = (pow2[i - 1] * 2) % MOD

ret = 0
for i in range(0, N):
    ret -= arr[i] * (pow2[N - (i + 1)] - 1) % MOD
    ret %= MOD

    if i != 0:
        ret += arr[i] * (pow2[i] - 1) % MOD
        ret %= MOD

print(ret)