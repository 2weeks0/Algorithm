package boj_1037

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var array: IntArray

fun main() {
    init()
    array.mergeSort(0, n - 1)
    println(array.first() * array.last())
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(StringTokenizer(readLine())) {
        array = IntArray(n) {
            nextToken().toInt()
        }
    }
    close()
}

fun IntArray.mergeSort(left: Int, right: Int) {
    if (left == right) {
        return
    }

    val mid = (left + right) / 2
    mergeSort(left, mid)
    mergeSort(mid + 1, right)

    var l = 0
    var r = 1
    val result = IntArray(right - left + 1) {
        if (right < mid + r) {
            this[left + l++]
        } else if (mid < left + l) {
            this[mid + r++]
        } else if (this[left + l] < this[mid + r]) {
            this[left + l++]
        } else {
            this[mid + r++]
        }
    }
    for (i in result.indices) {
        this[left + i] = result[i]
    }
}