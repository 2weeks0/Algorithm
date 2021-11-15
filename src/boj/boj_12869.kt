package boj_12869

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

val attacks = arrayOf(
    arrayOf(9, 3, 1),
    arrayOf(9, 1, 3),
    arrayOf(3, 9, 1),
    arrayOf(3, 1, 9),
    arrayOf(1, 3, 9),
    arrayOf(1, 9, 3)
)
var n = 0
lateinit var hps: IntArray
lateinit var cache: Array<Array<IntArray>>

fun main() {
    init()
    println(recursive(0, 0, 0))
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    hps = IntArray(3)
    with(StringTokenizer(readLine())) {
        repeat(n) {
            hps[it] = nextToken().toInt()
        }
    }
    cache = Array(hps[0] + 1) { Array(hps[1] + 1) { IntArray(hps[2] + 1) } }
    close()
}

fun recursive(a: Int, b: Int, c: Int): Int {
    if (hps[0] < a || hps[1] < b || hps[2] < c) {
        return 987654321
    }

    if (cache[a][b][c] != 0) {
        return cache[a][b][c]
    } else if (a == hps[0] && b == hps[1] && c == hps[2]) {
        return 0
    }

    var result = Int.MAX_VALUE
    for (attack in attacks) {
        result = min(result, recursive(min(hps[0], a + attack[0]), min(hps[1], b + attack[1]), min(hps[2], c + attack[2])) + 1)
    }

    cache[a][b][c] = result
    return result
}