import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s1 = HashSet<String>()
    val s2 = HashSet<String>()

    val (N, M) = readLine()!!.split(" ").map{it.toInt()}

    for(i in 1..N)
        s1.add(br.readLine())

    for(i in 1..M)
        s2.add(br.readLine())

    bw.write(s1.intersect(s2).size.toString() + "\n")
    s1.intersect(s2).sorted().forEach{
        bw.write("$it\n")
    }

    bw.close()
}