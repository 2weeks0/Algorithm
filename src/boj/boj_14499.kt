package boj_14499

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
var x = 0
var y = 0
var k = 0
lateinit var map: Array<IntArray>
lateinit var input: Array<Move>

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        x = nextToken().toInt()
        y = nextToken().toInt()
        k = nextToken().toInt()
    }
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }
    input = with(StringTokenizer(readLine())) {
        Array(k) {
            Move.fromId(nextToken().toInt())
        }
    }
    close()
}

fun solve() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val dice = Dice()
    input.forEach {
        dice.roll(it)?.let { n ->
            append("$n\n")
        }
    }
    flush()
    close()
}

class Dice {
    private val diceNumbers = mutableListOf<Int>()

    init {
        repeat(6) {
            diceNumbers.add(0)
        }
    }

    fun roll(move: Move): Int? {
        if (x + move.dr !in 0 until n || y + move.dc !in 0 until m) {
            return null
        }

        when (move) {
            Move.EAST -> {
                val temp = diceNumbers[1]
                diceNumbers[1] = diceNumbers[5]
                diceNumbers[5] = diceNumbers[3]
                diceNumbers[3] = diceNumbers[4]
                diceNumbers[4] = temp
            }
            Move.WEST -> {
                val temp = diceNumbers[1]
                diceNumbers[1] = diceNumbers[4]
                diceNumbers[4] = diceNumbers[3]
                diceNumbers[3] = diceNumbers[5]
                diceNumbers[5] = temp
            }
            Move.NORTH -> {
                val temp = diceNumbers[1]
                diceNumbers[1] = diceNumbers[2]
                diceNumbers[2] = diceNumbers[3]
                diceNumbers[3] = diceNumbers[0]
                diceNumbers[0] = temp
            }
            Move.SOUTH -> {
                val temp = diceNumbers[1]
                diceNumbers[1] = diceNumbers[0]
                diceNumbers[0] = diceNumbers[3]
                diceNumbers[3] = diceNumbers[2]
                diceNumbers[2] = temp
            }
        }

        x += move.dr
        y += move.dc
        if (map[x][y] == 0) {
            map[x][y] = diceNumbers[1]
        } else {
            diceNumbers[1] = map[x][y]
            map[x][y] = 0
        }
        return diceNumbers[3]
    }
}

enum class Move(val id: Int, val dc: Int, val dr: Int) {
    EAST(1, 1, 0),
    WEST(2, -1, 0),
    NORTH(3, 0, -1),
    SOUTH(4, 0, 1);

    companion object {
        fun fromId(id: Int): Move {
            return values().first { it.id == id }
        }
    }
}
