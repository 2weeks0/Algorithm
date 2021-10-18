package boj_2750

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var n = 0
lateinit var array: IntArray

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    array.mergeSort(0, array.lastIndex)
    array.forEach {
        append("$it\n")
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(n) {
        readLine().toInt()
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
        if (left + l > mid) {
            this[mid + r++]
        } else if (right < mid + r) {
            this[left + l++]
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