package boj_14503

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var map: Array<Array<MapState>>
lateinit var cleaner: Cleaner

fun main() {
    init()
    cleaner.clean(map)
    println(cleaner.cntOfClean)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    with(StringTokenizer(readLine())) {
        cleaner = Cleaner(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
    }
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            Array(m) {
                MapState.fromId(nextToken().toInt())
            }
        }
    }
    close()
}

enum class MapState(private val id: Int) {
    CLEANED(-1),
    DIRTY(0),
    WALL(1);

    companion object {
        fun fromId(id: Int): MapState {
            return values().first { it.id == id }
        }
    }
}

class Cleaner(r: Int, c: Int, directionId: Int) {
    var cntOfClean = 0
    private var position: Position
    private var direction: Direction

    init {
        position = Position(r, c)
        direction = Direction.fromId(directionId)
    }

    fun clean(map: Array<Array<MapState>>) {
        while (true) {
            if (map[position.r][position.c] == MapState.DIRTY) {
                map[position.r][position.c] = MapState.CLEANED
                cntOfClean++
            }

            val left = position.getLeft(direction)
            if (map[left.r][left.c] == MapState.DIRTY) {
                direction = direction.rotate()
                position = left
            } else if (!position.getAdjustPositions().any { map[it.r][it.c] == MapState.DIRTY }) {
                val back = position.getBack(direction)
                if (map[back.r][back.c] == MapState.WALL) {
                    return
                } else {
                    position = back
                }
            } else {
                direction = direction.rotate()
            }
        }
    }

    class Position(var r: Int, var c: Int) {
        private fun fromDifference(dr: Int, dc: Int): Position {
            return Position(r + dr, c + dc)
        }

        fun getLeft(direction: Direction): Position {
            return when (direction) {
                Direction.NORTH -> fromDifference(0, -1)
                Direction.EAST -> fromDifference(-1, 0)
                Direction.SOUTH -> fromDifference(0, 1)
                Direction.WEST -> fromDifference(1, 0)
            }
        }

        fun getBack(direction: Direction): Position {
            return when (direction) {
                Direction.NORTH -> fromDifference(1, 0)
                Direction.EAST -> fromDifference(0, -1)
                Direction.SOUTH -> fromDifference(-1, 0)
                Direction.WEST -> fromDifference(0, 1)
            }
        }

        fun getAdjustPositions(): Array<Position> {
            return arrayOf(
                fromDifference(0, 1),
                fromDifference(0, -1),
                fromDifference(1, 0),
                fromDifference(-1, 0)
            )
        }
    }

    enum class Direction(private val id: Int) {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        companion object {
            fun fromId(id: Int): Direction {
                return values().first { it.id == id }
            }
        }

        fun rotate(): Direction {
            return fromId(if (id == 0) 3 else id - 1)
        }
    }
}
