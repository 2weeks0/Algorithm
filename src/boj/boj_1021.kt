package boj

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()
    val list = mutableListOf<Int>()

    val deque = ArrayDeque<Int>()
    for (i in 1 .. n) {
        deque.add(i)
    }

    for (i in 0 until m) {
        list.add(nextInt())
    }

    var answer = 0

    list.forEach {
        val targetIndex = deque.indexOf(it)
        when {
            targetIndex == 0                    -> {
                deque.removeFirst()
            }
            targetIndex < deque.size - targetIndex -> {
                for (i in 0 until targetIndex) {
                    val temp = deque.pollFirst()
                    deque.addLast(temp)
                    answer++
                }
                deque.removeFirst()
            }
            else                                   -> {
                for (i in 0 until deque.size - targetIndex) {
                    val temp = deque.pollLast()
                    deque.addFirst(temp)
                    answer++
                }
                deque.removeFirst()
            }
        }
    }

    println(answer)
}
