package boj_11725

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
lateinit var answer: IntArray
lateinit var nodes: Array<Node>

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    nodes.first().traverse()
    for (i in 1 until n) {
        append("${nodes[i].parent!!.data}")
        newLine()
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    nodes = Array(n) {
        Node(it + 1)
    }
    repeat(n - 1) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            nodes[a].linkedNodes.add(nodes[b])
            nodes[b].linkedNodes.add(nodes[a])
        }
    }
    close()
}

class Node(val data: Int, var parent: Node? = null) {
    val linkedNodes = hashSetOf<Node>()

    fun traverse(parent: Node? = null) {
        if (this.parent != null) {
            return
        }

        this.parent = parent
        linkedNodes.forEach {
            it.traverse(this)
        }
    }
}