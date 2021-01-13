import java.io.*
import java.util.*

data class Info(var M: Int, var V: Int)

fun sol(infoArray: Array<Info>, bag: Array<Int>):Long{
    val pq = PriorityQueue<Info>(Comparator(){e1, e2-> e2.V - e1.V})
    var ret = 0.toLong()
    var idx = 0

    for(i in bag.indices){
        while(idx < infoArray.size && infoArray[idx].M <= bag[i])
            pq.add(infoArray[idx++])

        if(pq.isEmpty())
            continue

        ret += pq.remove().V.toLong()
    }

    return ret
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map{it.toInt()}
    val infoArray = Array<Info>(N){Info(0, 0)}
    val bag = Array<Int>(K){0}

    for(i in 0 until N){
        val (m, v) = br.readLine().split(" ").map{it.toInt()}

        infoArray[i].M = m
        infoArray[i].V = v
    }

    for(i in 0 until K)
        bag[i] = br.readLine().toInt()

    infoArray.sortBy{it.M}
    bag.sort()

    println(sol(infoArray, bag))
}