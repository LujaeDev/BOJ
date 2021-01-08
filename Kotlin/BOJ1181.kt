import java.io.*

class Com: Comparator<String>{
    override fun compare(o1: String, o2: String) =
            if(o1.length != o2.length)
                o1.length - o2.length
            else
                o1.compareTo(o2)
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    var words = ArrayList<String>()

    words = ArrayList<String>(4)

    for(i in 0..N-1)
        words.add(br.readLine())

    words.sortWith(Com())

    val distinctWords = words.distinct()

    for(i in distinctWords)
        bw.write(i + "\n")

    bw.close()
}
