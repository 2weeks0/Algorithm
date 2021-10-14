package boj_1191

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var n = 0
private lateinit var root: Node

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    root.traversePreOrder(this)
    newLine()
    root.traverseInOrder(this)
    newLine()
    root.traversePostOrder(this)
    close()
}

private fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    val nodeArray = Array(n) {
        Node('A' + it)
    }
    root = nodeArray.first()
    repeat(n) {
        with(StringTokenizer(readLine())) {
            val index = nextToken().first() - 'A'
            val left = nextToken().first()
            if (left != '.') {
                nodeArray[index].left = nodeArray[left - 'A']
            }
            val right = nextToken().first()
            if (right != '.') {
                nodeArray[index].right = nodeArray[right - 'A']
            }
        }
    }
    close()
}

class Node(val data: Char, var left: Node? = null, var right: Node? = null) {
    fun traversePreOrder(bufferedWriter: BufferedWriter) {
        bufferedWriter.append(data)
        left?.traversePreOrder(bufferedWriter)
        right?.traversePreOrder(bufferedWriter)
    }

    fun traverseInOrder(bufferedWriter: BufferedWriter) {
        left?.traverseInOrder(bufferedWriter)
        bufferedWriter.append(data)
        right?.traverseInOrder(bufferedWriter)
    }

    fun traversePostOrder(bufferedWriter: BufferedWriter) {
        left?.traversePostOrder(bufferedWriter)
        right?.traversePostOrder(bufferedWriter)
        bufferedWriter.append(data)
    }
}