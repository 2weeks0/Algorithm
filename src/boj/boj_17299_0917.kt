package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val inputList = ArrayList<Int>()
    val cntMap = HashMap<Int, Int>()
    val stringTokenizer = StringTokenizer(readLine())
    for (i in 0 until n) {
        val num = stringTokenizer.nextToken().toInt()
        inputList.add(num)
        cntMap.putIfAbsent(num, 0)
        cntMap[num] = cntMap[num]!!.plus(1)
    }

    val stack = LinkedList<Int>()
    val answer = Array(n){ -1 }
    for (i in 0 until n) {
        while (stack.isNotEmpty() && cntMap[inputList[stack.peekLast()]]!! < cntMap[inputList[i]]!!) {
            answer[stack.pollLast()] = inputList[i]
        }
        stack.addLast(i)
    }

    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    for (i in answer) {
        bufferedWriter.append("$i ")
    }
    bufferedWriter.flush()
    bufferedWriter.close()
}