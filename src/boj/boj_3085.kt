package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = Array(n) {
        val line = readLine()
        CharArray(n) {
            line[it]
        }
    }

    var answer = 0
    val dr = arrayOf(0, 0, 1, -1)
    val dc = arrayOf(1, -1, 0, 0)
    for (r in 0 until n) {
        for (c in 0 until n) {
            for (d in 0 until 4) {
                val nr = r + dr[d]
                val nc = c + dc[d]
                if (nr in 0 until n && nc in 0 until n) {
                    // 위치 바꾸기
                    val temp = input[r][c]
                    input[r][c] = input[nr][nc]
                    input[nr][nc] = temp

                    // 세로 탐색
                    var cnt = 1
                    var char = input[0][c]
                    for (i in 1 until n) {
                        if (char == input[i][c]) {
                            cnt++
                        } else {
                            answer = max(answer, cnt)
                            cnt = 1
                            char = input[i][c]
                        }
                    }
                    answer = max(answer, cnt)

                    // 가로 탐색
                    cnt = 1
                    char = input[r][0]
                    for (i in 1 until n) {
                        if (char == input[r][i]) {
                            cnt++
                        } else {
                            answer = max(answer, cnt)
                            cnt = 1
                            char = input[r][i]
                        }
                    }
                    answer = max(answer, cnt)

                    // 바꾼 위치 되돌리기
                    input[nr][nc] = input[r][c]
                    input[r][c] = temp
                }
            }
        }
    }

    println(answer)
    close()
}