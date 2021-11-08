package boj_12101

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var k = 0


fun main() {
    init()
    backTracking(0, LinkedList())
    if (k > 0) {
        println(-1)
    }
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    close()
}

fun backTracking(num: Int, numList: LinkedList<Int>) {
    if (n < num) {
        return
    } else if (n == num) {
        k--
        if (k == 0) {
            while (numList.isNotEmpty()) {
                if (numList.size == 1) {
                    print("${numList.pollFirst()}\n")
                } else {
                    print("${numList.pollFirst()}+")
                }
            }
        }
        return
    }

    for (i in 1..3) {
        numList.addLast(i)
        backTracking(num + i, numList)
        numList.pollLast()
    }
}