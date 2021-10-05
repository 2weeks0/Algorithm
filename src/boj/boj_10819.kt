package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())
    val input = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }.sorted()
    val visited = BooleanArray(n)
    var answer = -1
    val list = LinkedList<Int>()

    fun dfs() {
        if (list.size == n) {
            var sum = 0
            for (i in 0 until list.lastIndex) {
                sum += abs(list[i] - list[i + 1])
            }
            answer = max(answer, sum)
            return
        }

        for (i in input.indices) {
            if (!visited[i]) {
                visited[i] = true
                list.addLast(input[i])
                dfs()
                list.pollLast()
                visited[i] = false
            }
        }
    }
    dfs()

    println(answer)
    close()
}