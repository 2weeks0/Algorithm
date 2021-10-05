package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

const val MAX_COST = 10000000
private var answer = MAX_COST

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val cost = Array(n) {
        val stringTokenizer = StringTokenizer(readLine())
        IntArray(n) {
            stringTokenizer.nextToken().toInt()
        }
    }
    val visited = BooleanArray(n)
    val list = LinkedList<Int>()

    dfs(n, list, cost, visited)

    println(answer)
    close()
}

private fun dfs(n: Int, list: LinkedList<Int>, cost: Array<IntArray>, visited: BooleanArray) {
    if (list.size == n) {
        var sum = 0
        for (i in list.indices) {
            val c = if (i == list.lastIndex) {
                cost[list[i]][list.first]
            } else {
                cost[list[i]][list[i + 1]]
            }

            if (c == 0) {
                return
            }

            sum += c
        }
        answer = min(answer, sum)
        return
    }

    for (i in 0 until n) {
        if (!visited[i] && (list.isEmpty() || cost[list.peekLast()][i] != 0)) {
            visited[i] = true
            list.addLast(i)
            dfs(n, list, cost, visited)
            list.pollLast()
            visited[i] = false
        }
    }
}