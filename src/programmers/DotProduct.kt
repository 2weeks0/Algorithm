package programmers

fun main() {

}

fun solution(a: IntArray, b: IntArray): Int {
    return a.mapIndexed { index, value ->
        value * b[index]
    }
        .sum()
}