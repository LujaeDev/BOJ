fun cntOneToBinaryNum(binaryNum: String, dp: Array<Long>): Long{
    var cnt = 0.toLong()
    var frontCntOfOne = 0

    for(i in binaryNum.indices){
        if(binaryNum[i] == '1') {
            cnt += dp[binaryNum.length - i - 1] + frontCntOfOne * Math.pow(2.toDouble(), binaryNum.length - i - 1.toDouble()).toLong()
            frontCntOfOne++
        }
    }

    return cnt
}

fun main(){
    val (A, B) = readLine()!!.split(" ").map{it.toLong()}
    val binaryOfA = A.toString(2)
    val binaryOfB = B.toString(2)
    val dp = Array<Long>(binaryOfB.length + 1){0}
    var ret = binaryOfB.count(){it == '1'}.toLong()

    dp[0] = 0
    dp[1] = 1

    for(i in 2 until binaryOfB.length)
        dp[i] = dp[i - 1] * 2 + Math.pow(2.toDouble(), (i - 1).toDouble()).toLong()

    ret += cntOneToBinaryNum(binaryOfB, dp)
    ret -= cntOneToBinaryNum(binaryOfA, dp)

    print(ret)
}