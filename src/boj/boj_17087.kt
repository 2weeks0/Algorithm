package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val s = stringTokenizer.nextToken().toInt()

    val list = mutableListOf<Int>().apply { add(s) }
    stringTokenizer = StringTokenizer(readLine())
    for (i in 0 until n) {
        list.add(stringTokenizer.nextToken().toInt())
    }
    list.sort()

    val differenceList = mutableListOf<Int>()
    for (i in 0 until n) {
        differenceList.add(list[i + 1] - list[i])
    }
    differenceList.sort()

    var answer = differenceList.first()
    for (i in differenceList) {
        answer = gcd(i, answer)
    }

    println(answer)
    close()
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}