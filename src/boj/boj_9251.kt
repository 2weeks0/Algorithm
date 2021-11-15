package boj_9251

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

lateinit var before: String
lateinit var after: String
var answer = 0

fun main() {
    init()
    lcs()
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    before = readLine()
    after = readLine()
    close()
}

fun lcs() {
    val cache = Array(before.length + 1) { IntArray(after.length + 1) }
    for (r in cache.indices) {
        for (c in cache[r].indices) {
            if (r == 0 || c == 0) {
                continue
            }

            if (before[r - 1] == after[c - 1]) {
                cache[r][c] = cache[r - 1][c - 1] + 1
            } else {
                cache[r][c] = max(cache[r - 1][c], cache[r][c - 1])
            }
            answer = max(answer, cache[r][c])
        }
    }
}