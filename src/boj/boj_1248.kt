package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var string = readLine()
    val input = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        for (j in i until n) {
            input[i][j] = string.first()
            string = string.substring(1)
        }
    }
    var end = false
    val array = IntArray(n)

    fun possible(depth: Int): Boolean {
        var sum = 0
        for (i in depth downTo 0) {
            sum += array[i]
            when {
                input[i][depth] == '-' && sum >= 0 -> return false
                input[i][depth] == '+' && sum <= 0 -> return false
                input[i][depth] == '0' && sum != 0 -> return false
            }
        }
        return true
    }

    fun dfs(depth: Int) {
        if (end) {
            return
        }

        if (depth == n) {
            end = true
            array.forEach {
                print("$it ")
            }
            println()
            return
        }

        for (i in -10..10) {
            array[depth] = i
            if (possible(depth)) {
                dfs(depth + 1)
            }
        }
    }

    dfs(0)
    close()
}
