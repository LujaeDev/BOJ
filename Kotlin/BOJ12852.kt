import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = readLine()!!.toInt()
    val INF = 987654321
    val dp = Array<Int>(N + 1){INF}

    dp[0] = -1
    dp[1] = 0

    for(i in 2..N){
        if(i % 3 == 0)
            dp[i] = minOf(dp[i], dp[i / 3])
        if(i % 2 == 0)
            dp[i] = minOf(dp[i], dp[i / 2])

        dp[i] = minOf(dp[i], dp[i - 1])
        dp[i]++
    }

    println(dp[N])

    var currentNum = N
    while(currentNum >= 1){
        bw.write("$currentNum ")

        var nextNum = currentNum

        if(currentNum % 3 == 0)
            if(dp[nextNum] > dp[currentNum / 3])
                nextNum = currentNum / 3
        if(currentNum % 2 == 0)
            if(dp[nextNum] > dp[currentNum / 2])
                nextNum = currentNum / 2
        if(dp[nextNum] > dp[currentNum - 1])
            nextNum = currentNum - 1

        currentNum = nextNum
    }

    bw.close()
}