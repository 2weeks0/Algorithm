package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val answer = Array(n) { -1 }
    val stack = LinkedList<Pair<Int, Int>>()
    val stringTokenizer = StringTokenizer(readLine())
    for (i in 0 until n) {
        val num = Pair(i, stringTokenizer.nextToken().toInt())
        while (stack.isNotEmpty() && stack.peekLast().second < num.second) {
            answer[stack.pollLast().first] = num.second
        }
        stack.addLast(num)
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (i in answer) {
        bufferedWriter.append("$i ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}
