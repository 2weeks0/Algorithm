package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var stringTokenizer = StringTokenizer(readLine())
    val l = stringTokenizer.nextToken().toInt()
    val c = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readLine())
    val input = CharArray(c) {
       stringTokenizer.nextToken().first()
    }.sorted()
    val list = LinkedList<Char>()
    val visited = BooleanArray(c)

    fun bt() {
        if (list.size == l && list.count { it.isVowel() } >= 1 && list.count { !it.isVowel() } >= 2) {
            list.forEach {
                bufferedWriter.append(it)
            }
            bufferedWriter.newLine()
            return
        }

        for (i in input.indices) {
            if (!visited[i] && (list.isEmpty() || list.peekLast() < input[i])) {
                visited[i] = true
                list.addLast(input[i])
                bt()
                list.pollLast()
                visited[i] = false
            }
        }
    }
    bt()

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun Char.isVowel(): Boolean {
    return when (this) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
}