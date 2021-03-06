package boj_13460

import java.awt.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

const val RIGHT = 0
const val LEFT = 1
const val DOWN = 2
const val UP = 3
val dy = arrayOf(0, 0, 1, -1)
val dx = arrayOf(1, -1, 0, 0)
var n = 0
var m = 0
lateinit var origin: Info
lateinit var goal: Point

fun main() {
    init()
    val depth = bfs()
    println(if (depth in 1..10) depth else -1)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    var red: Point? = null
    var blue: Point? = null
    val map = Array(n) { y ->
        with(readLine()) {
            CharArray(m) { x ->
                this[x].also {
                    when (it) {
                        'R' -> red = Point(x, y)
                        'B' -> blue = Point(x, y)
                        'O' -> goal = Point(x ,y)
                    }
                }
            }
        }
    }
    origin = Info(map, red!!, blue!!)
    close()
}

fun bfs(): Int {
    val queue = LinkedList<Info>().apply {
        add(origin)
    }
    val visited = HashMap<String, Int>().apply {
        this[queue.peekFirst().toString()] = 0
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        if (current.blue.x == goal.x && current.blue.y == goal.y) {
            continue
        } else if (current.red.x == goal.x && current.red.y == goal.y) {
            return visited[current.toString()]!!
        }

        for (d in 0 until 4) {
            val next = current.move(d)
            if (!visited.containsKey(next.toString())) {
                visited[next.toString()] = visited[current.toString()]!! + 1
                queue.addLast(next)
            }
        }
    }

    return -1
}

class Info(val map: Array<CharArray>, val red: Point, val blue: Point) {
    fun move(direction: Int): Info {
        val newMap = getNewMap()
        val newRed: Point
        val newBlue: Point
        if ((direction == RIGHT && red.x < blue.x) || (direction == LEFT && blue.x < red.x) || (direction == DOWN && red.y < blue.y) || (direction == UP && blue.y < red.y)) {
            newBlue = move(blue, direction, newMap)
            newRed = move(red, direction, newMap)
        } else {
            newRed = move(red, direction, newMap)
            newBlue = move(blue, direction, newMap)
        }
        return Info(newMap, newRed, newBlue)
    }

    private fun getNewMap(): Array<CharArray> {
        return Array(n) {
            map[it].copyOf()
        }
    }

    private fun move(point: Point, direction: Int, newMap: Array<CharArray>): Point {
        val temp = newMap[point.y][point.x]
        newMap[point.y][point.x] = '.'
        var nx = point.x
        var ny = point.y
        do {
            if (nx == goal.x && ny == goal.y) {
                return Point(nx, ny)
            }
            nx += dx[direction]
            ny += dy[direction]
        } while (nx in 0 until m && ny in 0 until n && (newMap[ny][nx] == '.' || newMap[ny][nx] == 'O'))

        nx -= dx[direction]
        ny -= dy[direction]
        newMap[ny][nx] = temp
        return Point(nx, ny)
    }

    override fun toString(): String {
        return "${red.x},${red.y},${blue.x},${blue.y}"
    }
}
