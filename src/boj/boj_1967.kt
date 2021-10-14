package boj_1967

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
lateinit var visited: BooleanArray
lateinit var root: Node
lateinit var secondRoot: Node
var diameter = 0

fun main() {
    init()
    if (n == 1) {
        println(0)
        return
    }
    visited[root.data - 1] = true
    root.traverse()
    visited.fill(false)
    visited[secondRoot.data - 1] = true
    secondRoot.traverse()
    println(diameter)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    visited = BooleanArray(n)
    val nodes = Array(n) {
        Node(it + 1)
    }
    repeat(n - 1) {
        with(readLine().split(' ').map { it.toInt() }) {
            nodes[this[0] - 1].linkedNodes.addLast(Pair(nodes[this[1] - 1], this[2]))
            nodes[this[1] - 1].linkedNodes.addLast(Pair(nodes[this[0] - 1], this[2]))
        }
    }
    root = nodes.first()
    close()
}

class Node(val data: Int) {
    val linkedNodes = LinkedList<Pair<Node, Int>>()

    fun traverse(length: Int = 0) {
        if (diameter < length) {
            diameter = length
            secondRoot = this
        }
        linkedNodes.forEach {
            if (!visited[it.first.data - 1]) {
                visited[it.first.data - 1] = true
                it.first.traverse(length + it.second)
            }
        }
    }
}