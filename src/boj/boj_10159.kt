package boj_10159

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var isHeavy: Array<IntArray> // 1: true, 0: unknown, -1: false

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    m = readLine().toInt()
    isHeavy = Array(n) { IntArray(n) }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            isHeavy[a][b] = 1
            isHeavy[b][a] = -1
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (isHeavy[r][k] == 1 && isHeavy[k][c] == 1) {
                    isHeavy[r][c] = 1
                    isHeavy[c][r] = -1
                }
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    repeat(n) {
        append("${isHeavy[it].count { i -> i == 0 } - 1}\n")
    }
    flush()
    close()
}