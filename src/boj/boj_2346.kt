package boj

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val deque = ArrayDeque<Balloon>()
    val n = nextInt()
    for (i in 1..n) {
        deque.add(Balloon(i, nextInt()))
    }

    while (true) {
        val temp = deque.pollFirst()
        print("${temp.index} ")
        if (deque.isEmpty()) {
            break
        }

        if (temp.num > 0) {
            for (i in 0 until temp.num - 1) {
                deque.addLast(deque.pollFirst())
            }
        } else {
            for (i in 0 until temp.num * -1) {
                deque.addFirst(deque.pollLast())
            }
        }
    }
}

class Balloon(
    val index: Int,
    val num: Int
)