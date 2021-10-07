package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var map: Array<IntArray>
private val zeroIndexList = mutableListOf<Int>()
private var finish = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    map = Array(9) { r ->
        with(StringTokenizer(readLine())) {
            IntArray(9) { c ->
                val input = nextToken().toInt()
                if (input == 0) {
                    zeroIndexList.add(r * 9 + c)
                }
                input
            }
        }
    }

    bt(0)
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun bt(depth: Int) {
    if (depth == zeroIndexList.size) {
        finish = true
        map.forEach {
            it.forEach { i ->
                bufferedWriter.append("$i ")
            }
            bufferedWriter.newLine()
        }
        bufferedWriter.newLine()
        return
    }

    for (i in 1..9) {
        if (possible(depth, i) && !finish) {
            val idx = zeroIndexList[depth]
            val temp = map[idx / 9][idx % 9]
            map[idx / 9][idx % 9] = i
            bt(depth + 1)
            map[idx / 9][idx % 9] = temp
        }
    }
}

private fun possible(depth: Int, i: Int): Boolean {
    val r = zeroIndexList[depth] / 9
    val c = zeroIndexList[depth] % 9

    for (j in 0 until 9) {
        if (map[r][j] == i) {
            return false
        }
        if (map[j][c] == i) {
            return false
        }
    }

    for (dr in r / 3 * 3 until r / 3 * 3 + 3) {
        for (dc in c / 3 * 3 until c / 3 * 3 + 3) {
            if (map[dr][dc] == i) {
                return false
            }
        }
    }
    return true
}