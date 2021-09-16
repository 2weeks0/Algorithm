package boj

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val deque = ArrayDeque<Char>()
    val n = nextInt()
    for (i in 0 until n) {
        deque.add('?')
    }

    val k = nextInt()
    for (i in 0 until k) {
        val s = nextInt()
        for (j in 0 until s) {
            deque.addFirst(deque.pollLast())
        }
        val first = deque.pollFirst()
        val char = next().first()

        if ((first != '?' && first != char) || deque.contains(char)) {
            print('!')
            return@with
        }

        deque.addFirst(char)
    }

    for (c in deque) {
        print(c)
    }
}
