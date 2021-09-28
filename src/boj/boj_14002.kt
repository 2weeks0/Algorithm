package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stringTokenizer = StringTokenizer(readLine())

    val input = IntArray(n + 1)
    for (i in 1..n) {
        input[i] = stringTokenizer.nextToken().toInt()
    }

    val cache = Array(n + 1) { i -> mutableListOf<Int>().apply { add(input[i]) } }
    for (i in 2..n) {
        for (j in 1 until i) {
            if (input[j] < input[i] && cache[i].size < cache[j].size + 1) {
                cache[i].let {
                    it.clear()
                    it.addAll(cache[j])
                    it.add(input[i])
                }
            }
        }
    }

    var answer: MutableList<Int>? = null
    for (i in 1..n) {
        if (answer == null || answer.size < cache[i].size) {
            answer = cache[i]
        }
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    bufferedWriter.append("${answer!!.size}\n")
    for (i in answer) {
        bufferedWriter.append("$i ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}