package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
//    solveByDfs()
//    solveByNextPermutation()
    solveByPrevPermutation()
}

private fun solveByDfs() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val visited = BooleanArray(n)
    val list = LinkedList<Int>()

    fun dfs() {
        if (list.size == n) {
            list.forEach {
                bufferedWriter.append("$it ")
            }
            bufferedWriter.newLine()
            return
        }

        for (i in 1 .. n) {
            if (!visited[i - 1]) {
                visited[i - 1] = true
                list.addLast(i)
                dfs()
                list.pollLast()
                visited[i - 1] = false
            }
        }
    }

    dfs()
    bufferedWriter.flush()
    bufferedWriter.close()
}

private fun solveByNextPermutation() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()

    fun IntArray.nextPermutation(): IntArray? {
        var left = -1
        for (i in lastIndex - 1 downTo 0) {
            if (this[i] < this[i + 1]) {
                left = i
                break
            }
        }

        if (left == -1) {
            return null
        }

        var right = left + 1
        for (i in lastIndex downTo right) {
            if (this[left] < this[i]) {
                right = i
                break;
            }
        }

        val result = this.copyOf()
        result[left] = this[right]
        result[right] = this[left]

        for (i in left + 1 .. (lastIndex + left + 1) / 2) {
            val temp = result[i]
            result[i] = result[lastIndex + left + 1 - i]
            result[lastIndex + left + 1 - i] = temp
        }
        return result
    }

    var p: IntArray? = IntArray(n) {
        it + 1
    }

    do {
        p!!.forEach {
            bufferedWriter.append("$it ")
        }
        bufferedWriter.newLine()
        p = p.nextPermutation()
    } while (p != null)

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

private fun solveByPrevPermutation() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()

    fun IntArray.prevPermutation(): IntArray? {
        var left = -1
        for (i in lastIndex - 1 downTo 0) {
            if (this[i + 1] < this[i]) {
                left = i
                break
            }
        }

        if (left == -1) {
            return null
        }

        var right = left + 1
        for (i in lastIndex downTo right) {
            if (this[i] < this[left]) {
                right = i
                break
            }
        }

        val result = copyOf()
        result[left] = this[right]
        result[right] = this[left]

        for (i in left + 1 .. (lastIndex + left + 1) / 2) {
            val temp = result[i]
            result[i] = result[lastIndex + left + 1 - i]
            result[lastIndex + left + 1 - i] = temp
        }
        return result
    }

    var p: IntArray? = IntArray(n) {
        n - it
    }

    do {
        p!!.forEach {
            bufferedWriter.append("$it ")
        }
        bufferedWriter.newLine()
        p = p.prevPermutation()
    } while (p != null)

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}