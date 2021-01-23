private val cache = Array<Array<Long>>(1 shl 15){Array<Long>(100){-1}}
private val powMOD = Array<Int>(51){0}
private val numberMOD = Array<Int>(15){0}

fun makeMODTable(numbers: Array<String>, MOD: Int){
    powMOD[1] = 10 % MOD
    for(i in 2..50)
        powMOD[i] = (powMOD[i - 1] * 10) % MOD

    for(i in numbers.indices){
        var ret = 0

        for(j in numbers[i].indices){
            ret *= 10
            ret += numbers[i][j] - '0'
            ret %= MOD
        }

        numberMOD[i] = ret
    }
}

fun sol(numbers: Array<String>, visited: Int, currentMod: Int, N: Int, K: Int): Long{
    if(visited == (1 shl N) - 1)
        return if(currentMod == 0) 1 else 0

    if(cache[visited][currentMod] != -1.toLong())
        return cache[visited][currentMod]

    var ret: Long = 0
    for(i in 0 until N){
        if(visited and (1 shl i) == 0)
            ret += sol(numbers, visited or (1 shl i), (currentMod * powMOD[numbers[i].length] + numberMOD[i]) % K, N, K)
    }

    cache[visited][currentMod] = ret
    return ret
}

fun factorial(num: Int): Long{
    if(num == 1)
        return 1

    return num * factorial(num - 1)
}

fun gcd(p: Long, q: Long): Long{
    if(q == 0.toLong()) return p
    return gcd(q, p % q)
}

fun main(){
    val N = readLine()!!.toInt()
    val numbers = Array<String>(N){""}

    for(i in numbers.indices)
        numbers[i] = readLine()!!

    val K = readLine()!!.toInt()

    makeMODTable(numbers, K)
    var numer = sol(numbers, 0, 0, N, K)
    var demo = factorial(N)

    if(numer == 0.toLong()){
        print("0/1")
    }
    else {
        val gcdOfF = gcd(numer, demo)

        numer /= gcdOfF
        demo /= gcdOfF

        print("$numer/$demo")
    }
}