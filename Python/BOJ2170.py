from sys import stdin

N = int(input())
li = []

for i in range(N):
    x, y = map(int, stdin.readline().split(" "))
    li.append((x, y))

li.sort(key = lambda x : x[0])

s, e = li[0][0], li[0][1]
ret = e - s

for element in li:
    eStart = element[0]
    eEnd = element[1]

    if eStart >= e:
        ret += eEnd - eStart
        e = eEnd
    elif eEnd > e:
        ret += eEnd - e
        e = eEnd

print(ret)