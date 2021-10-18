package boj_11651

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var array: Array<Point>

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    array.mergeSort(0, n - 1)
    array.forEach {
        append("$it\n")
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = Array(n) {
        with(StringTokenizer(readLine())) {
            Point(nextToken().toInt(), nextToken().toInt())
        }
    }
    close()
}

fun Array<Point>.mergeSort(left: Int, right: Int) {
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
        } else if (this[left + l].compare(this[mid + r])) {
            this[left + l++]
        } else {
            this[mid + r++]
        }
    }
    for (i in result.indices) {
        this[left + i] = result[i]
    }
}

class Point(val x: Int, val y: Int) {
    fun compare(other: Point): Boolean {
        if (y != other.y) {
            return y < other.y
        }
        return x < other.x
    }

    override fun toString(): String {
        return "$x $y"
    }
}