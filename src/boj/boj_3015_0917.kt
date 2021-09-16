package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var answer: Long = 0
    val stack = LinkedList<Person>()
    for (i in 0 until n) {
        val height = readLine().toInt()
        val person = Person(height)
        do {
            val top = stack.peekLast()
            when {
                top == null  -> {
                    stack.addLast(person)
                }
                height < top.height -> {
                    answer++
                    stack.addLast(person)
                }
                top.height < height -> {
                    answer += top.num
                    stack.pollLast()
                }
                else -> {
                    answer += top.num
                    stack.pollLast()
                    person.num += top.num
                }
            }
        } while (top != null && top.height <= height)
        println("height: $height, stack: $stack, answer: $answer")
    }
    println(answer)
}

class Person(
    val height: Int,
    var num: Int = 1
) {
    override fun toString(): String {
        return "($height, $num)"
    }
}