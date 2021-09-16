package programmers.level1

fun solution(nums: IntArray): Int {
    var answer = 0
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                val num = nums[i] + nums[j] + nums[k]
                if (isPrime(num)) {
                    answer++
                }
            }
        }
    }
    return answer
}

fun isPrime(num: Int): Boolean {
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}