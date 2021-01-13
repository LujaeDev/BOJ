val INF = 987654321.0

fun sol(xArray: Array<Int>, yArray: Array<Int>, xTotal: Long, yTotal: Long, N:Int, lastSelected: Int, cnt: Int):Double{
    if(N - lastSelected < N / 2 - cnt)
        return INF

    if(cnt == N / 2)
        return Math.sqrt((xTotal * xTotal + yTotal * yTotal).toDouble())

    var ret: Double = INF

    for(i in lastSelected + 1..N){
        ret = minOf(ret, sol(xArray, yArray, xTotal - 2 * xArray[i], yTotal - 2 * yArray[i], N,i, cnt + 1))
    }

    return ret
}

fun main(){
    var T = readLine()!!.toInt()

    while(T-- != 0){
        val N = readLine()!!.toInt()

        val xArray = Array<Int>(N + 1){0}
        val yArray = Array<Int>(N + 1){0}

        for(i in 1..N) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }

            xArray[i] = x
            yArray[i] = y
        }

        println("%.8f".format(sol(xArray, yArray, xArray.sum().toLong(), yArray.sum().toLong(), N, 0, 0)))
    }
}