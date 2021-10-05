package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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
    val list = LinkedList<Int>()

    fun possible(): Boolean {
        for (i in 0 until list.size) {
            for (j in i until list.size) {
                var sum = 0
                for (k in i..j) {
                    sum += list[k]
                }

                val exp = when (input[i][j]) {
                    '-' -> sum < 0
                    '+' -> sum > 0
                    else -> sum == 0
                }
                if (!exp) {
                    return false
                }
            }
        }
        return true
    }

    fun dfs() {
        if (list.size == n) {
            end = true
            list.forEach {
                print("$it ")
            }
            println()
            return
        }

        for (i in -10 .. 10) {
            list.addLast(i)
            if (!end && possible()) {
                dfs()
            }
            list.pollLast()
        }
    }

    dfs()
    close()
}
