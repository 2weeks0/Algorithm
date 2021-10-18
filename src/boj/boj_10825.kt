package boj_10825

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

var n = 0
lateinit var array: Array<Student>

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    init()
    array.quickSort()
    array.forEach {
        append("$it\n")
    }
    flush()
    close()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = Array(n) {
        with(StringTokenizer(readLine())) {
            Student(nextToken(), nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
        }
    }
    close()
}

fun Array<Student>.quickSort(left: Int = 0, right: Int = lastIndex) {
    if (left >= right) {
        return
    }

    var l = left
    for (i in left until right) {
        if (this[i].compare(this[right])) {
            val temp = this[i]
            this[i] = this[l]
            this[l] = temp
            l++
        }
    }
    val temp = this[l]
    this[l] = this[right]
    this[right] = temp

    quickSort(left, l - 1)
    quickSort(l + 1, right)
}

class Student(val name: String, val korean: Int, val english: Int, val math: Int) {
    fun compare(other: Student): Boolean {
        if (korean != other.korean) {
            return korean > other.korean
        }

        if (english != other.english) {
            return english < other.english
        }

        if (math != other.math) {
            return math > other.math
        }

        val lastIndex = min(name.length, other.name.length)
        for (i in 0..lastIndex) {
            if (name[i] != other.name[i]) {
                return name[i] < other.name[i]
            }
        }
        return name.length < other.name.length
    }

    override fun toString(): String {
        return name
    }
}