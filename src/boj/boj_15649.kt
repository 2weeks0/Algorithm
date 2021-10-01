package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    val visited = BooleanArray(n)
    val numList = LinkedList<Int>()

    dfs(n, m, visited, numList, bufferedWriter)

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun dfs(n: Int, m: Int, visited: BooleanArray, numList: LinkedList<Int>, bufferedWriter: BufferedWriter) {
    if (numList.size == m) {
        numList.forEach{
            bufferedWriter.append("${it + 1} ")
        }
        bufferedWriter.append('\n')
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            numList.addLast(i)
            dfs(n, m, visited, numList, bufferedWriter)
            visited[i] = false
            numList.pollLast()
        }
    }
}