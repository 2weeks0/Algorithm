package boj_16926

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

var n = 0
var m = 0
var r = 0
lateinit var array: Array<IntArray>

fun main() {
    init()
    repeat(r) {
        rotate()
    }
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        r = nextToken().toInt()
    }
    array = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }
    close()
}

fun rotate() {
    repeat(min(n, m) / 2) { i ->
        var r = i
        var c = i
        val temp = array[i][i]
        do {
            array[r][c] = if (r == i && c + 1 < m - i) {
                array[r][++c]
            } else if (c == m - i - 1 && r + 1 < n - i) {
                array[++r][c]
            } else if (r == n - i - 1 && i < c) {
                array[r][--c]
            } else {
                array[--r][c]
            }
        } while (!(r == i + 1 && c == i))
        array[r][c] = temp
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (r in 0 until n) {
        for (c in 0 until m) {
            append("${array[r][c]} ")
        }
        newLine()
    }
    flush()
    close()
}