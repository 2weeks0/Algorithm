package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var array: IntArray
private var n = 0
private var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(n) { -1 }
    bt(0)
    println(answer)
    close()
}

private fun bt(depth: Int) {
    if (depth == n) {
        answer++
        return
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            val idx = i * n + j
            if (possible(depth, idx)) {
                array[depth] = idx
                bt(depth + 1)
            }
        }
    }
}

private fun possible(depth: Int, idx: Int): Boolean {
    for (i in 0 until depth) {
        when {
            (idx - array[i]) % n == 0 -> return false
            (idx - array[i]) < n -> return false
        }
    }

    return true
}