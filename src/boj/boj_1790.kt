package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.log10

private var n = 0
private var k = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    if (calculateLength(n) < k) {
        println(-1)
        return@with
    }

    solveByBiSearch()
    solve()
    close()
}

private fun solveByBiSearch() {
    val test = biSearch(1, n)
    println(test)
}

private fun biSearch(l: Int, r: Int): Int {
    if (r == l) {
        val length = calculateLength(l)
        return l.toString().reversed()[length - k] - '0'
    }

    val mid = (l + r) / 2
    val midLength = calculateLength(mid)
    if (midLength < k) {
        return biSearch(mid + 1, r)
    } else if (midLength == k) {
        return mid % 10
    } else {
        return biSearch(l, mid)
    }
}

private fun calculateLength(num: Int): Int {
    var temp = num
    var length = 0
    var i = 9
    while (temp - i >= 0) {
        length += i * (log10(i.toDouble()).toInt() + 1)
        temp -= i
        i *= 10
    }
    length += temp * (log10(i.toDouble()).toInt() + 1)
    return length
}

private fun solve() {
    var i = 9
    var size = 1
    while (k - i * size > 0) {
        k -= i * size
        i *= 10
        size = log10(i.toDouble()).toInt() + 1
    }

    val answer = (i / 9 + (k - 1) / size).toString()
    println(answer[(k - 1) % size])
}