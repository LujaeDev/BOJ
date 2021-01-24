import java.io.*

private fun distance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int{
    val dy = Math.abs(p1.first - p2.first)
    val dx = Math.abs(p1.second - p2.second)

    return dy + dx
}

private fun sol(pos: Array<Pair<Int, Int>>, N: Int){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dp = Array<Array<Int>>(pos.size){Array<Int>(3){0}}
    val choice = Array<Array<String>>(pos.size){Array<String>(3){""}}
    val posPolice1 = Array<Array<Pair<Int, Int>>>(pos.size){Array<Pair<Int, Int>>(3){Pair(0, 0)}}
    val posPolice2 = Array<Array<Pair<Int, Int>>>(pos.size){Array<Pair<Int, Int>>(3){Pair(0, 0)}}
    val W = pos.size

    dp[0][1] = distance(Pair(1, 1), pos[0])
    dp[0][2] = distance(Pair(N, N), pos[0])
    choice[0][1] = "1"
    choice[0][2] = "2"

    posPolice1[0][1] = pos[0]
    posPolice1[0][2] = Pair(1, 1)
    posPolice2[0][1] = Pair(N, N)
    posPolice2[0][2] = pos[0]

    for(i in 1 until W){
        if(dp[i - 1][1] + distance(posPolice1[i - 1][1], pos[i]) < dp[i - 1][2] + distance(posPolice1[i - 1][2], pos[i])){
            dp[i][1] = dp[i - 1][1] + distance(posPolice1[i - 1][1], pos[i])
            posPolice2[i][1] = posPolice2[i - 1][1]
            choice[i][1] = choice[i - 1][1] + "1"
        }else{
            dp[i][1] = dp[i - 1][2] + distance(posPolice1[i - 1][2], pos[i])
            posPolice2[i][1] = posPolice2[i - 1][2]
            choice[i][1] = choice[i - 1][2] + "1"
        }
        if(dp[i - 1][2] + distance(posPolice2[i - 1][2], pos[i]) < dp[i - 1][1] + distance(posPolice2[i - 1][1], pos[i])){
            dp[i][2] = dp[i - 1][2] + distance(posPolice2[i - 1][2], pos[i])
            posPolice1[i][2] = posPolice1[i - 1][2]
            choice[i][2] = choice[i - 1][2] + "2"
        }else{
            dp[i][2] = dp[i - 1][1] + distance(posPolice2[i - 1][1], pos[i])
            posPolice1[i][2] = posPolice1[i - 1][1]
            choice[i][2] = choice[i - 1][1] + "2"
        }

        posPolice1[i][1] = pos[i]
        posPolice2[i][2] = pos[i]
    }

    val last = if(dp[W - 1][1] < dp[W - 1][2]) 1 else 2

    bw.write("${dp[W - 1][last]}\n")
    for(ch in choice[W - 1][last])
        bw.write(ch + "\n")
    bw.close()
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val W = br.readLine().toInt()
    val pos = Array<Pair<Int, Int>>(W){Pair(0, 0)}

    for(i in 0 until W){
        val (SN, EW) = br.readLine().split(" ").map{it.toInt()}
        pos[i] = Pair(SN, EW)
    }

    sol(pos, N)
}