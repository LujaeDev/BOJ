fun sol(strN: String, dp: Array<Array<Long>>){
    val ret = Array<Long>(10){0}
    val leftCnt = Array<Int>(10){0}

    val cnt0 = Array<Long>(strN.length + 1){0}
    cnt0[1] = 0

    for(i in 2..strN.length)
        cnt0[i] = 9 * dp[i - 1][0] + cnt0[i - 1]

    ret[0] = cnt0[strN.length - 1] - dp[strN.length - 1][0]

    for(i in strN.indices){
        val digit = strN[i] - '0'

        ret[digit]++

        if(digit != 0){
            for(k in 0..9)
                ret[k] += (digit) * dp[strN.length - i - 1][k]

            for(k in (if(i == 0) 1 else 0) until digit)
                ret[k] += Math.pow(10.toDouble(), (strN.length - i - 1).toDouble()).toLong()

            for(k in 0..9)
                ret[k] += (digit) * leftCnt[k] * Math.pow(10.toDouble(), (strN.length - i - 1).toDouble()).toLong()
        }

        leftCnt[digit]++
    }

    for(i in ret.indices)
        print("${ret[i]} ")
}

fun main(){
    val strN = readLine()!!

    val dp = Array<Array<Long>>(strN.length + 1){Array<Long>(10){0} }

    for(i in 0..9)
        dp[1][i] = 1

    for(i in 2 until strN.length){
        for(j in 0..9)
            dp[i][j] = 10 * dp[i - 1][j] + Math.pow(10.toDouble(), (i - 1).toDouble()).toLong()
    }

    sol(strN, dp)
}