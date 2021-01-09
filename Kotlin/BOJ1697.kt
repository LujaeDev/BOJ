import java.util.*

fun isRange(x: Int) = x in 0..100000

fun nextPos(x: Int, idx: Int) =
        when(idx){
            1 -> x - 1
            2 -> x + 1
            else -> 2 * x
        }

fun bfs(N: Int, K:Int): Int{
    var t = 0
    val q:Queue<Int> = LinkedList<Int>()
    val discovered = Array<Boolean>(100001){false}
    val time = Array<Int>(100001){0}

    q.add(N)
    discovered[N] = true
    time[N] = 0

    while(!q.isEmpty()){
        val here = q.remove()

        if(here == K)
            break

        for(i in 1..3){
            val there = nextPos(here, i)

            if(isRange(there) && !discovered[there]) {
                discovered[there] = true
                time[there] = time[here] + 1
                q.add(there)
            }
        }
    }

    return time[K]
}

fun main(){
    val (N, K) = readLine()!!.split(" ").map{it.toInt()}

    print(bfs(N, K))
}