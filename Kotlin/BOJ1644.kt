fun main(){
    val N = readLine()!!.toInt()
    val dp = Array<Int>(N + 1){0}
    val prime = Array<Boolean>(N + 1){true}
    val primeList = ArrayList<Int>()

    for(i in 2..Math.sqrt(N.toDouble()).toInt()){
        if(!prime[i])
            continue

        for(j in i * i .. N step i)
            prime[j] = false
    }

    for(i in 2..N)
        if(prime[i])
            primeList.add(i)

    var ret = 0
    var s = 0
    var e = 0
    var partSum = 0

    while(e < primeList.size){
        while(e < primeList.size && partSum < N)
            partSum += primeList[e++]

        if(partSum < N)
            break

        while(s < e && partSum > N)
            partSum -= primeList[s++]

        if(partSum == N) {
            ret++

            partSum -= primeList[s++]
        }
    }

    print(ret)
}