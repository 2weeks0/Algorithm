package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var answer = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val k = readLine().toInt()
    repeat(k) {
        answer = true
        val stringTokenizer = StringTokenizer(readLine())
        val v = stringTokenizer.nextToken().toInt()
        val e = stringTokenizer.nextToken().toInt()
        val map = Array(v) { mutableListOf<Int>() }
        repeat(e) {
            with(StringTokenizer(readLine())) {
                val a = nextToken().toInt() - 1
                val b = nextToken().toInt() - 1
                map[a].add(b)
                map[b].add(a)
            }
        }

        val visited = IntArray(v)

        for (start in 0 until v) {
            dfs(start, map, visited)
        }
        println(if (answer) "YES" else "NO")
    }
    close()
}

private fun dfs(start: Int, map: Array<MutableList<Int>>, visited: IntArray) {
    if (!answer) {
        return
    }

    for (next in map[start]) {
        if (visited[next] == 0) {
            visited[next] = visited[start] + 1
            dfs(next, map, visited)
        } else if (visited[start] % 2 == visited[next] % 2) {
            answer = false
            return
        }
    }
}