package programmers.level1

fun main() {
    val testcases = listOf(
        "...!@BaT#*..y.abcdefghijklm",
        "z-+.^.",
        "=.=",
        "123_.def",
        "abcdefghijklmn.p"
    )
    testcases.forEach {
        println(solution(it))
    }
}

fun solution(new_id: String): String {
    // step 1 - 소문자로 치환
    return new_id.toLowerCase()
        // step 2 - 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제회한 문자 제거
        .replace(
            Regex("[^[a-z][0-9]\\-_.]"),
            ""
        )
        // step 3 - 연속된 마침표(.)를 하나의 마침표(.)로 치환
        .replace(
            Regex("\\.{2,}"),
            "."
        )
        // step 4 - 마침표(.)가 처음이나 끝에 위치할 경우 제거
        .trim { it == '.' }
        // step 5 - 빈 문자열이라면 a를 대입
        .let {
            it.ifEmpty { "a" }
        }
        // step 6 - 길이가 16 이상이라면 15개를 제외한 모든 문자 제거, 만약 마침표(.)가 마지막에 위치한다면 제거
        .let {
            if (it.length >= 16) {
                it.substring(
                    0,
                    15
                )
            } else {
                it
            }
        }
        .trimEnd { it == '.' }
        // step 7 - 길이가 2 이하라면 길이가 3이 될 때까지 반복에서 끝에 붙임
        .let {
            if (it.length <= 2) {
                StringBuilder(it).run {
                    while (length <= 2) {
                        append(it.last())
                    }
                    toString()
                }
            } else {
                it
            }
        }
}