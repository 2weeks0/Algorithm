package boj

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val k = nextInt()

    val deque = ArrayDeque<Int>()
    for (i in 1..n) {
        deque.add(i)
    }

    print("<")
    while (deque.isNotEmpty()) {
        for (i in 0 until k - 1) {
            deque.addLast(deque.pollFirst())
        }

        when (deque.size) {
            1    -> {
                print("${deque.pollFirst()}")
            }
            else -> {
                print("${deque.pollFirst()}, ")
            }
        }
    }
    print(">")
}