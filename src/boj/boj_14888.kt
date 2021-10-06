package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

private var n = 0
private lateinit var numArray: IntArray
private lateinit var expArray: IntArray
private lateinit var curExp: IntArray
private var max = -1000000000
private var min = 1000000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(StringTokenizer(readLine())) {
        numArray = IntArray(n) {
            nextToken().toInt()
        }
    }
    with(StringTokenizer(readLine())) {
        expArray = IntArray(4) {
            nextToken().toInt()
        }
    }
    curExp = IntArray(n - 1)
    bt(0)

    println("$max\n$min")
    close()
}

private fun bt(depth: Int) {
    if (depth == n - 1) {
        val sum = calculate()
        max = max(max, sum)
        min = min(min, sum)
        return
    }

    for (i in 0 until 4) {
        if (expArray[i] > 0) {
            expArray[i] -= 1
            curExp[depth] = i
            bt(depth + 1)
            expArray[i] += 1
        }
    }
}

private fun calculate(): Int {
    var sum = numArray.first()
    curExp.forEachIndexed { index, i ->
        when (i) {
            0 -> sum += numArray[index + 1]
            1 -> sum -= numArray[index + 1]
            2 -> sum *= numArray[index + 1]
            3 -> sum /= numArray[index + 1]
        }
    }
    return sum
}