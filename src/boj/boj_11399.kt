package boj_11399

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var p: ShortArray

fun main() {
    init()
    p.quickSort(0, p.lastIndex)
    var answer = 0
    for (i in p.indices) {
        answer += (p.size - i) * p[i]
    }
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(StringTokenizer(readLine())) {
        p = ShortArray(n) {
            nextToken().toShort()
        }
    }
    close()
}

fun ShortArray.quickSort(left: Int, right: Int) {
    if (left >= right) {
        return
    }

    var l = left
    for (i in left until right) {
        if (this[i] < this[right]) {
            val temp = this[i]
            this[i] = this[l]
            this[l] = temp
            l++
        }
    }
    val temp = this[l]
    this[l] = this[right]
    this[right] = temp
    quickSort(left, l - 1)
    quickSort(l + 1, right)
}