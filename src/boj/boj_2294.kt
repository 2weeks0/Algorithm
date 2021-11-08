package boj_2294

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
var k = 0
lateinit var coins: IntArray
lateinit var cache: IntArray

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
    cache = IntArray(k + 1) { Int.MAX_VALUE }
    close()
}

fun solve() {
    for (i in 0 until n) {
        for (j in 1..k) {
            if (j % coins[i] == 0) {
                cache[j] = j / coins[i]
            } else if (j - coins[i] in 1..k && cache[j - coins[i]] != Int.MAX_VALUE) {
                cache[j] = min(cache[j], cache[j - coins[i]] + 1)
            }
        }
    }
    println(if (cache[k] == Int.MAX_VALUE) -1 else cache[k])
}