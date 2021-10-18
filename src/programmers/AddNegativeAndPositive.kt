package programmers

fun main() {
    val answer = solution(intArrayOf(4,7,12), booleanArrayOf(true, false, true))
    print(answer)
}

fun solution(absolutes: IntArray, signs: BooleanArray): Int {
    var answer = 0
    for (i in absolutes.indices) {
        if (signs[i]) {
            answer += absolutes[i]
        } else {
            answer -= absolutes[i]
        }
    }
    return answer
}

