package boj_10989

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var n = 0
lateinit var array: IntArray

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    for (i in 1..10000) {
        repeat(array[i - 1]) {
            append("$i\n")
        }
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(10000)
    repeat(n) {
        with(readLine().toInt()) {
            array[this - 1] = array[this - 1] + 1
        }
    }
    close()
}
