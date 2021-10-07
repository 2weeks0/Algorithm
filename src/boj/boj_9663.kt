package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var array: IntArray
private var n = 0
private var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = IntArray(n)
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
        val idx = depth * n + i
        if (possible(depth, idx) && (depth == 0 || array[depth - 1] < idx)) {
            array[depth] = idx
            bt(depth + 1)
        }
    }
}

private fun possible(depth: Int, idx: Int): Boolean {
    if (depth == 0) {
        return true
    }
    for (i in 0 until depth) {
        val diffRow = idx / n - array[i] / n
        val diffCol = idx % n - array[i] % n
        when {
            diffRow == 0 -> return false
            diffCol == 0 -> return false
            diffRow - diffCol == 0 -> return false
            diffRow + diffCol == 0 -> return false
        }
    }
    return true
}