package boj_10942

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var array: IntArray
var m = 0
lateinit var questions: Array<Pair<Int, Int>>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    m = readLine().toInt()
    questions = Array(m) {
        with(StringTokenizer(readLine())) {
            Pair(nextToken().toInt() - 1, nextToken().toInt() - 1)
        }
    }
    close()
}

fun solve() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val memo = Array(n) { BooleanArray(n) }
    for (cnt in 1..n) {
        for (i in 0 until n) {
            val j = i + cnt - 1
            if (j !in 0 until n) {
                continue
            }
            memo[i][j] = when (cnt) {
                1 -> true
                2 -> array[i] == array[j]
                else -> memo[i + 1][j - 1] && array[i] == array[j]
            }
        }
    }

    questions.forEach {
        append("${if (memo[it.first][it.second]) 1 else 0}\n")
    }
    flush()
    close()
}
