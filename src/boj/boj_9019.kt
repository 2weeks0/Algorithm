package boj_9019

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

val execution = arrayOf('D', 'S', 'L', 'R')
var n = 0
var destination = 0


fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        bfs(bufferedWriter)
    }

    bufferedReader.close()
    bufferedWriter.flush()
    bufferedWriter.close()
}

fun init(bufferedReader: BufferedReader) {
    with(StringTokenizer(bufferedReader.readLine())) {
        n = nextToken().toInt()
        destination = nextToken().toInt()
    }
}

fun bfs(bufferedWriter: BufferedWriter) {
    val queue = LinkedList<Int>().apply {
        addLast(n)
    }
    val visited = HashMap<Int, Pair<Int, Int>>().apply {
        this[n] = Pair(-1, -1)
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        if (current == destination) {
            printAnswer(visited, bufferedWriter)
            return
        }
        for (d in 0 until 4) {
            val next = execute(current, d)
            if (!visited.containsKey(next)) {
                visited[next] = Pair(current, d)
                queue.addLast(next)
            }
        }
    }
}

fun printAnswer(visited: HashMap<Int, Pair<Int, Int>>, bufferedWriter: BufferedWriter) = with(LinkedList<Char>()) {
    var from = destination
    do {
        val idx = visited[from]!!.second
        addLast(execution[idx])
        from = visited[from]!!.first
    } while (from != n)

    while (isNotEmpty()) {
        bufferedWriter.append(pollLast())
    }
    bufferedWriter.newLine()
}

fun execute(n: Int, direction: Int): Int {
    return when (direction) {
        0 -> 2 * n % 10000
        1 -> if (n - 1 < 0) 9999 else n - 1
        2 -> (n % 1000) * 10 + n / 1000
        3 -> (n / 10) + (n % 10) * 1000
        else -> throw Exception("올바르지 않는 direction($direction)")
    }
}