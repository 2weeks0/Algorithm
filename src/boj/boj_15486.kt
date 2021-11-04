package boj_15486

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var n = 0
lateinit var schedules: Array<Pair<Int, Int>>
lateinit var income: IntArray

fun main() {
    init()
    dp()
    println(max(income[n - 1], income[n]))
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    schedules = Array(n) {
        with(StringTokenizer(readLine())) {
            val t = nextToken().toInt()
            val p = nextToken().toInt()
            Pair(t, p)
        }
    }
    income = IntArray(n + 1)
    close()
}

fun dp() {
    for (i in 0 until n) {
        if (1 <= i) {
            income[i] = max(income[i], income[i - 1])
        }
        val day = i + schedules[i].first
        if (day in 1..n) {
            income[day] = max(income[day], income[i] + schedules[i].second)
        }
    }
}
