package boj_1005

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var k = 0
lateinit var costs: IntArray
lateinit var graph: Array<LinkedList<Int>>
lateinit var graphTransposed: Array<LinkedList<Int>>
lateinit var open: BooleanArray
var destination = 0

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(bufferedReader.readLine().toInt()) {
        init(bufferedReader)
        val costArray = Array(n) { LinkedList<Int>() }
        val order = LinkedList<Int>()
        val visited = BooleanArray(n)
        dfsPostOrder(destination, order, visited)
        traverse(costArray, order)
        var answer = 0
        for (i in 0 until n) {
            if (open[i]) {
                answer = Math.max(costArray[i].max() ?: 0, answer)
            }
        }
        bufferedWriter.append("$answer\n")
    }
    bufferedReader.close()
    bufferedWriter.let {
        it.flush()
        it.close()
    }
}

fun init(bufferedReader: BufferedReader) {
    with(StringTokenizer(bufferedReader.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    costs = with(StringTokenizer(bufferedReader.readLine())) {
        IntArray(n) {
            nextToken().toInt()
        }
    }
    graph = Array(n) { LinkedList() }
    graphTransposed = Array(n) { LinkedList() }
    open = BooleanArray(n) { true }
    repeat(k) {
        with(StringTokenizer(bufferedReader.readLine())) {
            val x = nextToken().toInt() - 1
            val y = nextToken().toInt() - 1
            graph[x].addLast(y)
            graphTransposed[y].addLast(x)
            open[y] = false
        }
    }
    destination = bufferedReader.readLine().toInt() - 1
}

fun dfsPostOrder(current: Int, order: LinkedList<Int>, visited: BooleanArray) {
    for (prev in graphTransposed[current]) {
        if (!visited[prev]) {
            visited[prev] = true
            dfsPostOrder(prev, order, visited)
        }
    }
    order.addLast(current)
}

fun traverse(costArray: Array<LinkedList<Int>>, order: LinkedList<Int>) {
    while (order.isNotEmpty()) {
        val n = order.pollLast()
        var max = 0
        for (i in graph[n]) {
            max = Math.max(max, costArray[i].max() ?: 0)
        }
        costArray[n].addLast(costs[n] + max)
    }
}