package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for (i in 0 until t) {
        var isFailed = false
        val stack = LinkedList<Char>()
        val string = readLine()
        for (c in string) {
            if (c == '(') {
                stack.add(c)
            } else {
                if (stack.isEmpty()) {
                    println("NO")
                    isFailed = true
                    break
                } else {
                    stack.poll()
                }
            }
        }
        if (isFailed) {
            continue
        } else if (stack.isNotEmpty()) {
            println("NO")
        } else {
            println("YES")
        }
    }
}