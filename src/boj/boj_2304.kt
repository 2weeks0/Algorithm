package boj

import java.awt.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val pointList = mutableListOf<Point>()
    for (i in 0 until n) {
        val stringTokenizer = StringTokenizer(readLine())
        val x = stringTokenizer.nextToken().toInt()
        val y = stringTokenizer.nextToken().toInt()
        pointList.add(Point(x, y))
    }

    pointList.sortBy { it.x }

    val stack = LinkedList<Point>()
    pointList.forEach {
        if (stack.isEmpty()) {
            stack.addLast(it)
        } else if (stack.peekLast().y <= it.y) {
            stack.addLast(it)
        }
    }

    var b = stack.pollLast()
    var answer = 0
    while (stack.isNotEmpty()) {
        val a = stack.pollLast()
        val width = b.x - a.x
        val height = a.y
        answer += width * height
        b = a
    }

    pointList.reversed().forEach {
        if (stack.isEmpty()) {
            stack.addLast(it)
        } else if (stack.peekLast().y < it.y) {
            stack.addLast(it)
        }
    }

    var a = stack.pollLast()
    answer += a.y
    while (stack.isNotEmpty()) {
        val b = stack.pollLast()
        val width = b.x - a.x
        val height = b.y
        answer += width * height
        a = b
    }


    println(answer)
}

