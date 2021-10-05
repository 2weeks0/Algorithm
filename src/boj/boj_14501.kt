package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = Array(n) {
        with(StringTokenizer(readLine())) {
            Consulting(nextToken().toInt(), nextToken().toInt())
        }
    }
    val visited = BooleanArray(n)
    val list = LinkedList<Consulting>()
    var answer = 0

    fun solve() {
        if (list.isNotEmpty() && input.indexOf(list.peekLast()) + list.peekLast().t >= n) {
            var sum = 0
            if (input.indexOf(list.peekLast()) + list.peekLast().t == n) {
                for (i in list) {
                    sum += i.p
                }
            } else {
                for (i in 0 until list.lastIndex) {
                    sum += list[i].p
                }
            }
            answer = max(answer, sum)
            return
        }

        for (i in input.indices) {
            if (!visited[i] && (list.isEmpty() || input.indexOf(list.peekLast()) + list.peekLast().t <= i)) {
                visited[i] = true
                list.addLast(input[i])
                solve()
                list.pollLast()
                visited[i] = false
            }
        }
    }
    solve()
    println(answer)
    close()
}

class Consulting(val t: Int, val p: Int)