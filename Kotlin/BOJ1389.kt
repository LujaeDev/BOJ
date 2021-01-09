import java.io.*

val INF = 102

fun makeAdjList(): Array<Array<Int>>{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = readLine()!!.split(" ").map{it.toInt()}
    var adj = Array<Array<Int>>(N + 1){Array<Int>(N + 1){INF}}

    for(i in 1..M){
        val (v1, v2) = br.readLine().split(" ").map{it.toInt()}

        adj[v1][v2] = 1
        adj[v2][v1] = 1
    }

    return adj
}

fun floyd(adj: Array<Array<Int>>, N: Int){
    for(i in 1..N) {
        adj[i][i] = 0
        adj[i][0] = 0
    }

    for(k in 1..N)
        for(i in 1..N)
            for(j in 1..N)
                adj[i][j] = minOf(adj[i][j], adj[i][k] + adj[k][j])
}

fun main(){
    var adj = makeAdjList()
    floyd(adj, adj.size - 1)

    var minIndex = 1
    var minValue = 0

    minValue = adj[1].sum()

    for(i in 2 until adj.size) {
        if (minValue > adj[i].sum()) {
            minIndex = i
            minValue = adj[i].sum()
        }
    }

    print(minIndex)
}