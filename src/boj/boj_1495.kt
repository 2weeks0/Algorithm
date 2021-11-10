package boj_1495

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var s = 0
var m = 0
lateinit var volumes: IntArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        s = nextToken().toInt()
        m = nextToken().toInt()
    }
    volumes = with(StringTokenizer(readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    close()
}

fun solve() {
    val cache = IntArray(m + 1) { -1 }.apply { this[s] = 0 }
    val temp = LinkedList<Int>()

    for (i in 0 until n) {
        for (j in 0..m) {
            if (cache[j] == i) {
              temp.addLast(j)
            }
        }
        while (temp.isNotEmpty()) {
            val v = temp.pollFirst()
            if (0 <= v - volumes[i]) {
                cache[v - volumes[i]] = i + 1
            }
            if (v + volumes[i] <= m) {
                cache[v + volumes[i]] = i + 1
            }
        }
    }

    var answer = -1
    for (i in m downTo 0) {
        if (cache[i] == n) {
            answer = i
            break
        }
    }
    println(answer)
}