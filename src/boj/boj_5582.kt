package boj_5582

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
    val cached = Array(before.length + 1) { IntArray(after.length + 1) }
    for (r in cached.indices) {
        for (c in cached[r].indices) {
            if (r == 0 || c == 0) {
                continue
            }

            if (before[r - 1] == after[c - 1]) {
                cached[r][c] = cached[r - 1][c - 1] + 1
            } else {
                cached[r][c] = 0
            }

            answer = max(answer, cached[r][c])
        }
    }
}