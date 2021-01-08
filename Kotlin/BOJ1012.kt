val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, -1, 0, 1)

fun isRange(x: Int, y:Int, M:Int, N:Int) = x in 0 until M && y in 0 until N

fun dfs(x: Int, y:Int, M:Int, N: Int, state: Array<Array<Int>>, visited:Array<Array<Int>>){
    visited[y][x] = 1

    for(i in 0..3){
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        if(isRange(nextX, nextY, M, N) && state[nextY][nextX] == 1 && visited[nextY][nextX] == 0)
            dfs(nextX, nextY, M, N, state, visited)
    }
}

fun sol(): Int{
    var ret = 0
    val (M, N, K) = readLine()!!.split(" ").map{it.toInt()}
    val state = Array<Array<Int>>(N){Array<Int>(M){0}}
    val visited = Array<Array<Int>>(N){Array<Int>(M){0}}
    val cabbageList = ArrayList<Pair<Int, Int>>()

    for(i in 1..K){
        val (x, y) = readLine()!!.split(" ").map{it.toInt()}

        state[y][x] = 1
        cabbageList.add(Pair(x, y))
    }

    for((x, y) in cabbageList)
        if(visited[y][x] == 0){
            dfs(x, y, M, N, state, visited)
            ret++
        }

    return ret
}

fun main(){
    val T = readLine()!!.toInt()

    for(i in 0 until T)
        println(sol())
}