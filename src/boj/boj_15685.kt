package boj_15685

import java.awt.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

const val RIGHT = 0
const val UP = 1
const val LEFT = 2
const val DOWN = 3
var n = 0
val dragonSpines = LinkedList<DragonSpine>()
lateinit var map: Array<BooleanArray>

fun main() {
    init()
    dragonSpines.forEach {
        it.run()
        it.checkMap()
    }
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    repeat(n) {
        with(StringTokenizer(readLine())) {
            val x = nextToken().toInt()
            val y = nextToken().toInt()
            val d = nextToken().toInt()
            val g = nextToken().toInt()
            dragonSpines.addLast(DragonSpine(x, y, d, g))
        }
    }
    map = Array(101) { BooleanArray(101) }
    close()
}

fun printAnswer() {
    var answer = 0
    for (y in 0 until 100) {
        for (x in 0 until 100) {
            if (map[y][x] && map[y + 1][x] && map[y][x + 1] && map[y + 1][x + 1]) {
                answer++
            }
        }
    }
    println(answer)
}

class DragonSpine(x: Int, y: Int, d: Int, private val g: Int) {
    private val values = ArrayList<Point>()

    init {
        values.add(Point(x, y))
        when (d) {
            RIGHT -> Point(x + 1, y)
            UP -> Point(x, y - 1)
            LEFT -> Point(x - 1, y)
            DOWN -> Point(x, y + 1)
            else -> throw Exception()
        }.also { values.add(it) }
    }

    fun run() {
        repeat(g) {
            val last = values.last()
            val size = values.size
            for (i in size - 1 downTo 0) {
                values.add(getFlippedPoint(values[i], last))
            }
        }
    }

    private fun getFlippedPoint(current: Point, last: Point): Point {
        val dx = last.x - current.x
        val dy = last.y - current.y
        return Point(last.x + dy, last.y - dx)
    }

    fun checkMap() {
        values.forEach {
            map[it.y][it.x] = true
        }
    }
}