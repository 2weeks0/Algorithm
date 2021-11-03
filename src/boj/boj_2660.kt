package boj_2660

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

var n = 0
lateinit var minDistances: Array<IntArray>

fun main() {
    init()
    floydWarshall()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    minDistances = Array(n) { r -> IntArray(n) { c -> if (r == c) 0 else Int.MAX_VALUE } }
    while (true) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            if (a == -2 && b == -2) {
                close()
                return
            }
            minDistances[a][b] = 1
            minDistances[b][a] = 1
        }
    }
}

fun floydWarshall() {
    for (k in 0 until n) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (minDistances[r][k] != Int.MAX_VALUE && minDistances[k][c] != Int.MAX_VALUE) {
                    minDistances[r][c] = min(minDistances[r][c], minDistances[r][k] + minDistances[k][c])
                }
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val candidates = LinkedList<Int>()
    val maxes = minDistances.map { it.max()!! }
    var min = Int.MAX_VALUE
    maxes.forEachIndexed { index, i ->
        if (i < min) {
            candidates.clear()
            candidates.addLast(index + 1)
            min = i
        } else if (i == min) {
            candidates.addLast(index + 1)
        }
    }
    append("$min ${candidates.size}\n")
    while (candidates.isNotEmpty()) {
        append("${candidates.pollFirst()} ")
    }
    flush()
    close()
}