package boj_3665

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<BooleanArray>
lateinit var indegree: IntArray
lateinit var prevRank: IntArray

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        topologicalSort(bufferedWriter)
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    bufferedReader.close()
}

fun init(bufferedReader: BufferedReader) {
    n = bufferedReader.readLine().toInt()
    indegree = IntArray(n)
    graph = Array(n) { BooleanArray(n) }
    with(StringTokenizer(bufferedReader.readLine())) {
        prevRank = IntArray(n) {
            nextToken().toInt() - 1
        }
    }
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            graph[prevRank[i]][prevRank[j]] = true
            indegree[prevRank[j]]++
        }
    }
    m = bufferedReader.readLine().toInt()
    repeat(m) {
        with(StringTokenizer(bufferedReader.readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            if (prevRank.indexOf(u) < prevRank.indexOf(v)) {
                graph[u][v] = false
                graph[v][u] = true
                indegree[u]++
                indegree[v]--
            } else {
                graph[u][v] = true
                graph[v][u] = false
                indegree[u]--
                indegree[v]++
            }
        }
    }
}

fun topologicalSort(bufferedWriter: BufferedWriter) {
    val result = LinkedList<Int>()
    val queue = LinkedList<Int>()

    for (i in 0 until n) {
        if (indegree[i] == 0) {
            queue.addLast(i)
        }
    }

    while (queue.isNotEmpty()) {
        if (1 < queue.size) {
            bufferedWriter.append("?\n")
            return
        }
        val current = queue.pollFirst()
        result.addLast(current)
        for (next in 0 until n) {
            if (graph[current][next]) {
                indegree[next]--
                if (indegree[next] == 0) {
                    queue.addLast(next)
                }
            }
        }
    }

    if (result.size != n) {
        bufferedWriter.append("IMPOSSIBLE\n")
    } else {
        while (result.isNotEmpty()) {
            bufferedWriter.append("${result.pollFirst() + 1} ")
        }
        bufferedWriter.newLine()
    }
}