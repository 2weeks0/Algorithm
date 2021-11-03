package boj_1507

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
lateinit var input: Array<IntArray>
var sumOrigin = 0
var sumMin = 0
var answer = 0

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    input = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    sumOrigin = sum()
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (k == r || k == c || r == c) {
                    continue
                }
                if (input[r][k] + input[k][c] == input[r][c]) {
                    input[r][c] = Int.MAX_VALUE
                }
            }
        }
    }
    answer = sum() / 2


    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (input[r][k] != Int.MAX_VALUE && input[k][c] != Int.MAX_VALUE) {
                    input[r][c] = min(input[r][c], input[r][k] + input[k][c])
                }
            }
        }
    }
    sumMin = sum()
}

fun sum(): Int {
    return input.map { it.filter { i -> i != Int.MAX_VALUE }.sum() }.sum()
}

fun printAnswer() {
    if (sumOrigin != sumMin) {
        println(-1)
    } else {
        println(answer)
    }
}