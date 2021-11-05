package boj_1080

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var a: Array<BooleanArray>
lateinit var b: Array<BooleanArray>

fun main() {
    init()
    println(solve())
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    a = Array(n) { _ ->
        with(readLine()) {
            BooleanArray(m) {
                this[it] != '0'
            }
        }
    }
    b = Array(n) { _ ->
        with(readLine()) {
            BooleanArray(m) {
                this[it] != '0'
            }
        }
    }
    close()
}

fun solve(): Int {
    var result = 0
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (a[r][c] != b[r][c] && r + 2 < n && c + 2 < m) {
                flip(r, c)
                result++
            }
        }
    }

    return if (isEquals()) {
        result
    } else {
        -1
    }
}

fun flip(r: Int, c: Int) {
    for (dr in 0 until 3) {
        for (dc in 0 until 3) {
            a[r + dr][c + dc] = !a[r + dr][c + dc]
        }
    }
}

fun isEquals(): Boolean {
    for (r in 0 until n) {
        if (!a[r].contentEquals(b[r])) {
            return false
        }
    }
    return true
}
