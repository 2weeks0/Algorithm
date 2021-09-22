package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stringTokenizer = StringTokenizer(readLine())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()
    val c = stringTokenizer.nextToken().toInt()

    println((a + b) % c)
    println(((a % c) + (b % c)) % c)
    println((a * b) % c)
    println(((a % c) * (b % c)) % c)

    close()
}