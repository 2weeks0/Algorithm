package boj_10815

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

lateinit var mine: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    with(StringTokenizer(readLine())) {
        mine = IntArray(n) {
            nextToken().toInt()
        }
    }
    mine.quickSort(0, n - 1)
    val m = readLine().toInt()
    with(StringTokenizer(readLine())) {
        repeat(m) {
            if (mine.bSearch(nextToken().toInt())) {

                bufferedWriter.append("1 ")
            } else {
                bufferedWriter.append("0 ")
            }
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun IntArray.quickSort(left: Int, right: Int) {
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

fun IntArray.bSearch(num: Int): Boolean {
    var l = 0
    var r = lastIndex
    while (l < r) {
        val mid = (l + r) / 2
        if (this[mid] < num) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return this[l] == num
}