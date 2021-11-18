package boj_10845

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val queue = Queue()
    repeat(readLine().toInt()) {
        with(StringTokenizer(readLine())) {
            when (nextToken()) {
                "push" -> queue.push(nextToken().toInt())
                "pop" -> bufferedWriter.append("${queue.pop()}\n")
                "size" -> bufferedWriter.append("${queue.size()}\n")
                "empty" -> bufferedWriter.append("${queue.empty()}\n")
                "front" -> bufferedWriter.append("${queue.front()}\n")
                "back" -> bufferedWriter.append("${queue.back()}\n")
                else -> throw Exception()
            }
        }
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

class Queue {
    class Node(val value: Int) {
        var next: Node? = null
    }

    private var root: Node? = null
    private var size = 0

    fun push(n: Int) {
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

    fun pop(): Int {
        if (size == 0) {
            return -1
        }
        size--
        val result = root!!.value
        root = root!!.next
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
        if (size == 0) {
            return -1
        }
        return root!!.value
    }

    fun back(): Int {
        if (size == 0) {
            return -1
        }
        var node = root!!
        while (node.next != null) {
            node = node.next!!
        }
        return node.value
    }
}
