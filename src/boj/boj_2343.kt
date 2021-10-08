package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var m = 0
private lateinit var videos: IntArray

fun main() {
    init()
    println(biSearch(1, 1000000000))
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    videos = with(StringTokenizer(readLine())) {
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
    return if (videos.count{ mid < it } == 0 && count(mid) <= m) {
        biSearch(left, mid)
    } else {
        biSearch(mid + 1, right)
    }
}

private fun count(maxLength: Int): Int {
    var cnt = 1
    var sum = 0
    for (v in videos) {
        if (sum + v <= maxLength) {
            sum += v
        } else {
            cnt++
            sum = v
        }
    }
    return cnt
}