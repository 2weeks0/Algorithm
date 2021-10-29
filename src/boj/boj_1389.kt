package boj_1389

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
var m = 0
lateinit var graph: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    graph = Array(n) { r ->
        IntArray(n) { c ->
            if (r == c) 0 else Int.MAX_VALUE
        }
    }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val x = nextToken().toInt() - 1
            val y = nextToken().toInt() - 1
            graph[x][y] = 1
            graph[y][x] = 1
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (graph[r][k] != Int.MAX_VALUE && graph[k][c] != Int.MAX_VALUE) {
                    graph[r][c] = min(graph[r][c], graph[r][k] + graph[k][c])
                }
            }
        }
    }
}

fun printAnswer() {
    val min = graph.map { it.sum() }.min()
    val answer = graph.indexOfFirst { it.sum() == min }
    println(answer + 1)
}