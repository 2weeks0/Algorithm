package boj_2263

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var n = 0
lateinit var inOrder: IntArray
lateinit var postOrder: IntArray
var root = 0

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    preOrder(root, this)
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    with(readLine().split(' ').map { it.toInt() }) {
        inOrder = IntArray(n) {
            this[it]
        }
    }
    with(readLine().split(' ').map { it.toInt() }) {
        postOrder = IntArray(n) {
            this[it]
        }
    }
    root = postOrder.last()
    close()
}

fun preOrder(root: Int, bufferedWriter: BufferedWriter) {
    val idxInOrder = inOrder.indexOf(root)
    val idxPostOrder = postOrder.indexOf(root)
    bufferedWriter.append("${inOrder[idxInOrder]} ")
    print("${inOrder[idxInOrder]} ")

    if (0 != idxInOrder) {
        val leftRoot = postOrder[postOrder.indexOf(inOrder[idxInOrder + 1]) - 1]
        preOrder(leftRoot, bufferedWriter)
    }

    if (idxInOrder <= idxPostOrder) {
        val rightRoot = postOrder[idxPostOrder - 1]
        preOrder(rightRoot, bufferedWriter)
    }
}


