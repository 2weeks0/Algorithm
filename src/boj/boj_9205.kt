package boj_9205

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

var n = 0
lateinit var points: Array<Point>
lateinit var success: Array<BooleanArray>

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        floydWarshall()
        printAnswer(bufferedWriter)
    }
    bufferedWriter.let {
        it.flush()
        it.close()
    }
    bufferedReader.close()
}

fun init(bufferedReader: BufferedReader) {
    n = bufferedReader.readLine().toInt()
    points = Array(n + 2) {
        with(StringTokenizer(bufferedReader.readLine())) {
            Point(nextToken().toInt(), nextToken().toInt())
        }
    }
    success = Array(n + 2) { BooleanArray(n + 2) }
}

fun floydWarshall() {
    for (k in -1 until n + 2) {
        for (r in 0 until n + 2) {
            for (c in 0 until n + 2) {
                if (k == -1) {
                    success[r][c] = points[r].getDistance(points[c]) <= 1000
                } else if (!success[r][c]) {
                    success[r][c] = success[r][k] && success[k][c]
                }
            }
        }
    }
}

fun printAnswer(bufferedWriter: BufferedWriter) {
    val answer = if (success[0][n + 1]) {
        "happy"
    } else {
        "sad"
    }
    bufferedWriter.append("$answer\n")
}

class Point(val x: Int, val y: Int) {
    fun getDistance(other: Point): Int {
        return abs(x - other.x) + abs(y - other.y)
    }
}