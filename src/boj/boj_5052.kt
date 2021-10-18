package boj_5052

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var t = 0
var n = 0
val roots = LinkedList<Node>()
var cntOfLeaf = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    t = readLine().toInt()
    repeat(t) {
        init(this)
        roots.forEach {
            it.traverse()
        }
        if (cntOfLeaf == n) {
            bufferedWriter.append("YES")
        } else {
            bufferedWriter.append("NO")
        }
        bufferedWriter.newLine()
    }
    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun init(bufferedReader: BufferedReader) {
    roots.clear()
    cntOfLeaf = 0
    with(bufferedReader) {
        n = readLine().toInt()
        repeat(n) {
            val input = readLine()
            var node: Node? = null
            for (i in input.indices) {
                node = if (i == 0) {
                    roots.find { it.data == input.substring(0, 1) } ?: Node(input.substring(0, 1)).also {
                        roots.addLast(it)
                    }
                } else {
                    node!!.children.find { it.data == input.substring(0, i + 1) } ?: Node(input.substring(0, i + 1)).also {
                        node!!.children.addLast(it)
                    }
                }
            }
        }
    }
}

class Node(val data: String) {
    val children = LinkedList<Node>()

    fun traverse() {
        if (children.isEmpty()) {
            cntOfLeaf++
        } else {
            children.forEach {
                it.traverse()
            }
        }
    }
}