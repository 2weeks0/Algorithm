package boj_15988

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

var t = 0
lateinit var array: IntArray
lateinit var cache: IntArray

fun main() {
    init()
    for (i in 4 until cache.size) {
        cache[i] = ((cache[i - 1].toLong() + cache[i - 2] + cache[i - 3]) % 1000000009).toInt()
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
    cache = IntArray(max + 1).apply {
        this[1] = 1
        this[2] = 2
        this[3] = 4
    }
    close()
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    array.forEach {
        append("${cache[it]}\n")
    }
    flush()
    close()
}