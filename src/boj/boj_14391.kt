package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.pow
import kotlin.properties.Delegates

private var n by Delegates.notNull<Int>()
private var m by Delegates.notNull<Int>()
private lateinit var input: IntArray
private var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    input = IntArray(n * m)
    repeat(n) {
        readLine().forEachIndexed { i, c ->
            input[it * m + i] = c - '0'
        }
    }
    bitMask()

    println(answer)
    close()
}

private fun bitMask() {
    for (i in 0 until 2.pow(n * m)) {
        var sum = 0
        for (c in 0 until m) {
            var temp = 0
            for (r in 0 until n) {
                if (2.pow(r * m + c) and i == 2.pow(r * m + c)) {
                    temp *= 10
                    temp += input[r * m + c]
                } else {
                    sum += temp
                    temp = 0
                }
            }
            sum += temp
        }

        for (r in 0 until n) {
            var temp = 0
            for (c in 0 until m) {
                if (2.pow(r * m + c) and i == 0) {
                    temp *= 10
                    temp += input[r * m + c]
                } else {
                    sum += temp
                    temp = 0
                }
            }
            sum += temp
        }

        answer = max(answer, sum)
    }
}

private fun Int.pow(n: Int) = toDouble().pow(n).toInt()
