package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val intArray = IntArray(4)
    for (i in intArray.indices) {
        intArray[i] = stringTokenizer.nextToken().toInt()
    }

    val a: Long = "%d%d".format(intArray[0], intArray[1]).toLong()
    val b: Long = "%d%d".format(intArray[2], intArray[3]).toLong()

    println(a + b)
    close()
}
