import java.lang.Exception

fun main() {
//    val solution = solution(intArrayOf(1,2,3,4,5))
//    val solution = solution(intArrayOf(1,3,2,4,2))
//    val solution = solution(intArrayOf(4))
    val solution = solution(intArrayOf(3, 3, 1, 1, 1, 1, 2, 3, 4, 5))
//    solution.forEach { print(it) }
    print(solution.toList())
}

fun solution(answers: IntArray): IntArray {
    val answerCount = mutableListOf(0, 0, 0)

    for (i in answers.indices) {
        val answerOfCandidates = listOf(
            getAnswerOfCandidate1(i),
            getAnswerOfCandidate2(i),
            getAnswerOfCandidate3(i)
        )

        for (j in answerOfCandidates.indices) {
            if (answerOfCandidates[j] == answers[i]) {
                answerCount[j]++
            }
        }

    }
    val maxAnswerCount = answerCount.maxOrNull()
    return answerCount
        .mapIndexed { index, i ->
            if (i == maxAnswerCount) {
                index + 1
            } else {
                -1
            }
        }
        .filter { it != -1 }
        .toIntArray()
}

fun getAnswerOfCandidate1(i: Int): Int {
    return (i % 5) + 1
}

fun getAnswerOfCandidate2(i: Int): Int {
    return if (i % 2 == 0) 2
    else when (i / 2 % 4) {
        0 -> 1
        1 -> 3
        2 -> 4
        3 -> 5
        else -> throw Exception("Unknown answer($i)")
    }
}

fun getAnswerOfCandidate3(i: Int): Int {
    return when (i / 2 % 5) {
        0 -> 3
        1 -> 1
        2 -> 2
        3 -> 4
        4 -> 5
        else -> throw Exception("Unknown answer($i)")
    }
}
