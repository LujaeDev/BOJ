fun main(){
    val(N, S) = readLine()!!.split(" ").map{it.toInt()}
    val numList = ArrayList<Int>()
    var ret = 20000000

    readLine()!!.split(" ").map{it.toInt()}.forEach(){
        numList.add(it)
    }

    if(numList.sum() < S)
        ret = 0
    else {
        var s = 0
        var e = 0
        var partSum = 0.toLong()

        while(e < N){
            while(e < N && partSum < S){
                partSum += numList[e]
                e++
            }

            if(partSum < S)
                break

            while(s < e && partSum >= S) {
                partSum -= numList[s]
                s++
            }

            ret = minOf(ret, e - s + 1)
        }
    }

    print(ret)
}