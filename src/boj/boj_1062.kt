package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private val basicChar = arrayOf('a', 'n', 't', 'i', 'c')
private var n = 0
private var k = 0
private lateinit var input: Array<String>
private val visited = BooleanArray(26).apply {
    basicChar.forEach {
        this[it - 'a'] = true
    }
}
private var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    if (k - basicChar.size < 0) {
        println(0)
        return@with
    }

    input = Array(n) {
        with(readLine()) {
            substring(4, length - 4)
        }
    }

    bt(0, 0)

    println(answer)
    close()
}

private fun bt(depth: Int, idx: Int) {
    if (depth == k - basicChar.size) {
        var temp = 0
        input.forEach {
            if (it.find { c -> !visited[c - 'a'] } == null) {
                temp++
            }
        }
        answer = max(answer, temp)
        return
    }

    for (i in idx until 26) {
        if (!visited[i]) {
            visited[i] = true
            bt(depth + 1, i + 1)
            visited[i] = false
        }
    }
}