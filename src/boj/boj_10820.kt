package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val cntArray = IntArray(4)

    while (true) {
        val input = readLine()
        if (input.isNullOrEmpty()) {
            break
        }

        for (char in input) {
            val index = calculateIndex(char)
            cntArray[index] += 1
        }

        for (j in cntArray.indices) {
            bufferedWriter.append("${cntArray[j]}")
            if (j != cntArray.lastIndex) {
                bufferedWriter.append(' ')
            } else {
                bufferedWriter.append('\n')
            }
            cntArray[j] = 0
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun calculateIndex(char: Char): Int {
    return when {
        char.isLowerCase() -> {
            0
        }
        char.isUpperCase() -> {
            1
        }
        char.isDigit() -> {
            2
        }
        else -> {
            3
        }
    }
}