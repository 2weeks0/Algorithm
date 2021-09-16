package boj

import java.awt.Point
import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val map = Array(n + 1) { IntArray(n + 1) }
    val k = nextInt()

    for (i in 0 until k) {
        val r = nextInt()
        val c = nextInt()
        map[r][c] = 1
    }

    val turnMap = HashMap<Int, Char>()
    val l = nextInt()
    for (i in 0 until l) {
        turnMap[nextInt()] = next().first()
    }

    var sec = 0
    var direction = 0
    val dx = arrayOf(1 ,0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    val snake = LinkedList<Point>().apply { add(Point(1, 1)) }
    while (true) {
        sec++
        val head = Point(snake.first.x + dx[direction], snake.first.y + dy[direction])
        snake.addFirst(head)

        if (head.x < 1 || head.x > n || head.y < 1 || head.y > n) {
            println(sec)
            break
        }
        if (snake.count { it.x == head.x && it.y == head.y } == 2) {
            println(sec)
            break
        }

        if (map[head.y][head.x] == 1) {
            map[head.y][head.x] = 0
        } else {
            snake.pollLast()
        }

        if (turnMap.containsKey(sec)) {
            direction = if (turnMap[sec] == 'D') {
                (direction + 1) % 4
            } else {
                if (direction == 0) 3 else direction - 1
            }
            turnMap.remove(sec)
        }
    }
}