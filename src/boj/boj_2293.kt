package boj_2293

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var k = 0
lateinit var coins: IntArray
lateinit var cache: Array<IntArray>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    coins = IntArray(n) {
        readLine().toInt()
    }
    coins.sort()
    cache = Array(k + 1) { IntArray(n) }
    close()
}

fun solve() {
    for (a in 1..k) {
        for (b in 0 until n) {
            for (c in 0..b) {
                if (a == coins[b]) {
                    cache[a][b] = 1
                } else if (a - coins[b] in 1..k) {
                    cache[a][b] += cache[a - coins[b]][c]
                }
            }
        }
    }
    println(cache[k].sum())
}