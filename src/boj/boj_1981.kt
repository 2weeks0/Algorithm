package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)
private var n = 0
private lateinit var map: Array<IntArray>
private val numbers = mutableListOf<Int>()
private var answer = 200

fun main() {
    init()
    solve(0, 0)
    println(answer)
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(n) {
                nextToken().toInt().apply {
                    if (!numbers.contains(this)) {
                        numbers.add(this)
                    }
                }
            }
        }
    }
    numbers.sort()
    close()
}

private fun solve(left: Int, right: Int) {
    if (left > right || numbers.size <= right) {
        return
    }

    val p = possible(numbers[left], numbers[right])
    if (p) {
        answer = min(answer, numbers[right] - numbers[left])
        solve(left + 1, right)
    } else {
        solve(left, right + 1)
    }
}

private fun possible(min: Int, max: Int): Boolean {
    if (map[0][0] !in min..max) {
        return false
    }

    val visited = Array(n) {
        BooleanArray(n)
    }.apply { this[0][0] = true }
    val queue = LinkedList<Pair<Int, Int>>().apply {
        addLast(Pair(0, 0))
    }

    while (queue.isNotEmpty()) {
        val pos = queue.pollFirst()
        if (pos.first == n - 1 && pos.second == n - 1) {
            return true
        }

        for (d in 0 until 4) {
            val nr = pos.first + dr[d]
            val nc = pos.second + dc[d]
            if (nr in 0 until n && nc in 0 until n) {
                val value = map[nr][nc]
                if (!visited[nr][nc] && value in min..max) {
                    visited[nr][nc] = true
                    queue.addLast(Pair(nr, nc))
                }
            }
        }
    }
    return false
}
