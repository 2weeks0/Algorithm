package boj_1956

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var v = 0
var e = 0
lateinit var minDistance: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }
    minDistance = Array(v) { IntArray(v) { Int.MAX_VALUE } }
    repeat(e) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            val c = nextToken().toInt()
            minDistance[a][b] = c
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until v) {
        for (r in 0 until v) {
            for (c in 0 until v) {
                if (minDistance[r][k] != Int.MAX_VALUE && minDistance[k][c] != Int.MAX_VALUE) {
                    minDistance[r][c] = min(minDistance[r][c], minDistance[r][k] + minDistance[k][c])
                }
            }
        }
    }
}

fun printAnswer() {
    var answer = Int.MAX_VALUE
    for (i in 0 until v) {
        answer = min(answer, minDistance[i][i])
    }
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}