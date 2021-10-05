package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())
    val input = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }

    val answer = input.prevPermutation()
    if (answer == null) {
        println(-1)
    } else {
        answer.print()
    }
    close()
}

private fun IntArray.prevPermutation(): IntArray? {
    var left = -1
    for (i in lastIndex - 1 downTo 0) {
        if (this[i] > this[i + 1]) {
            left = i
            break
        }
    }

    if (left == -1) {
        return null
    }

    var right = left + 1
    for (i in lastIndex downTo right) {
        if (this[i] < this[left]) {
            right = i
            break
        }
    }

    val result = this.copyOf()
    result[left] = this[right]
    result[right] = this[left]

    for (i in left + 1 .. (lastIndex + left + 1) / 2) {
        val temp = result[i]
        result[i] = result[lastIndex + left + 1 - i]
        result[lastIndex + left + 1 - i] = temp
    }

    return result
}

private fun IntArray.print() {
    for (i in indices) {
        print("${this[i]} ")
    }
    println()
}