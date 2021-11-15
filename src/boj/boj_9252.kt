package boj_9252

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

lateinit var before: String
lateinit var after: String
val answer = LinkedList<Char>()

fun main() {
    init()
    lcs()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    before = readLine()
    after = readLine()
    close()
}

fun lcs() {
    var max = 0
    var maxIndex = Pair(0, 0)
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

            if (max < cache[r][c]) {
                max = cache[r][c]
                maxIndex = Pair(r, c)
            }
        }
    }

    var temp = max
    for (r in maxIndex.first downTo 1) {
        for (c in maxIndex.second downTo 1) {
            if (before[r - 1] == after[c - 1] && cache[r][c] == temp) {
                temp--
                answer.addLast(before[r - 1])
                break
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    append("${answer.size}\n")
    while (answer.isNotEmpty()) {
        append(answer.pollLast())
    }
    flush()
    close()
}