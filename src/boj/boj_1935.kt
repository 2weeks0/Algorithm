package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val string = readLine()
    val numList = ArrayList<Int>()
    for (i in 0 until n) {
        numList.add(readLine().toInt())
    }

    val stack = Stack<Double>()
    for (char in string) {
        if (char == '*' || char == '/' || char == '+' || char == '-') {
            val b = stack.pop()
            val a = stack.pop()
            var c = 0.0
            when (char) {
                '*' -> {
                    c = a * b
                }
                '/' -> {
                    c = a / b
                }
                '+' -> {
                    c = a + b
                }
                '-' -> {
                    c = a - b
                }
            }
            stack.push(c)
        } else {
            stack.push(numList[char - 'A'].toDouble())
        }
    }
    println(String.format("%.2f", stack.pop()))
}