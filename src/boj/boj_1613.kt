package boj_1613

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var k = 0
lateinit var isFuture: Array<IntArray> // 1: true, 0: unknown, -1: false
var s = 0
lateinit var accidents: Array<Pair<Int, Int>>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    isFuture = Array(n) { IntArray(n) }
    repeat(k) {
        with(StringTokenizer(readLine())) {
            val p = nextToken().toInt() - 1
            val f = nextToken().toInt() - 1
            isFuture[p][f] = -1
            isFuture[f][p] = 1
        }
    }
    s = readLine().toInt()
    accidents = Array(s) {
        with(StringTokenizer(readLine())) {
            Pair(nextToken().toInt() - 1, nextToken().toInt() - 1)
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (isFuture[r][k] == 1 && isFuture[k][c] == 1) {
                    isFuture[r][c] = 1
                    isFuture[c][r] = -1
                }
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    accidents.forEach {
        append("${isFuture[it.first][it.second]}\n")
    }
    flush()
    close()
}