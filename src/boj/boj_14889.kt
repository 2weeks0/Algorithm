package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min
import kotlin.properties.Delegates

private lateinit var input: Array<IntArray>
private var n by Delegates.notNull<Int>()
private lateinit var visited: BooleanArray
private var answer = 100 * 20 / 2


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    input = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    visited = BooleanArray(n)

    solve(0)
    println(answer)
    close()
}

private fun solve(start: Int) {
    if (visited.count { it } == n / 2) {
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
        return
    }

    for (i in start until n) {
        if (!visited[i]) {
            visited[i] = true
            solve(i + 1)
            visited[i] = false
        }
    }
}