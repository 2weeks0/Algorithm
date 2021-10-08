package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private var n = 0
private var k = 0

fun main() {
    init()
    println(biSearch(1, 1000000000))
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    k = readLine().toInt()
}

private fun biSearch(left: Int, right: Int): Int {
    if (left == right) {
        return left
    }

    val mid = (left + right) / 2
    val cntLowerOrEqual = cntLowerOrEqual(mid)
//    println("left: $left, right: $right, mid: $mid, cnt: $cntLowerOrEqual")
    return if (cntLowerOrEqual >= k) {
        biSearch(left, mid)
    } else {
        biSearch(mid + 1, right)
    }
}

private fun cntLowerOrEqual(value: Int): Int {
    var result = 0
    for (i in 1..n) {
        result += min(value / i, n)
    }
    return result
}