package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.*

private var n = 0
private var m = 0
private lateinit var array: IntArray

fun main() {
    init()
    println(biSearch(0, 10000))
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    array = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    close()
}

private fun biSearch(left: Int, right: Int): Int {
    if (left == right) {
        return left
    }

    val mid = (left + right) / 2
    return if (possible(mid)) {
        biSearch(left, mid)
    } else {
        biSearch(mid + 1, right)
    }
}

private fun possible(diff: Int): Boolean {
    var min = 10000
    var max = 1
    var cnt = 1
    for (i in array) {
        min = min(min, i)
        max = max(max, i)
        if (diff < max - min) {
            cnt++
            min = i
            max = i
        }
    }
    return cnt <= m
}