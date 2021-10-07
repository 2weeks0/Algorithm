package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var n = 0
private var m = 0
private lateinit var cardArray: IntArray
private lateinit var numArray: IntArray

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    numArray.forEach {
        append("${upperBound(0, cardArray.size, it) - lowerBound(0, cardArray.lastIndex, it)} ")
    }
    newLine()
    flush()
    close()
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(StringTokenizer(readLine())) {
        cardArray = IntArray(n) {
            nextToken().toInt()
        }.sortedArray()
    }
    m = readLine().toInt()
    with(StringTokenizer(readLine())) {
        numArray = IntArray(m) {
            nextToken().toInt()
        }
    }
    close()
}

private fun lowerBound(left: Int, right: Int, value: Int): Int {
    if (left == right) {
        return if (cardArray[left] != value) {
            -1
        } else {
            left
        }
    }

    val mid = (left + right) / 2
    return if (cardArray[mid] < value) {
        lowerBound(mid + 1, right, value)
    } else {
        lowerBound(left, mid, value)
    }
}

private fun upperBound(left: Int, right: Int, value: Int): Int {
    if (left == right) {
        return if (left == 0 || cardArray[left - 1] != value) {
            -1
        } else {
            left
        }
    }

    val mid = (left + right) / 2
    return if (cardArray[mid] <= value) {
        upperBound(mid + 1, right, value)
    } else {
        upperBound(left, mid, value)
    }
}