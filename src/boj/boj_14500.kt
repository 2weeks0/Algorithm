package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val input = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }

    val blueDr = arrayOf(0, 0, 0, 1, 2, 3)
    val blueDc = arrayOf(1, 2, 3, 0, 0, 0)
    val yellowDr = arrayOf(0, 1, 1)
    val yellowDc = arrayOf(1, 0, 1)
    val orangeDr = arrayOf(1, 2, 2,  0, 0, -1,  -1, -2, -2,  0, 0, -1,  0, 0, 1,  1, 2, 2,  -1, -2, -2,  0, 0, 1)
    val orangeDc = arrayOf(0, 0, 1,  1, 2, 2,  0, 0, -1,  -1, -2, -2,  -1, -2, -2,  0, 0, -1,  0, 0, 1,  1, 2, 2)
    val greenDr = arrayOf(1, 1, 2,  0, 1, 1,  -1, -1, -2,  0, 1, 1)
    val greenDc = arrayOf(0, 1, 1,  -1, -1, -2,  0, 1, 1,  1, 1, 2)
    val purpleDr = arrayOf(0, 0, 1,  1, 2, 1,  0, 0, -1,  1, 2, 1)
    val purpleDc = arrayOf(1, 2, 1,  0, 0, -1,  1, 2, 1,  0, 0, 1)

    val dr = blueDr + yellowDr + orangeDr + greenDr + purpleDr
    val dc = blueDc + yellowDc + orangeDc + greenDc + purpleDc

    var answer = 0
    for (r in 0 until n) {
        for (c in 0 until m) {
            for (i in dr.indices step 3) {
                var sum = input[r][c]
                var skipMax = false
                for (j in 0 until 3) {
                    if (!(r + dr[i + j] in 0 until n && c + dc[i + j] in 0 until m)) {
                        skipMax = true
                        break
                    }
                    sum += input[r + dr[i + j]][c + dc[i + j]]
                }
                if (!skipMax) {
                    answer = max(answer, sum)
                }
            }
        }
    }

    println(answer)
    close()
}