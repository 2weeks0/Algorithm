package boj_5639

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var root: Node

fun main() {
    init()
    root.traversePostOrder()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    root = Node(readLine().toInt())
    while (true) {
        val input = readLine() ?: break
        with(input.toInt()) {
            var node = root
            while (true) {
                if (this < node.data) {
                    if (node.left == null) {
                        node.left = Node(this)
                        break
                    } else {
                        node = node.left!!
                    }
                } else {
                    if (node.right == null) {
                        node.right = Node(this)
                        break
                    } else {
                        node = node.right!!
                    }
                }
            }
        }
    }

}

class Node(val data: Int, var left: Node? = null, var right: Node? = null) {
    fun traversePostOrder() {
        left?.traversePostOrder()
        right?.traversePostOrder()
        println(data)
    }
}