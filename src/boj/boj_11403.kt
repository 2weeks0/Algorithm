package boj_11403

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var map: Array<BooleanArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            BooleanArray(n) {
                nextToken().toInt() == 1
            }
        }
    }
    close()
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (map[r][k] && map[k][c]) {
                    map[r][c] = true
                }
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (r in 0 until n) {
        for (c in 0 until n) {
            append("${if (map[r][c]) 1 else 0} ")
        }
        newLine()
    }
    flush()
    close()
}