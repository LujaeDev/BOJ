val MOD = 20150523

fun cntToNum(strNum: String, cntMul3:Array<Array<Int>>, pow10:Array<Int>, cntNum369: Array<Int>): Int{
    var ret = 0
    var leftMod3 = 0
    var leftHave369 = false
    val lookUp = Array<Int>(10){it - it / 3 + 1}

    for(i in strNum.indices){
        if(strNum[i] == '0')
            continue

        var digit = strNum[i] - '0'

        if(leftHave369)
            ret += (digit) * pow10[strNum.length - i - 1]
        else {
            ret += lookUp[digit - 1] * cntNum369[strNum.length - i - 1] + ((digit - 1) / 3) * ((pow10[strNum.length - i - 1]))
            ret %= MOD

            for(j in 0 until digit){
                if(j != 0 && j % 3 == 0)
                    continue

                val mod3 = (leftMod3 + j) % 3
                ret += cntMul3[strNum.length - i - 1][(3 - mod3) % 3]
                ret %= MOD
            }
        }

        ret %= MOD

        leftMod3 = (leftMod3 + digit) % 3

        if(digit % 3 == 0)
            leftHave369 = true
    }

    return ret
}

fun isFlapNum(strNum: String): Int{
    var mod3 = 0

    for(i in strNum){
        val digit = i - '0'

        if(digit == 3 || digit == 6 || digit == 9)
            return 1

        mod3 = (mod3 + digit % 3) % 3
    }

    if(mod3 == 0) return 1 else return 0
}

fun main(){
    val (A, B) = readLine()!!.split(" ")
    val cntMul3 = Array<Array<Int>>(B.length + 1){Array<Int>(3){0}}
    val pow10 = Array<Int>(B.length){0}
    val cntNum369 = Array<Int>(B.length + 1){0}
    var ret = 0

    cntMul3[0][0] = 1
    cntMul3[1][0] = 1
    cntMul3[1][1] = 3
    cntMul3[1][2] = 3
    for(i in 2 until cntMul3.size){
        cntMul3[i][0] = cntMul3[i - 1][0] + (cntMul3[i - 1][1] + cntMul3[i - 1][2]) * 3
        cntMul3[i][1] = cntMul3[i - 1][1] + (cntMul3[i - 1][0] + cntMul3[i - 1][2]) * 3
        cntMul3[i][2] = cntMul3[i - 1][2] + (cntMul3[i - 1][0] + cntMul3[i - 1][1]) * 3

        for(j in 0..2)
            cntMul3[i][j] %= MOD
    }

    pow10[0] = 1
    for(i in 1 until pow10.size)
        pow10[i] = (10 * pow10[i - 1]) % MOD

    cntNum369[1] = 3
    for(i in 2 until cntNum369.size){
        cntNum369[i] = (7 * cntNum369[i - 1] + 3 * pow10[i - 1]) % MOD
    }

    ret += isFlapNum(B)
    ret += (cntToNum(B, cntMul3, pow10, cntNum369) - cntToNum(A, cntMul3, pow10, cntNum369) + MOD) % MOD

    print(ret)
}