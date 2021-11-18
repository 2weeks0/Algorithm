package boj_16927

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
    repeat(min(n, m) / 2) { i ->
        repeat(r % (2 * ((n - 2 * i) + (m - 2 * i) - 2))) {
            rotate(i, i)
        }
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

fun rotate(startR: Int, startC: Int) {
    var r = startR
    var c = startC
    val temp = array[startR][startC]
    do {
        array[r][c] = if (r == startR && c + 1 < m - startC) {
            array[r][++c]
        } else if (c == m - startC - 1 && r + 1 < n - startR) {
            array[++r][c]
        } else if (r == n - startR - 1 && startC < c) {
            array[r][--c]
        } else {
            array[--r][c]
        }
    } while (!(r == startR + 1 && c == startC))
    array[r][c] = temp
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