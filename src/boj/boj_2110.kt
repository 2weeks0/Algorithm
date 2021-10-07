package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var c = 0
private lateinit var houses: IntArray

fun main() {
    init()
    println(biSearch(1, houses.last() - houses.first() + 1) - 1)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        c = nextToken().toInt()
    }
    houses = IntArray(n) {
        readLine().toInt()
    }.sortedArray()
    close()
}

private fun biSearch(left: Int, right: Int): Int {
    if (left == right) {
        return left
    }

    val mid = (left + right) / 2
    var cnt = 1
    var x = houses.first()
    for (i in 1 until houses.size) {
        if (mid <= houses[i] - x) {
            cnt++
            x = houses[i]
        }
    }

    return if (c <= cnt) {
        biSearch(mid + 1, right)
    } else {
        biSearch(left, mid)
    }
}