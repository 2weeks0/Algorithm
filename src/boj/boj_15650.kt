//package boj
//
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.lang.StringBuilder
//import java.util.*
//import kotlin.math.pow
//
//fun boj.main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
//    val stringTokenizer = StringTokenizer(readLine())
//    val n = stringTokenizer.nextToken().toInt()
//    val m = stringTokenizer.nextToken().toInt()
//
//    for (i in 2.pow(m) - 1 until 2.pow(n)) {
//        var cnt = 0
//        for (j in 0 .. n) {
//            if (i and 2.pow(j) == 2.pow(j)) {
//                cnt++
//            }
//        }
//        if (cnt == m) {
//            for (k in 0 until n) {
//                if (i and 2.pow(k) == 2.pow(k)) {
//                    bufferedWriter.append("${k + 1} ")
//                }
//            }
//            bufferedWriter.append('\n')
//        }
//    }
//
//    bufferedWriter.flush()
//    bufferedWriter.close()
//    close()
//}
//
//private fun Int.pow(n: Int) = toDouble().pow(n).toInt()

package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()
    val numList = LinkedList<Int>()

    dfs(n, m, numList, bufferedWriter)

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun dfs(n: Int, m: Int, numList: LinkedList<Int>, bufferedWriter: BufferedWriter) {
    if (numList.size == m) {
        numList.forEach{
            bufferedWriter.append("${it + 1} ")
        }
        bufferedWriter.append('\n')
        return
    }

    for (i in 0 until n) {
        if (numList.isEmpty() || numList.peekLast() < i) {
            numList.addLast(i)
            dfs(n, m, numList, bufferedWriter)
            numList.pollLast()
        }
    }
}