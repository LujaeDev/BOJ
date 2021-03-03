N = int(input())
li = list(map(int, input().split(" ")))

dp = [[-1 for j in range(500001)]for i in range(N + 1)]

dp[0][0] = 0
dp[0][li[0]] = li[0]

for i in range(1, N):
    for j in range(250001):
        if dp[i - 1][j] == -1:
            continue

        dp[i][j] = max(dp[i][j], dp[i - 1][j])

        if j + li[i] <= 250000:
            dp[i][j + li[i]] = max(dp[i][j + li[i]], dp[i - 1][j] + li[i])

        if -250000 <= j - li[i] < 0:
            dp[i][-(j - li[i])] = max(dp[i][-(j - li[i])], dp[i - 1][j] - (j - li[i]))
        else:
            dp[i][j - li[i]] = max(dp[i][j - li[i]], dp[i - 1][j])

print(-1 if dp[N - 1][0] <= 0 else dp[N - 1][0])