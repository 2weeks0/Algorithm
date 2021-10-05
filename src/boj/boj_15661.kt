package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    val visited = BooleanArray(n)
    var answer = 100 * 20 / 2

    fun solve(startIndex: Int) {
        var sum = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (visited[i] && visited[j]) {
                    sum += input[i][j]
                } else if (!visited[i] && !visited[j]) {
                    sum -= input[i][j]
                }
            }
        }

        answer = min(answer, abs(sum))
        if (visited.count { it } >= n / 2) {
            return
        }

        for (i in startIndex until n) {
            visited[i] = true
            solve(i + 1)
            visited[i] = false
        }
    }
    solve(0)

    println(answer)
    close()
}