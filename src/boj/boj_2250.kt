package boj_2250

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.*

private var n = 0
private lateinit var root: Node
private lateinit var minArray: IntArray
private lateinit var maxArray: IntArray
private var x = 0

fun main() {
    init()
    root.traverseInOrder()
    var max = 0
    var level = 0
    for (i in n - 1 downTo 0) {
        with(maxArray[i] - minArray[i]) {
            if (max <= this + 1) {
                max = this + 1
                level = i + 1
            }
        }
    }
    println("$level $max")
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    val nodeArray = Array(n) {
        Node(it + 1)
    }

    val canRoot = hashSetOf<Int>()
    for (i in 0 until n) {
        canRoot.add(i)
    }

    repeat(n) {
        with(StringTokenizer(readLine())) {
            val index = nextToken().toInt() - 1
            val left = nextToken().toInt() - 1
            if (left != -2) {
                nodeArray[index].left = nodeArray[left]
                canRoot.remove(left)
            }
            val right = nextToken().toInt() - 1
            if (right != -2) {
                nodeArray[index].right = nodeArray[right]
                canRoot.remove(right)
            }
        }
    }

    root = nodeArray[canRoot.first()]
    minArray = IntArray(n) { n }
    maxArray = IntArray(n)
    close()
}

class Node(val key: Int, var left: Node? = null, var right: Node? = null) {
    fun traverseInOrder(depth: Int = 0) {
        left?.traverseInOrder(depth + 1)
        minArray[depth] = min(minArray[depth], x)
        maxArray[depth] = max(maxArray[depth], x++)
        right?.traverseInOrder(depth + 1)
    }
}