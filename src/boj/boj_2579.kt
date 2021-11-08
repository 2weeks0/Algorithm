package boj_2579

import java.io.BufferedReader
import java.io.InputStreamReader

var n = 0
lateinit var array: IntArray
lateinit var cache: Array<IntArray>

fun main() {
    init()
    for (i in cache.indices) {
        when (i) {
            0 -> {
                cache[i][0] = 0
                cache[i][1] = array[i]
            }
            1 -> {
                cache[i][0] = array[i]
                cache[i][1] = array[i - 1] + array[i]
            }
            else -> {
                cache[i][0] = cache[i - 2].max()!! + array[i] // 최근에 한 계단 오른 적이 없음.
                cache[i][1] = cache[i - 1][0] + array[i]      // 최근에 한 계단 오른 적이 있음.
            }
        }
    }
    println(cache[n - 1].max()!!)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(n) {
        readLine().toInt()
    }
    cache = Array(n) { IntArray(2) }
    close()
}

