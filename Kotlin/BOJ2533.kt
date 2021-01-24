import java.io.*
private val adj = Array<ArrayList<Int>>(1000001){ArrayList<Int>() }
private val earlyAD = Array<Boolean>(1000001){false}
private val visited = Array<Boolean>(1000001){false}

private fun dfs(here: Int): Boolean{
    visited[here] = true

    for(there in adj[here]){
        if(!visited[there]){
            if(!dfs(there))
                earlyAD[here] = true
        }
    }

    return earlyAD[here]
}

private fun sol():Int{
    var ret = 0

    dfs(1)

    for(value in earlyAD)
        if(value)
            ret++

    return ret
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    repeat(N - 1){
        val (v1, v2) = br.readLine().split(" ").map{it.toInt()}

        adj[v1].add(v2)
        adj[v2].add(v1)
    }

    print(sol())
}