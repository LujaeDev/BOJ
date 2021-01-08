fun Int.pow(N: Int) = Math.pow(this.toDouble(), N.toDouble()).toInt()

fun quadSearch(y: Int, x: Int, r: Int, c: Int, size:Int, order: Int): Int{
    if(size == 1)
        return order

    val nextSize = size / 2

    val flagDown = (y + nextSize <= r)
    val flagRight = (x + nextSize <= c)
    var nextX = x
    var nextY = y
    var delta = 0

    if(flagDown){
        nextY += nextSize
        delta += 2 * nextSize * nextSize
    }
    if(flagRight){
        nextX += nextSize
        delta += nextSize * nextSize
    }

    return quadSearch(nextY, nextX, r, c, nextSize, order + delta)
}

fun main(){
    val (N, r, c) = readLine()!!.split(" ").map{it.toInt()}

    print(quadSearch(0,0, r, c, 2.pow(N), 0))
}