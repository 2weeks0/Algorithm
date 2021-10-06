package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var idx = 0
    val stringArray = Array(n) {
        readLine()
    }

    val temp = IntArray('Z' - 'A' + 1) { -1 }
    stringArray.forEach { s ->
        s.forEach {c ->
            if (temp[c - 'A'] == -1) {
                temp[c - 'A'] = idx++
            }
        }
    }
    val cnt = temp.count { it != -1 }
    val numArray = IntArray(cnt) { 9 - it }
    var answer = 0
    do {
        var sum = 0
        stringArray.forEach {
            sum += it.getInt(temp, numArray)
        }
        answer = max(answer, sum)
        numArray.prevPermutation()
    } while (numArray.first() != -1)

    println(answer)
    close()
}

private fun String.getInt(temp: IntArray, numArray: IntArray): Int {
    var result = 0
    forEach {
        result *= 10
        result += numArray[temp[it - 'A']]
    }
    return result
}

private fun IntArray.prevPermutation() {
    var left = -1
    for (i in lastIndex - 1 downTo 0) {
        if (this[i] > this[i + 1]) {
            left = i
            break
        }
    }

    if (left == -1) {
        this[0] = -1
        return
    }

    var right = left + 1
    for (i in lastIndex downTo left + 1) {
        if (this[left] > this[i]) {
            right = i
            break
        }
    }

    var temp = this[left]
    this[left] = this[right]
    this[right] = temp

    for (i in left + 1 .. (left + 1 + lastIndex) / 2) {
        temp = this[i]
        this[i] = this[lastIndex + left + 1 - i]
        this[lastIndex + left + 1 - i] = temp
    }
}