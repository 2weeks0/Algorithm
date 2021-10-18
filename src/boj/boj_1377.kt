package boj_1377

import java.io.BufferedReader
import java.io.InputStreamReader

var n = 0
lateinit var array: Array<Pair<Int, Int>>

fun main() {
    init()
    array.mergeSort()
    var max = 0
    array.forEachIndexed { index, pair ->
        with(pair.second - index) {
            if (max < this) {
                max = this
            }
        }
    }
    println(max + 1)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = Array(n) {
        Pair(readLine().toInt(), it)
    }
    close()
}

fun Array<Pair<Int, Int>>.mergeSort(left: Int = 0, right: Int = lastIndex) {
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
        } else if (this[left + l].first <= this[mid + r].first) {
            this[left + l++]
        } else {
            this[mid + r++]
        }
    }
    for (i in result.indices) {
        this[left + i] = result[i]
    }
}