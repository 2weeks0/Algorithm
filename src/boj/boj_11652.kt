package boj_11652

import java.io.BufferedReader
import java.io.InputStreamReader

var n = 0
lateinit var array: LongArray
val map = hashMapOf<Long, Int>()

fun main() {
    init()
    array.mergeSort()
    println(array.first())
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = LongArray(n) {
        readLine().toLong().also {
            if (map.containsKey(it)) {
                map[it] = map[it]!! + 1
            } else {
                map[it] = 1
            }
        }
    }
    close()
}

fun LongArray.mergeSort(left: Int = 0, right: Int = lastIndex) {
    if (left == right) {
        return
    }

    val mid = (left + right) / 2
    mergeSort(left, mid)
    mergeSort(mid + 1, right)

    var l = 0
    var r = 1
    val result = LongArray(right - left + 1) {
        if (mid < left + l) {
            this[mid + r++]
        } else if (right < mid + r) {
            this[left + l++]
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

fun compare(a: Long, b: Long): Boolean {
    return if (map[a]!! == map[b]!!) {
        a < b
    } else {
        map[a]!! > map[b]!!
    }
}