package boj_12865

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
var k = 0
lateinit var products: Array<Pair<Int, Int>>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    products = Array(n) {
        with(StringTokenizer(readLine())) {
            Pair(nextToken().toInt(), nextToken().toInt())
        }
    }
    close()
}

fun solve() {
    val cache = IntArray(k + 1)

    for (p in products) {
        for (i in k downTo p.first) {
            cache[i] = max(cache[i], cache[i - p.first] + p.second)
        }
    }

    println(cache[k])
}