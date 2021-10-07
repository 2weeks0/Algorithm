package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private var n = 0
private var m = 0
private var max = 0
private lateinit var woodArray: LongArray

fun main() {
    init()
    println(biSearch(1, max + 1) - 1)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    woodArray = with(StringTokenizer(readLine())) {
        LongArray(n) {
            nextToken().toLong().apply {
                max = max(max, this.toInt())
            }
        }
    }
    close()
}

private fun biSearch(left: Int, right: Int): Int {
    if (left == right) {
        return left
    }

    val mid = (left + right) / 2
    val value = woodArray.map { if (it <= mid) 0 else it - mid }.sum()
    return if (m <= value) {
        biSearch(mid + 1, right)
    } else {
        biSearch(left, mid)
    }
}