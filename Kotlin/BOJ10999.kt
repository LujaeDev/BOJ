import java.io.*
private val segmentTree = Array<Long>(4000000){0}
private val lazy = Array<Long>(4000000){0}

private fun init(numbers:Array<Long>, leftNode: Int, rightNode: Int, node: Int): Long{
    if(leftNode == rightNode){
        segmentTree[node] = numbers[leftNode]
        return segmentTree[node]
    }

    val mid = (leftNode + rightNode) / 2

    segmentTree[node] = init(numbers, leftNode, mid, 2 * node) + init(numbers, mid + 1, rightNode, 2 * node + 1)
    return segmentTree[node]
}

private fun propagation(leftNode: Int, rightNode: Int, node: Int){
    segmentTree[node] += (rightNode - leftNode + 1) * lazy[node]

    if(leftNode != rightNode){
        lazy[2 * node] += lazy[node]
        lazy[2 * node + 1] += lazy[node]
    }

    lazy[node] = 0
}

private fun update(left: Int, right: Int, delta: Int, leftNode: Int, rightNode: Int, node: Int): Long{
    propagation(leftNode, rightNode, node)

    if(right < leftNode || left > rightNode)
        return segmentTree[node]

    if(left <= leftNode && rightNode <= right){
        segmentTree[node] += delta * (rightNode - leftNode + 1).toLong()

        if(leftNode != rightNode) {
            lazy[2 * node] += delta.toLong()
            lazy[2 * node + 1] += delta.toLong()
        }

        lazy[node] = 0
        return segmentTree[node]
    }

    val mid = (leftNode + rightNode) / 2
    segmentTree[node] = update(left, right, delta, leftNode, mid, 2 * node) + update(left, right, delta, mid + 1, rightNode, 2 * node + 1)
    return segmentTree[node]
}

private fun query(left: Int, right: Int, leftNode: Int, rightNode: Int, node: Int): Long{
    propagation(leftNode, rightNode, node)

    if(right < leftNode || left > rightNode)
        return 0

    if(left <= leftNode && rightNode <= right)
        return segmentTree[node]

    val mid = (leftNode + rightNode) / 2

    return query(left, right, leftNode, mid, 2 * node) + query(left, right, mid + 1, rightNode, 2 * node + 1)
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M, K) = br.readLine().split(" ").map{it.toInt()}
    val numbers = Array<Long>(N){0}

    for(i in 0 until N){
        numbers[i] = br.readLine().toLong()
    }
    init(numbers, 0, N - 1, 1)

    repeat(M + K){
        val command = br.readLine().split(" ").map { it.toInt() }

        if(command[0] == 1)
            update(command[1] - 1, command[2] - 1, command[3], 0, N - 1, 1)
        else if(command[0] == 2)
            bw.write("${query(command[1] - 1, command[2] - 1, 0, N - 1, 1)}\n")
    }

    bw.close()
}