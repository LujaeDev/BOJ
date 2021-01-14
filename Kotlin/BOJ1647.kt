import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun sol(adj: ArrayList<ArrayList<Pair<Int, Int>>>): Int{
    val pq = PriorityQueue<Pair<Int, Int>>(Comparator(){ o1, o2 ->  o1.second - o2.second})
    val INF = 987654321
    val d = Array<Int>(adj.size){INF}
    val visited = Array<Boolean>(adj.size){false}

    d[0] = 0
    d[1] = 0
    pq.add(Pair(1, 0))

    while(!pq.isEmpty()){
        val p = pq.remove()
        val here = p.first

        if(p.second > d[here])
            continue

        visited[here] = true

        for(i in adj[here]){
            val there = i.first

            if(i.second < d[there] && !visited[there]){
                d[there] = i.second
                pq.add(Pair(there, d[there]))
            }
        }
    }

    return d.sum() - d.maxOrNull()!!
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map{it.toInt()}

    val adj = ArrayList<ArrayList<Pair<Int, Int>>>()

    for(i in 0..N)
        adj.add(ArrayList<Pair<Int, Int>>())

    repeat(M){
        val (v1, v2, w) = br.readLine().split(" ").map{it.toInt()}

        adj[v1].add(Pair(v2, w))
        adj[v2].add(Pair(v1, w))
    }

    print(sol(adj))
}