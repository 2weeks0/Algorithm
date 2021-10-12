package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dh = arrayOf(0, 0, 1, -1, -1, 1, 1, -1)
private val dw = arrayOf(1, -1, 0, 0, 1, 1, -1, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val stringTokenizer = StringTokenizer(readLine())
        val w = stringTokenizer.nextToken().toInt()
        val h = stringTokenizer.nextToken().toInt()
        if (w == 0 && h == 0) {
            break
        }

        val map = Array(h) {
            with(StringTokenizer(readLine())) {
                BooleanArray(w) {
                    nextToken().toInt() == 1
                }
            }
        }
        var answer = 0
        for (y in 0 until h) {
            for (x in 0 until w) {
                if (map[y][x]) {
                    answer++
                    bfs(x, y, map)
                }
            }
        }
        bufferedWriter.append("$answer\n")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun bfs(x: Int, y: Int, map: Array<BooleanArray>) {
    val queue = LinkedList<Pair<Int, Int>>().apply {
        addLast(Pair(x, y))
    }
    map[y][x] = false

    while (queue.isNotEmpty()) {
        val c = queue.pollFirst()
        for (d in 0 until 8) {
            val ny = c.second + dh[d]
            val nx = c.first + dw[d]
            if (ny in map.indices && nx in map[0].indices && map[ny][nx]) {
                map[ny][nx] = false
                queue.addLast(Pair(nx, ny))
            }
        }
    }
}
