package boj_2138

import java.io.BufferedReader
import java.io.InputStreamReader

var n = 0
lateinit var a: BooleanArray
lateinit var b: BooleanArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(readLine()) {
        a = BooleanArray(n) {
            this[it] != '0'
        }
    }
    with(readLine()) {
        b = BooleanArray(n) {
            this[it] != '0'
        }
    }
    close()
}

fun solve() {
    var result = 0
    var temp = a.clone()

    fun searchSwitchToPress() {
        for (i in 1 until n) {
            if (temp[i - 1] != b[i - 1]) {
                result++
                temp[i - 1] = !temp[i - 1]
                temp[i] = !temp[i]
                if (i != n - 1) {
                    temp[i + 1] = !temp[i + 1]
                }
            }
        }
    }

    searchSwitchToPress()
    if (temp.contentEquals(b)) {
        println(result)
        return
    }

    temp = a.clone()
    temp[0] = !temp[0]
    temp[1] = !temp[1]
    result = 1
    searchSwitchToPress()

    if (temp.contentEquals(b)) {
        println(result)
    } else {
        println(-1)
    }
}

