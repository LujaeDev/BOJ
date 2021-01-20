import java.io.*
val segmentTree = Array<Long>(4000000){0}
private val MOD = 1000000007

fun init(numbers: ArrayList<Int>, nodeLeft: Int, nodeRight: Int, node: Int): Long{
    if(nodeLeft == nodeRight) {
        segmentTree[node] = numbers[nodeLeft].toLong()
        return segmentTree[node]
    }
    val mid = (nodeLeft + nodeRight) / 2

    segmentTree[node] = (init(numbers, nodeLeft, mid, 2 * node) * init(numbers, mid + 1, nodeRight, 2 * node + 1)) % MOD
    return segmentTree[node]
}

fun update(idx: Int, newValue: Int, nodeLeft: Int, nodeRight: Int, node: Int): Long{
    if(idx == nodeLeft && idx == nodeRight){
        segmentTree[node] = newValue.toLong()
        return segmentTree[node]
    }

    if(idx < nodeLeft || idx > nodeRight)
        return segmentTree[node]

    val mid = (nodeLeft + nodeRight) / 2
    segmentTree[node] = (update(idx, newValue, nodeLeft, mid, 2 * node) * update(idx, newValue, mid + 1, nodeRight, 2 * node + 1)) % MOD
    return segmentTree[node]
}

fun query(left: Int, right: Int, nodeLeft: Int, nodeRight: Int, node: Int): Long{
    if(right < nodeLeft || left > nodeRight)
        return 1

    if(left <= nodeLeft && nodeRight <= right)
        return segmentTree[node]

    val mid = (nodeLeft + nodeRight) / 2

    return (query(left, right, nodeLeft, mid, 2 * node) * query(left, right, mid + 1, nodeRight, 2 * node + 1)) % MOD
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M, K) = br.readLine().split(" ").map{it.toInt()}
    val numbers = ArrayList<Int>()

    repeat(N){
        val num = br.readLine().toInt()
        numbers.add(num)
    }

    init(numbers, 0, N - 1, 1)
    repeat(M + K){
        val(a, b, c) = br.readLine().split(" ").map{it.toInt()}

        if(a == 1)
            update(b - 1, c, 0, N - 1, 1)
        else if(a == 2)
            bw.write("${query(b - 1, c - 1, 0, N - 1, 1)}\n")
    }

    bw.close()
}