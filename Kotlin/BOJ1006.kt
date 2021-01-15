import java.io.*

fun sol(enemy: Array<List<Int>>, W: Int): Int{
    val N = enemy[0].size
    var ret = 0
    var usedLast0 = false
    var usedLast1 = false

    val dp = Array<Int>(N + 1){0}
    val flag = Array<Array<Boolean>>(2){Array<Boolean>(N){false}}

    dp[0] = if(W >= enemy[0][0] + enemy[1][0]) 1 else 0
    flag[0][0] = dp[0] == 1
    flag[1][0] = dp[0] == 1

    if(N > 1) {
        dp[1] = dp[0] + if (W >= enemy[0][1] + enemy[1][1]) 1 else 0
        dp[1] = maxOf(dp[1], if (W >= enemy[0][0] + enemy[0][1]) 1 else 0 + if (W >= enemy[1][0] + enemy[1][1]) 1 else 0)

        if ((dp[0] + if (W >= enemy[0][1] + enemy[1][1]) 1 else 0) == if (W >= enemy[0][0] + enemy[0][1]) 1 else 0 + if (W >= enemy[1][0] + enemy[1][1]) 1 else 0) {
            val cnt1 = if (flag[0][0]) 1 else 0 + if (flag[1][0]) 1 else 0
            val cnt2 = if (W >= enemy[0][0] + enemy[0][1]) 1 else 0 + if (W >= enemy[1][0] + enemy[1][1]) 1 else 0

            if (cnt2 <= cnt1) {
                flag[0][1] = W >= (enemy[0][0] + enemy[0][1])
                flag[1][1] = W >= (enemy[1][0] + enemy[1][1])
            } else {
                flag[0][1] = flag[0][0]
                flag[1][1] = flag[1][0]
            }
        } else if (dp[1] == if (W >= enemy[0][0] + enemy[0][1]) 1 else 0 + if (W >= enemy[1][0] + enemy[1][1]) 1 else 0) {
            flag[0][1] = W >= enemy[0][0] + enemy[0][1]
            flag[1][1] = W >= enemy[1][0] + enemy[1][1]
        } else {
            flag[0][1] = flag[0][0]
            flag[1][1] = flag[1][0]
        }

        for (i in 2 until N) {
            dp[i] = dp[i - 1] + if (W >= enemy[0][i] + enemy[1][i]) 1 else 0
            dp[i] = maxOf(dp[i], dp[i - 2] + if (W >= enemy[0][i - 1] + enemy[0][i]) 1 else 0 + if (W >= enemy[1][i - 1] + enemy[1][i]) 1 else 0)

            if ((dp[i - 1] + if (W >= enemy[0][i] + enemy[1][i]) 1 else 0) == dp[i - 2] + if (W >= enemy[0][i - 1] + enemy[0][i]) 1 else 0 + if (W >= enemy[1][i - 1] + enemy[1][i]) 1 else 0) {
                val cnt1 = if (flag[0][i - 1]) 1 else 0 + if (flag[1][i - 1]) 1 else 0
                val cnt2 = if (flag[0][i - 2]) 1 else 0 + if (flag[1][i - 2]) 1 else 0

                if (cnt2 <= cnt1) {
                    flag[0][i] = flag[0][i - 2]
                    flag[1][i] = flag[1][i - 2]

                    usedLast0 = W >= enemy[0][i - 1] + enemy[0][i]
                    usedLast1 = W >= enemy[1][i - 1] + enemy[1][i]
                } else {
                    flag[0][i] = flag[0][i - 1]
                    flag[1][i] = flag[1][i - 1]

                    usedLast0 = W >= enemy[0][i] + enemy[1][i]
                    usedLast1 = W >= enemy[0][i] + enemy[1][i]
                }
            } else if (dp[i] == dp[i - 2] + if (W >= enemy[0][i - 1] + enemy[0][i]) 1 else 0 + if (W >= enemy[1][i - 1] + enemy[1][i]) 1 else 0) {
                flag[0][i] = flag[0][i - 2]
                flag[1][i] = flag[1][i - 2]


                usedLast0 = W >= enemy[0][i - 1] + enemy[0][i]
                usedLast1 = W >= enemy[1][i - 1] + enemy[1][i]
            } else {
                flag[0][i] = flag[0][i - 1]
                flag[1][i] = flag[1][i - 1]

                usedLast0 = W >= enemy[0][i] + enemy[1][i]
                usedLast1 = W >= enemy[0][i] + enemy[1][i]
            }
        }
    }
    dp[N] = dp[N - 1]

    if(N > 1) {
        if (!flag[0][N - 1] && !usedLast0)
            dp[N] += if (W >= enemy[0][N - 1] + enemy[0][0]) 1 else 0
        if (!flag[1][N - 1] && !usedLast1)
            dp[N] += if (W >= enemy[1][N - 1] + enemy[1][0]) 1 else 0
    }
    return 2 * N - dp[N]
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T){
        val (N, W) = br.readLine().split(" ").map{it.toInt()}

        val enemy = Array<List<Int>>(2){List<Int>(N + 1){0} }

        for(i in 0 until 2)
            enemy[i] = br.readLine().split(" ").map { it.toInt()}

        println(sol(enemy, W))
    }
}
