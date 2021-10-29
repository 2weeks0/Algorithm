package boj_11404

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

var n = 0
var m = 0
lateinit var minCosts: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    m = readLine().toInt()
    minCosts = Array(n) { r ->
        IntArray(n) { c ->
            if (r == c) 0 else Int.MAX_VALUE
        }
    }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            minCosts[u][v] = min(minCosts[u][v], w)
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (minCosts[r][k] != Int.MAX_VALUE && minCosts[k][c] != Int.MAX_VALUE) {
                    minCosts[r][c] = min(minCosts[r][c], minCosts[r][k] + minCosts[k][c])
                }
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    minCosts.forEach {
        it.forEach { c ->
            append("${if (c == Int.MAX_VALUE) 0 else c} ")
        }
        newLine()
    }
    flush()
    close()
}