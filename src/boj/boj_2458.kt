package boj_2458

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var arrays: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    println(arrays.count { it.count { i -> i == 0 } == 1 })
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    arrays = Array(n) { IntArray(n) }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            arrays[a][b] = -1
            arrays[b][a] = 1
        }
    }
}

fun floydWarshall() {
    repeat(n) { k ->
        repeat(n) { r ->
            repeat(n) { c ->
                if (arrays[r][k] == 1 && arrays[k][c] == 1) {
                    arrays[r][c] = 1
                    arrays[c][r] = -1
                }
            }
        }
    }
}