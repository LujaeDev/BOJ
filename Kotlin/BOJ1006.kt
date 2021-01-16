import java.io.*

fun sol(enemy: Array<List<Int>>, W: Int): Int{
    val N = enemy[0].size

    val dp = Array<Array<Int>>(N + 1){ Array<Int>(4){0} }
    val dp2 = Array<Array<Int>>(N + 1){ Array<Int>(4){0} }

    dp[0][0] = if(W >= enemy[0][N - 1] + enemy[1][N - 1]) 1 else 0
    dp[0][1] = if(W >= enemy[1][0] + enemy[1][N - 1]) 1 else 0
    dp[0][2] = if(W >= enemy[0][0] + enemy[0][N - 1]) 1 else 0
    dp[0][3] = maxOf(if(W >= enemy[0][0] + enemy[1][0]) 1 else 0, if(dp[0][1] + dp[0][2] == 2) 2 else 0)

    for(i in 1 until N - 1){
        dp[i][0] = dp[i - 1].maxOrNull()!!
        dp[i][1] = if(W >= enemy[1][i - 1] + enemy[1][i]) maxOf(dp[i - 1][0], dp[i - 1][2]) + 1 else 0
        dp[i][2] = if(W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp[i - 1][0], dp[i - 1][1]) + 1 else 0
        dp[i][3] = if(W >= enemy[0][i] + enemy[1][i]) dp[i][0] + 1 else 0
        dp[i][3] = if(W >= enemy[1][i - 1] + enemy[1][i] && W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp[i][3], dp[i - 1][0] + 2) else dp[i][3]
    }

    dp2[0][0] = 0
    dp2[0][3] = if(W >= enemy[0][0] + enemy[1][0]) 1 else 0

    for(i in 1 until N){
        dp2[i][0] = dp2[i - 1].maxOrNull()!!
        dp2[i][1] = if(W >= enemy[1][i - 1] + enemy[1][i]) maxOf(dp2[i - 1][0], dp2[i - 1][2]) + 1 else 0
        dp2[i][2] = if(W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp2[i - 1][0], dp2[i - 1][1]) + 1 else 0
        dp2[i][3] = if(W >= enemy[0][i] + enemy[1][i]) dp2[i][0] + 1 else 0
        dp2[i][3] = if(W >= enemy[1][i - 1] + enemy[1][i] && W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp2[i][3], dp2[i - 1][0] + 2) else dp2[i][3]
    }

    return 2 * N - maxOf(dp[N - 2].maxOrNull()!!, dp2[N - 1].maxOrNull()!!)
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
