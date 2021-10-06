package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.pow

private var s = 0
private val cache = IntArray(21)
private val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        with(StringTokenizer(readLine())) {
            when (nextToken()) {
                "add" -> add(nextToken().toInt())
                "remove" -> remove(nextToken().toInt())
                "check" -> check(nextToken().toInt())
                "toggle" -> toggle(nextToken().toInt())
                "all" -> all()
                "empty" -> empty()
            }
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun Int.pow(n: Int): Int {
    if (cache[n] == 0) {
        cache[n] = toDouble().pow(n).toInt()
    }
    return cache[n]
}

private fun add(x: Int) {
    s = s or 2.pow(x - 1)
}

private fun remove(x: Int) {
    s = s and (2.pow(20) - 1 - 2.pow(x - 1))
}

private fun check(x: Int) {
    val temp = 2.pow(x - 1)
    bufferedWriter.append("${if (s and temp == temp) 1 else 0}\n")
}

private fun toggle(x: Int) {
    s = s xor 2.pow(x - 1)
}

private fun all() {
    s = 2.pow(20) - 1
}

private fun empty() {
    s = 0
}
