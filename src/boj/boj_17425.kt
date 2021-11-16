package boj_17425

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

var t = 0
var maxInput = 0
lateinit var input: IntArray
lateinit var cache: LongArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    t = readLine().toInt()
    input = IntArray(t) {
        readLine().toInt().also {
            maxInput = max(maxInput, it)
        }
    }
    cache = LongArray(maxInput + 1)
    close()
}

fun solve() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    for (i in 1..maxInput) {
        for (j in i..maxInput step i) {
            cache[j] = cache[j] + i
        }
        cache[i] = cache[i] + cache[i - 1]
    }

    input.forEach {
        append("${cache[it]}\n")
    }
    flush()
    close()
}