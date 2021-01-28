import java.io.*

private fun distance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int{
    val dy = Math.abs(p1.first - p2.first)
    val dx = Math.abs(p1.second - p2.second)

    return dy + dx
}

private fun sol(pos: Array<Pair<Int, Int>>, N: Int){
    val INF = 1000000001
    val W = pos.size
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dp = Array<Array<Int>>(W){Array<Int>(W){INF}}
    val choice = Array<Array<Pair<Int, Int>>>(W){Array<Pair<Int, Int>>(W){Pair(-1, -1)}}

    dp[2][1] = distance(pos[0], pos[2])
    dp[0][2] = distance(pos[1], pos[2])

    choice[2][1] = Pair(0, 1)
    choice[0][2] = Pair(0, 1)
    
    for(step in 3 until W){
        for(i in 0 until step) {
            if(dp[step][i] > dp[step - 1][i] + distance(pos[step - 1], pos[step])){
                dp[step][i] = dp[step - 1][i] + distance(pos[step - 1], pos[step])
                choice[step][i] = Pair(step - 1, i)
            }
            if(dp[i][step] > dp[i][step - 1] + distance(pos[step - 1], pos[step])){
                dp[i][step] = dp[i][step - 1] + distance(pos[step - 1], pos[step])
                choice[i][step] = Pair(i, step - 1)
            }
            if(dp[step][step - 1] > dp[i][step - 1] + distance(pos[i], pos[step])){
                dp[step][step - 1] = dp[i][step - 1] + distance(pos[i], pos[step])
                choice[step][step - 1] = Pair(i, step - 1)
            }
            if(dp[step - 1][step] > dp[step - 1][i] + distance(pos[i], pos[step])){
                dp[step - 1][step] = dp[step - 1][i] + distance(pos[i], pos[step])
                choice[step - 1][step] = Pair(step - 1, i)
            }
        }
    }

    var ret = INF
    var lastPos = Pair(0, 0)
    var tmpPos = Pair(0 , 0)
    var retSeq = Array<Int>(W - 2){0}

    for(i in 0 until W){
        if(ret > dp[i][W - 1]){
            ret = dp[i][W - 1]
            lastPos = Pair(i, W - 1)
        }
    }
    for(i in 0 until W){
        if(ret > dp[W - 1][i]){
            ret = dp[W - 1][i]
            lastPos = Pair(W - 1, i)
        }
    }

    tmpPos = lastPos
    for(i in W - 3 downTo 0){
        val nextPos = choice[tmpPos.first][tmpPos.second]
        retSeq[i] = if(nextPos.first == tmpPos.first) 2 else 1
        tmpPos = nextPos
    }

    bw.write("${ret}\n")
    for(i in retSeq.indices)
        bw.write("${retSeq[i]}\n")

    bw.close()
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val W = br.readLine().toInt()
    val pos = Array<Pair<Int, Int>>(W + 2){Pair(0, 0)}

    pos[0] = Pair(1, 1)
    pos[1] = Pair(N, N)

    for(i in 2 until W + 2){
        val (SN, EW) = br.readLine().split(" ").map{it.toInt()}
        pos[i] = Pair(SN, EW)
    }

    sol(pos, N)
}
