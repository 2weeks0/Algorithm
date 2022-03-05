package boj_17135

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.max

const val EMPTY = 0
const val ENEMY = 1
const val CNT_ARCHER = 3

var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val d = st.nextToken().toInt()

    val map = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }

    combination(n, m, d, map, hashSetOf(), 0, 0)
    println(answer)
    close()
}

fun combination(
    n: Int,
    m: Int,
    d: Int,
    map: Array<IntArray>,
    archerSet: MutableSet<Point>,
    cnt: Int,
    idx: Int
) {
    if (cnt == CNT_ARCHER) {
        calculate(n, m, d, map, archerSet)
        return
    }

    for (c in idx until m) {
        val point = Point(n, c)
        archerSet.add(point)
        combination(n, m, d, map, archerSet, cnt + 1, c + 1)
        archerSet.remove(point)
    }
}

fun calculate(n: Int, m: Int, d: Int, map: Array<IntArray>, archerSet: MutableSet<Point>) {
    val nMap = Array(n) { r ->
        IntArray(m) { c ->
            map[r][c]
        }
    }
    var cnt = 0
    val targetSet = hashSetOf<Point>()

    repeat (n) {
        for (archer in archerSet) {
            var target: Point? = null
            var dist = d
            outer@ for (c in 0 until m) {
                for (r in n - 1 downTo 0) {
                    if (nMap[r][c] == ENEMY) {
                        val temp = getDistance(archer.r, archer.c, r, c)
                        if (dist < temp) {
                            continue
                        }
                        if (target == null || temp < dist || (temp == dist && c < target.c)) {
                            target = Point(r, c)
                            dist = temp
                        }
                        continue@outer
                    }
                }
            }
            target?.let {
                targetSet.add(it)
            }
        }

        cnt += targetSet.size
        targetSet.forEach {
            nMap[it.r][it.c] = EMPTY
        }
        targetSet.clear()

        for (c in 0 until m) {
            nMap[n - 1][c] = 0
            for (r in n - 2 downTo 0) {
                if (nMap[r][c] == ENEMY) {
                    nMap[r + 1][c] = ENEMY
                    nMap[r][c] = EMPTY
                }
            }
        }
    }



    answer = max(answer, cnt)
}

fun getDistance(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    return abs(r1 - r2) + abs(c1 - c2)
}

class Point(var r: Int, val c: Int) {
    fun clone(): Point {
        return Point(r, c)
    }

    override fun hashCode(): Int {
        return 100 * r + c
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Point) {
            return false
        }
        return r == other.r && c == other.c
    }
}