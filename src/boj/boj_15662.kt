package boj_15662

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var t = 0
lateinit var gears: Array<Gear>
var k = 0
lateinit var rotates: Array<Rotate>

fun main() {
    init()
    rotate()
    println(gears.count { it.getTopPole() == Gear.Pole.S })
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    t = readLine().toInt()
    gears = Array(t) {
        Gear(readLine().map { Gear.Pole.fromId(it - '0') })
    }
    k = readLine().toInt()
    rotates = Array(k) {
        with(StringTokenizer(readLine())) {
            Rotate(nextToken().toInt() - 1, Rotate.Direction.fromId(nextToken().toInt()))
        }
    }
    close()
}

fun rotate() {
    val temp = LinkedList<Rotate>()
    rotates.forEach {
        temp.addLast(it)
        var direction = it.direction
        for (i in it.targetIndex + 1 until t) {
            if (gears[i - 1].getRightPole() == gears[i].getLeftPole()) {
                break
            }
            direction = !direction
            temp.addLast(Rotate(i, direction))
        }
        direction = it.direction
        for (i in it.targetIndex - 1 downTo 0) {
            if (gears[i].getRightPole() == gears[i + 1].getLeftPole()) {
                break
            }
            direction = !direction
            temp.addLast(Rotate(i, direction))
        }

        while (temp.isNotEmpty()) {
            val rotate = temp.pollLast()
            gears[rotate.targetIndex].rotate(rotate.direction)
        }
    }
}

class Gear(poles: List<Pole>) {
    private val teeth = LinkedList<Pole>()

    init {
        poles.forEach {
            this.teeth.addLast(it)
        }
    }

    fun rotate(rotateDirection: Rotate.Direction) {
        when (rotateDirection) {
            Rotate.Direction.CLOCKWISE -> teeth.addFirst(teeth.pollLast())
            Rotate.Direction.ANTICLOCKWISE -> teeth.addLast(teeth.pollFirst())
        }
    }

    fun getTopPole(): Pole {
        return teeth.peekFirst()
    }

    fun getLeftPole(): Pole {
        return teeth[teeth.size / 4 * 3]
    }

    fun getRightPole(): Pole {
        return teeth[teeth.size / 4]
    }

    enum class Pole(val id: Int) {
        S(1), N(0);

        companion object {
            fun fromId(id: Int): Pole {
                return values().first { it.id == id }
            }
        }
    }
}

class Rotate(val targetIndex: Int, val direction: Direction) {
    enum class Direction(val id: Int) {
        CLOCKWISE(1), ANTICLOCKWISE(-1);

        companion object {
            fun fromId(id: Int): Direction {
                return values().first { it.id == id }
            }
        }

        operator fun not(): Direction {
            return values().first { it.id == -1 * id }
        }
    }
}