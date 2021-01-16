import java.io.*

fun sol(enemy: Array<ArrayList<Int>>, W: Int): Int{
    val N = enemy[0].size
    val INF = W + 1
    val dp = Array<Array<Int>>(N + 1){ Array<Int>(4){0} }
    var maxPair = 0
    val canCircle = Array<Boolean>(4){false}
    val rightE0 = enemy[0][N - 1]
    val rightE1 = enemy[1][N - 1]

    if(N == 1){
        maxPair = if(W >= enemy[0][0] + enemy[1][0]) 1 else 0
    }else {
        canCircle[0] = true
        canCircle[1] = W >= enemy[0][0] + enemy[0][N - 1]
        canCircle[2] = W >= enemy[1][0] + enemy[1][N - 1]
        canCircle[3] = canCircle[1] && canCircle[2]

        for (k in canCircle.indices) {
            if (!canCircle[k])
                continue

            enemy[0][N - 1] = rightE0
            enemy[1][N - 1] = rightE1

            for (i in 1..3)
                dp[0][i] = 0

            if (k == 1) {
                dp[0][2] = 1
                enemy[0][N - 1] = INF
            } else if (k == 2) {
                dp[0][1] = 1
                enemy[1][N - 1] = INF
            } else if (k == 3) {
                dp[0][3] = 2
                enemy[0][N - 1] = INF
                enemy[1][N - 1] = INF
            }

            dp[0][3] = maxOf(dp[0][3], if (W >= enemy[0][0] + enemy[1][0]) 1 else 0)

            for (i in 1 until N) {
                dp[i][0] = dp[i - 1].maxOrNull()!!
                dp[i][1] = if (W >= enemy[1][i - 1] + enemy[1][i]) maxOf(dp[i - 1][0], dp[i - 1][2]) + 1 else 0
                dp[i][2] = if (W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp[i - 1][0], dp[i - 1][1]) + 1 else 0
                dp[i][3] = if (W >= enemy[0][i] + enemy[1][i]) dp[i][0] + 1 else 0
                dp[i][3] = if (W >= enemy[1][i - 1] + enemy[1][i] && W >= enemy[0][i - 1] + enemy[0][i]) maxOf(dp[i][3], dp[i - 1][0] + 2) else dp[i][3]
            }

            maxPair = maxOf(maxPair, dp[N - 1].maxOrNull()!!)
        }
    }

    return 2 * N - maxPair
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T){
        val (N, W) = br.readLine().split(" ").map{it.toInt()}

        val enemy = Array<ArrayList<Int>>(2){ArrayList<Int>()}

        for(i in 0 until 2) {
            br.readLine().split(" ").map { it.toInt() }.forEach(){
                enemy[i].add(it)
            }
        }

        println(sol(enemy, W))
    }
}
