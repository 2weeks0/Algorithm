package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private var k = 0
private var n = 0
private var max: Long = 0
private lateinit var lineArray: LongArray

fun main() {
    init()
    println(biSearch(1, max + 1) - 1)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        k = nextToken().toInt()
        n = nextToken().toInt()
    }
    lineArray = LongArray(k) {
        readLine().toLong().apply {
            max = max(max, this)
        }
    }
}

private fun biSearch(left: Long, right: Long): Int {
    if (right == left) {
        return left.toInt()
    }

    val mid = (left + right) / 2
    val value = lineArray.map { it / mid }.sum()
    return if (n <= value) {
        biSearch(mid + 1, right)
    } else {
        biSearch(left, mid)
    }
}