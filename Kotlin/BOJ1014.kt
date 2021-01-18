private var cache =  Array<Array<Int>>(1){Array<Int>(1){0}}
private var basicState = Array<Int>(1){0}

fun updateNextRowState(nextRowState: Int, rowStep: Int, N: Int): Int{
    var ret = nextRowState

    for(i in -1..1)
        if((rowStep + i) in 0 until N)
            ret = ret and (1 shl (rowStep + i)).inv()

    return ret
}

fun sol(rowStep: Int, currentRowState: Int, nextRowState: Int, colStep: Int, N: Int): Int{
    if(colStep == cache.size)
        return 0

    if(rowStep == N){
        if(cache[colStep][currentRowState] != -1)
            return cache[colStep][currentRowState]

        var cnt1 = 0

        for(i in 0 until N)
            if(currentRowState and (1 shl i) != 0)
                cnt1++

        cache[colStep][currentRowState] = cnt1 + sol(0, nextRowState, basicState[colStep + 2], colStep + 1, N)
        return cache[colStep][currentRowState]
    }

    var ret = 0

    ret = maxOf(ret, sol(rowStep + 1, currentRowState and (1 shl rowStep).inv(), nextRowState, colStep, N))

    if(currentRowState and (1 shl rowStep) != 0) {
        ret = maxOf(ret,sol(rowStep + 1, currentRowState, updateNextRowState(nextRowState, rowStep, N), colStep, N))
    }

    return ret
}

fun main(){
    val C = readLine()!!.toInt()

    repeat(C){
        val (N, M) = readLine()!!.split(" ").map{it.toInt()}
        val state = Array<Array<Char>>(N){Array<Char>(M){'.'} }

        for(i in state.indices){
            val line = readLine()!!

            for(j in state[0].indices)
                state[i][j] = line[j]
        }

        cache = Array<Array<Int>>(M){Array<Int>(1 shl N){-1}}
        basicState = Array<Int>(M + 3){0}

        for(i in 0 until M){
            for(j in 0 until N)
                if(state[j][i] == '.')
                    basicState[i] = basicState[i] or (1 shl j)
        }

        println(sol(0, basicState[0], basicState[1], 0, N))
    }

}
