package boj_11066

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

var k = 0
lateinit var costs: IntArray

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        solve(bufferedWriter)
    }

    bufferedReader.close()
    bufferedWriter.flush()
    bufferedWriter.close()
}

fun init(bufferedReader: BufferedReader) {
    k = bufferedReader.readLine().toInt()
    costs = with(StringTokenizer(bufferedReader.readLine())) {
        IntArray(k) {
            nextToken().toInt()
        }
    }
}

fun solve(bufferedWriter: BufferedWriter) {
    val cache = Array(k) { i ->
        IntArray(k) { j ->
            if (i == j) {
                0
            } else if (j - i == 1 || i - j == 1) {
                costs[i] + costs[j]
            } else {
                Int.MAX_VALUE
            }
        }
    }

    val sum = IntArray(k) { costs[it] }
    for (i in 1 until k) {
        sum[i] += sum[i - 1]
    }

    fun sum(i: Int, j: Int): Int {
        return if (i == 0) {
            sum[j]
        } else {
            sum[j] - sum[i - 1]
        }
    }

    for (d in 0 until k) {
        for (i in 0 until k - d) {
            for (k in i until i + d) {
                if (cache[i][k] != Int.MAX_VALUE && cache[k + 1][i + d] != Int.MAX_VALUE) {
                    cache[i][i + d] = min(cache[i][i + d], cache[i][k] + cache[k + 1][i + d] + sum(i, i + d))
                }
            }
        }
    }

    bufferedWriter.append("${cache[0][k - 1]}\n")
}
