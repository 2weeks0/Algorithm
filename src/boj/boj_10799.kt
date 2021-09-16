package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()
    var answer = 0
    var pipeCnt = 0
    var before = '('
    for (c in input) {
        if (c == '(') {
            pipeCnt++
        } else {
            pipeCnt--
            if (before == '(') {
                answer += pipeCnt
            } else {
                answer++
            }
        }
        before = c
    }
    println(answer)
}