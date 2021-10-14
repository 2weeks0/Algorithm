package boj_1068

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var root: Node
lateinit var deletedNode: Node
var answer = 0

fun main() {
    init()
    root.traverse()
    println(answer)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nodes = Array(readLine().toInt()) { Node() }
    readLine().split(' ').map { it.toInt() }.forEachIndexed { index, i ->
        if (i != -1) {
            nodes[i].children.addLast(nodes[index])
        } else {
            root = nodes[index]
        }
    }
    deletedNode = nodes[readLine().toInt()]
    close()
}

class Node {
    val children = LinkedList<Node>()

    fun traverse() {
        if (this == deletedNode) {
            return
        } else if (children.isEmpty() || (children.size == 1 && children.contains(deletedNode))) {
            answer++
        } else {
            children.forEach {
                it.traverse()
            }
        }
    }
}