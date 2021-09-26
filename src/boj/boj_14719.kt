package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = LinkedList<Int>()
    var stringTokenizer = StringTokenizer(readLine())
    val h = stringTokenizer.nextToken().toInt()
    val w = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readLine())
    var answer = 0
    val hList = mutableListOf<Int>()
    for (i in 0 until w) {
        hList.add(stringTokenizer.nextToken().toInt())
    }

    hList.forEach {
        if (stack.isEmpty()) {
            stack.addLast(it)
        } else if (stack.first >= it) {
            stack.addLast(it)
        } else {
            while (stack.isNotEmpty()) {
                answer += stack.first - stack.pollLast()
            }
            stack.addLast(it)
        }
    }

    stack.clear()
    hList.reversed().forEach{
        if (stack.isEmpty()) {
            stack.addLast(it)
        } else if (stack.first > it) {
            stack.addLast(it)
        } else {
            while (stack.isNotEmpty()) {
                answer += stack.first - stack.pollLast()
            }
            stack.addLast(it)
        }
    }

    println(answer)
    close()
}
