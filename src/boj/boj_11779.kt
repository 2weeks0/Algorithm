package boj_11779

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var busses: Array<LinkedList<Pair<Int, Int>>>
var start = 0
var destination = 0
lateinit var preves: IntArray
lateinit var distance :IntArray

fun main() {
    init()
    dijkstra()
    printAnswer()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    m = readLine().toInt()
    busses = Array(n) { LinkedList<Pair<Int, Int>>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            val w = nextToken().toInt()
            busses[u].addLast(Pair(v, w))
        }
    }
    with(StringTokenizer(readLine())) {
        start = nextToken().toInt() - 1
        destination = nextToken().toInt() - 1
    }
    preves = IntArray(n) { -1 }
    distance = IntArray(n) { Int.MAX_VALUE }
    close()
}

fun dijkstra() {
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() { i1, i2 ->
        i1.second.compareTo(i2.second)
    }.apply { add(Pair(start, 0)) }
    distance[start] = 0

    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        if (current.first == destination) {
            return
        }
        for (next in busses[current.first]) {
            if (next.second + current.second < distance[next.first]) {
                distance[next.first] = next.second + current.second
                priorityQueue.add(Pair(next.first, distance[next.first]))
                preves[next.first] = current.first
            }
        }
    }
}

fun printAnswer() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    append("${distance[destination]}\n")
    val stack = LinkedList<Int>().apply { addLast(destination) }
    var temp = destination
    while (preves[temp] != -1) {
        temp = preves[temp]
        stack.addLast(temp)
    }
    append("${stack.size}\n")
    while (stack.isNotEmpty()) {
        append("${stack.pollLast() + 1} ")
    }
    flush()
    close()
}