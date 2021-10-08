package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.util.*

private var n = 0
private var k = 0
private var answer = Stack<Int>()

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    bfs()
    append("${answer.size - 1}")
    newLine()
    while (answer.isNotEmpty()) {
        append("${answer.pop()} ")
    }
    newLine()
    flush()
    close()
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    close()
}

private fun bfs() {
    val visited = IntArray(200001) { - 1}.apply { this[n] = n }
    val queue = LinkedList<Int>().apply {
        addLast(n)
    }

    while (queue.isNotEmpty()) {
        val x = queue.pollFirst()
        if (x == k) {
            var pos = x
            while (visited[pos] != pos) {
                answer.push(pos)
                pos = visited[pos]
            }
            answer.push(n)
            return
        }
        for (i in 0 until 3) {
            val nx = when (i) {
                0 -> x - 1
                1 -> x + 1
                2 -> 2 * x
                else -> throw Exception()
            }
            if (nx in 0..200000 && visited[nx] == -1) {
                queue.addLast(nx)
                visited[nx] = x
            }
        }
    }

}