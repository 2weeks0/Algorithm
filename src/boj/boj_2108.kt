package boj_2108

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.roundToInt

var n = 0
lateinit var array: IntArray
val cnt = IntArray(8001)
var cntMax = 0
var sum = 0

fun main() {
    init()
    array.mergeSort(0, n - 1)
    println((sum.toDouble() / n).roundToInt())
    println(array[n / 2])

    val idxList = mutableListOf<Int>()
    for (i in cnt.indices) {
        if (1 < idxList.size) {
            break
        }
        if (cnt[i] == cntMax) {
            idxList.add(i - 4000)
        }
    }
    if (1 < idxList.size) {
        println(idxList[1])
    } else {
        println(idxList[0])
    }

    println(array.last() - array.first())
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(n) {
        with(readLine().toInt()) {
            cnt[this + 4000]++
            cntMax = max(cntMax, cnt[this + 4000])
            sum += this
            this
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
        if (mid < left + l) {
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