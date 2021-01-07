fun sol(str: String): Boolean{
    val ch = arrayOf("w", "o", "l", "f")
    var strIdx = 0

    while(strIdx < str.length){
        var cnt = 0

        if(str[strIdx] != 'w')
            return false

        while (strIdx + cnt < str.length && str[strIdx + cnt] == 'w')
            cnt++

        if(strIdx + 4 * cnt - 1 >= str.length)
            return false

        for(i in 0..3){
            val start = strIdx + cnt * i
            val end = start + cnt

            if(!(str.substring(start, end).equals(ch[i].repeat(cnt))))
                return false
        }

        strIdx += 4 * cnt
    }

    return true
}

fun main(){
    val str = readLine()!!

    if(sol(str))
        print(1)
    else
        print(0)
}