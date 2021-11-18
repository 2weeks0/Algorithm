package boj_10866

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val deque = Deque()
    repeat(readLine().toInt()) {
        with(StringTokenizer(readLine())) {
            when (nextToken()) {
                "push_front" -> deque.push_front(nextToken().toInt())
                "push_back" -> deque.push_back(nextToken().toInt())
                "pop_front" -> bufferedWriter.append("${deque.pop_front()}\n")
                "pop_back" -> bufferedWriter.append("${deque.pop_back()}\n")
                "size" -> bufferedWriter.append("${deque.size()}\n")
                "empty" -> bufferedWriter.append("${deque.empty()}\n")
                "front" -> bufferedWriter.append("${deque.front()}\n")
                "back" -> bufferedWriter.append("${deque.back()}\n")
                else -> throw Exception()
            }
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

class Deque {
    class Node(val value: Int) {
        var next: Node? = null
    }

    private var root: Node? = null
    private var size = 0

    fun push_front(n: Int) {
        if (size == 0) {
            root = Node(n)
        } else {
            val node = root
            root = Node(n).apply { next = node }
        }
        size++
    }

    fun push_back(n: Int) {
        if (size == 0) {
            root = Node(n)
        } else {
            var node = root
            while (node!!.next != null) {
                node = node.next
            }
            node.next = Node(n)
        }
        size++
    }

    fun pop_front(): Int {
        if (size == 0) {
            return -1
        }
        size--
        val result = root!!.value
        root = root!!.next
        return result
    }

    fun pop_back(): Int {
        if (size == 0) {
            return -1
        } else if (size == 1) {
            size--
            val result = root!!.value
            root = null
            return result
        }

        var node = root
        repeat(size - 2) {
            node = node!!.next
        }
        val result = node!!.next!!.value
        node!!.next = null
        size--
        return result
    }

    fun size(): Int {
        return size
    }

    fun empty(): Int {
        return if (size == 0) {
            1
        } else {
            0
        }
    }

    fun front(): Int {
        return root?.value ?: -1
    }

    fun back(): Int {
        if (size == 0) {
            return -1
        }

        var node = root
        while (node!!.next != null) {
            node = node.next
        }
        return node.value
    }
}
