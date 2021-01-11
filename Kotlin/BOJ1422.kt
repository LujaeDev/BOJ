import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map{it.toInt()}

    val numberArray = Array<String>(k){""}
    var maxNum = "0"
    var ret = ""
    var flag = true

    for(i in 0 until k) {
        numberArray[i] = br.readLine()

        if(numberArray[i].toInt() > maxNum.toInt())
            maxNum = numberArray[i]
    }

    numberArray.sortedWith(
            Comparator{e1, e2->
                val minLength = minOf(e1.length, e2.length)
                val numE1 = e1.substring(0 until minLength).toInt()
                val numE2 = e2.substring(0 until minLength).toInt()

                if(numE1 == numE2) {
                    if((e1 + e2) > (e2 + e1))
                        -1
                    else
                        1
                }
                else
                    numE2 - numE1
            }
    ).forEach(){
        if(it.equals(maxNum) && flag) {
            ret += it.repeat(n - k)
            flag = false
        }
        ret += it
    }

    print(ret)
}