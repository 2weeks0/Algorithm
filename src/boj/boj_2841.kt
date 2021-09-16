package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val map = HashMap<Int, LinkedList<Int>>()
    var answer = 0

    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val p = st.nextToken().toInt()

    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        val line = st.nextToken().toInt()
        val fret = st.nextToken().toInt()
        map.putIfAbsent(line, LinkedList())

        do {
            var top = map[line]!!.peekLast()
            if (top == null || top < fret) {
                map[line]!!.addLast(fret)
                answer += 1
            } else if (top > fret) {
                top = map[line]!!.pollLast()
                answer += 1
            }
        } while (top != null && top > fret)
    }
    println(answer)
}