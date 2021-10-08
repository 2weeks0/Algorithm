package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val COPY = 0
const val PASTE = 1
const val DELETE = 2

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    bfs(readLine().toInt())
    close()
}

private fun bfs(s: Int) {
    val visited = Array(2001) {
        IntArray(2001)
    }.apply { this[1][0] = 1 }
    val queue = LinkedList<Pair<Int, Int>>().apply {
        addLast(Pair(1, 0))
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        if (current.first == s) {
            println(visited[s][current.second] - 1)
            return
        }

        for (i in 0 until 3) {
            if ((current.first == 0 || current.first == current.second) && i == COPY) {
                continue
            }
            var nextFirst = current.first
            var nextSecond = current.second
            when (i) {
                COPY -> nextSecond = current.first
                PASTE -> nextFirst += current.second
                DELETE -> nextFirst -= 1
            }

            if (nextFirst in 0..2000 && nextSecond in 0..2000 && visited[nextFirst][nextSecond] == 0) {
                visited[nextFirst][nextSecond] = visited[current.first][current.second] + 1
                queue.addLast(Pair(nextFirst, nextSecond))
            }
        }
    }
}