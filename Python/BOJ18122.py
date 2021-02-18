N = int(input())
MOD = 10 ** 9 + 7
dp = [[0, 0] for i in range(N + 1)]

dp[1][0] = 3
dp[1][1] = 2

for i in range(2, N + 1):
    dp[i][1] = (2 * dp[i - 1][1] + 2) % MOD
    dp[i][0] = (4 * dp[i - 1][1] + 3) % MOD

print(dp[N][0])