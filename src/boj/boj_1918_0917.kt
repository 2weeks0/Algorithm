package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferWriter = BufferedWriter(OutputStreamWriter(System.out))
    val stack = LinkedList<Char>()
    val input = readLine()
    for (c in input) {
        when (c) {
            '(' -> {
                stack.addLast(c)
            }
            ')' -> {
                while (stack.peekLast() != '(') {
                    bufferWriter.append(stack.pollLast())
                }
                stack.pollLast()
            }
            '*', '/' -> {
                while (stack.isNotEmpty() && stack.peekLast() != '(' && stack.peekLast() != '+' && stack.peekLast() != '-') {
                    bufferWriter.append(stack.pollLast())
                }
                stack.addLast(c)
            }
            '+', '-'  -> {
                while (stack.isNotEmpty() && stack.peekLast() != '(') {
                    bufferWriter.append(stack.pollLast())
                }
                stack.addLast(c)
            }
            else -> {
                bufferWriter.append(c)
            }
        }
    }
    while (stack.isNotEmpty()) {
        bufferWriter.append(stack.pollLast())
    }
    bufferWriter.flush()
    bufferWriter.close()
}

// (A+(B*C))-(D/E)
// ABC*+DE/-

// A+(B-C+D)-E/F
//

// A*B+C
// AB*C+

// A+B*C
// ABC*+

// (A*B)+C
// AB*C+

// A+B-C
// AB+C-

// A+(B-C)
// ABC-+

// A*B/C
// AB*C/

// A*(B/C)
// ABC/*