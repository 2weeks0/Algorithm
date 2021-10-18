package boj_1181

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var n = 0
lateinit var array: Array<String>

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    array.mergeSort(0, n - 1)
    for (i in array.indices) {
        if (i == array.lastIndex || array[i] != array[i + 1]) {
            append("${array[i]}\n")
        }
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = Array(n) {
        readLine()
    }
    close()
}

fun Array<String>.mergeSort(left: Int, right: Int) {
    if (left == right) {
        return
    }

    val mid = (left + right) / 2
    mergeSort(left, mid)
    mergeSort(mid + 1, right)

    var l = 0
    var r = 1
    val result = Array(right - left + 1) {
        if (right < mid + r) {
            this[left + l++]
        } else if (mid < left + l) {
            this[mid + r++]
        } else if (compare(this[left + l], this[mid + r])) {
            this[left + l++]
        } else {
            this[mid + r++]
        }
    }
    for (i in result.indices) {
        this[left + i] = result[i]
    }
}

fun compare(a: String, b: String): Boolean {
    if (a.length != b.length) {
        return a.length < b.length
    }

    for (i in a.indices) {
        if (a[i] != b[i]) {
            return a[i] < b[i]
        }
    }

    return false
}