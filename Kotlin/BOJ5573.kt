import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (H, W, N) = readLine()!!.split(" ").map{it.toInt()}

    val path = ArrayList<ArrayList<Int>>()
    val cntVisit = Array<Array<Int>>(H + 1){Array<Int>(W + 1){0}}

    path.add(ArrayList<Int>())

    for(i in 1..H){
        path.add(ArrayList<Int>())
        path[i].add(0)

        br.readLine().split(" ").map{it.toInt()}.forEach(){
            path[i].add(it)
        }
    }

    if(N > 1){
        cntVisit[1][1] = N - 1

        for(i in 1..H) {
            for (j in 1..W) {
                if(i == 1 && j == 1)
                    continue

                cntVisit[i][j] = cntVisit[i - 1][j] / 2 + cntVisit[i][j - 1] / 2

                if (cntVisit[i - 1][j] % 2 == 1 && path[i - 1][j] == 0)
                    cntVisit[i][j]++

                if (cntVisit[i][j - 1] % 2 == 1 && path[i][j - 1] == 1)
                    cntVisit[i][j]++
            }
        }

        for(i in 1..H)
            for(j in 1..W)
                path[i][j] = (cntVisit[i][j] + path[i][j]) % 2
    }

    var i = 1
    var j = 1

    while(i <= H && j <= W){
        if(path[i][j] == 1)
            j++
        else
            i++
    }

    print("$i $j")
}