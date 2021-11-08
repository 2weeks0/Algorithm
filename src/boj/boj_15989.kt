package boj_15989

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

var t = 0
lateinit var array: IntArray
lateinit var cache: Array<IntArray>

fun main() {
    init()
    for (i in 4 until cache.size) {
        cache[i][1] = cache[i - 1][1]
        cache[i][2] = cache[i - 2][1] + cache[i - 2][2]
        cache[i][3] = cache[i - 3][1] + cache[i - 3][2] + cache[i - 3][3]
    }
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    t = readLine().toInt()
    var max = 3
    array = IntArray(t) {
        readLine().toInt().also {
            max = max(max, it)
        }
    }
    cache = Array(max + 1) { IntArray(4) }.apply {
        this[1][1] = 1
        this[2][1] = 1
        this[2][2] = 1
        this[3][1] = 1
        this[3][2] = 1
        this[3][3] = 1
    }
    close()
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    array.forEach {
        append("${cache[it].sum()}\n")
    }
    flush()
    close()
}