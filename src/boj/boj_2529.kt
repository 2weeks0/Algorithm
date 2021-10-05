package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.properties.Delegates

private val stringBuilder = StringBuilder()
private val answer = mutableListOf<String>()
private val visited = BooleanArray(10)
private var n by Delegates.notNull<Int>()
private lateinit var input: String

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    input = readLine().replace(" ", "")

    maxPermutation()
    stringBuilder.clear()
    for (i in visited.indices) {
        visited[i] = false
    }
    minPermutation()

    answer.forEach {
        println(it)
    }
    close()
}

private fun maxPermutation() {
    if (stringBuilder.length == n + 1) {
        for (i in input.indices) {
            if (!(input[i] == '<' && stringBuilder[i] < stringBuilder[i + 1]) && !(input[i] == '>' && stringBuilder[i] > stringBuilder[i + 1])) {
                return
            }
        }
        answer.add(stringBuilder.toString())
        return
    }

    for (i in 9 downTo 0) {
        if (!visited[i] && answer.size == 0) {
            visited[i] = true
            stringBuilder.append(i)
            maxPermutation()
            stringBuilder.deleteCharAt(stringBuilder.lastIndex)
            visited[i] = false
        }
    }
}

private fun minPermutation() {
    if (stringBuilder.length == n + 1) {
        for (i in input.indices) {
            if (!(input[i] == '<' && stringBuilder[i] < stringBuilder[i + 1]) && !(input[i] == '>' && stringBuilder[i] > stringBuilder[i + 1])) {
                return
            }
        }
        answer.add(stringBuilder.toString())
        return
    }

    for (i in 0..9) {
        if (!visited[i] && answer.size == 1) {
            visited[i] = true
            stringBuilder.append(i)
            minPermutation()
            stringBuilder.deleteCharAt(stringBuilder.lastIndex)
            visited[i] = false
        }
    }
}
