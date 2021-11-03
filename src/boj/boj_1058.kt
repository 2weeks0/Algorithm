package boj_1058

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

const val UNKNOWN = 0
const val FRIEND = 1
const val FRIEND_OF_FRIEND = 2
var n = 0
lateinit var graph: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    graph = Array(n) {
        with(readLine()) {
            IntArray(n) {
                if (this[it] == 'Y') FRIEND else UNKNOWN
            }
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (r == c) {
                    continue
                }

                if (graph[r][c] == UNKNOWN && graph[r][k] == FRIEND && graph[k][c] == FRIEND) {
                    graph[r][c] = FRIEND_OF_FRIEND
                }
            }
        }
    }
}

fun printAnswer() {
    for (r in 0 until n) {
        for (c in 0 until n) {
            print("${graph[r][c]} ")
        }
        println()
    }
    println()
    var answer = 0
    graph.forEach {
        answer = max(answer, it.count { i -> i != UNKNOWN })
    }
    println(answer)
}