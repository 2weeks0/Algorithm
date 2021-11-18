package boj_16935

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
var r = 0
lateinit var array: Array<IntArray>
lateinit var funcArray: IntArray

fun main() {
    init()
    funcArray.forEach {
        func(it)
    }
    printArray()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        r = nextToken().toInt()
    }
    array = Array(n) {
        with(StringTokenizer(readLine())) {
            IntArray(m) {
                nextToken().toInt()
            }
        }
    }
    funcArray = with(StringTokenizer(readLine())) {
        IntArray(r) {
            nextToken().toInt()
        }
    }
    close()
}

fun func(i: Int) {
    when (i) {
        1 -> func1()
        2 -> func2()
        3 -> func3()
        4 -> func4()
        5 -> func5()
        6 -> func6()
    }
}

fun func1() {
    for (r in 0 until n / 2) {
        for (c in 0 until m) {
            val temp = array[r][c]
            array[r][c] = array[n - 1 - r][c]
            array[n - 1 - r][c] = temp
        }
    }
}

fun func2() {
    for (r in 0 until n) {
        for (c in 0 until m / 2) {
            val temp = array[r][c]
            array[r][c] = array[r][m - 1 - c]
            array[r][m - 1 - c] = temp
        }
    }
}

fun func3() {
    val newArray = Array(m) { IntArray(n) }
    for (r in 0 until m) {
        for (c in 0 until n) {
            newArray[r][c] = array[n - 1 - c][r]
        }
    }
    array = newArray
    val temp = n
    n = m
    m = temp
}

fun func4() {
    val newArray = Array(m) { IntArray(n) }
    for (r in 0 until m) {
        for (c in 0 until n) {
            newArray[r][c] = array[c][m - 1 - r]
        }
    }
    array = newArray
    val temp = n
    n = m
    m = temp
}

fun func5() {
    for (r in 0 until n / 2) {
        for (c in 0 until m / 2) {
            val temp = array[r][c]
            array[r][c] = array[r + n / 2][c]
            array[r + n / 2][c] = array[r + n / 2][c + m / 2]
            array[r + n / 2][c + m / 2] = array[r][c + m / 2]
            array[r][c + m / 2] = temp
        }
    }
}

fun func6() {
    for (r in 0 until n / 2) {
        for (c in 0 until m / 2) {
            val temp = array[r][c]
            array[r][c] = array[r][c + m / 2]
            array[r][c + m / 2] = array[r + n / 2][c + m / 2]
            array[r + n / 2][c + m / 2] = array[r + n / 2][c]
            array[r + n / 2][c] = temp
        }
    }
}

fun printArray() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    array.forEach {
        it.forEach { i ->
            append("$i ")
        }
        newLine()
    }
    flush()
    close()
}