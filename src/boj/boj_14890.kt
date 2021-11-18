package boj_14890

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

var n = 0
var k = 0
lateinit var map: Array<IntArray>
lateinit var hasBridge: Array<BooleanArray>
var answer = 0

fun main() {
    init()
    findRoute()

    rotate()
    hasBridge.forEach { it.fill(false) }

    findRoute()
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }
    hasBridge = Array(n) { BooleanArray(n) }
    close()
}

fun findRoute() {
    for (r in 0 until n) {
        var flag = true
        var c = 0
        while (c in 0 until n - 1) {
            if (map[r][c + 1] - map[r][c] == 1) {
                if (c - k + 1 < 0) {
                    flag = false
                    break
                }
                var cnt = 0
                for (i in c - k + 1..c) {
                    if (!hasBridge[r][i] && map[r][i] == map[r][c]) {
                        cnt++
                    }
                }

                if (cnt < k) {
                    flag = false
                    break
                }

                for (i in c - k + 1..c) {
                    hasBridge[r][i] = true
                }
            } else if (map[r][c] - map[r][c + 1] == 1) {
                if (n <= c + k) {
                    flag = false
                    break
                }

                var cnt = 0
                for (i in c + 1..c + k) {
                    if (!hasBridge[r][i] && map[r][i] == map[r][c + 1]) {
                        cnt++
                    }
                }

                if (cnt < k) {
                    flag = false
                    break
                }

                for (i in c + 1..c + k) {
                    hasBridge[r][i] = true
                }
                c += k - 1
            } else if (1 < abs(map[r][c] - map[r][c + 1])) {
                flag = false
                break
            }
            c++
        }

        if (flag) {
            answer++
        }
    }
}

fun rotate() {
    for (r in 0 until n / 2) {
        for (c in r until n - 1 - r) {
            val temp = map[r][c]
            map[r][c] = map[n - 1 - c][r]
            map[n - 1 - c][r] = map[n - 1 - r][n - 1 - c]
            map[n - 1 - r][n - 1 - c] = map[c][n - 1 - r]
            map[c][n - 1 - r] = temp
        }
    }
}