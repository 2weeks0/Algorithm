package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val string = readLine()
    for (char in string) {
        var input: Char?
        input = if (char.isDigit() || char == ' ') {
            char
        } else if (char.isLowerCase()) {
            val temp = (char - 'a' + 13) % 26
            'a' + temp
        } else {
            val temp = (char - 'A' + 13) % 26
            'A' + temp
        }
        bufferedWriter.append(input)
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}