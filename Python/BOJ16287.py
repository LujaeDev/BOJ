W, N = map(int, input().split(" "))
pack = list(map(int, input().split(" ")))

cache = [0 for i in range(0, 800001)]

for i in range(0, N):
    for j in range(i + 1, N):
        cache[pack[i] + pack[j]] = i

ret = False
for i in range(0, N):
    for j in range(i + 1, N):
        s = pack[i] + pack[j]

        if W - s > 0 and cache[W - s] > j:
            ret = True

print("YES" if ret else "NO")
