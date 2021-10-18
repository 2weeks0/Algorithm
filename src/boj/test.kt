package boj_test

fun main() {
    val array = arrayOf(1, 3, 6, 9, 5, 4, 2, 8, 7, 10)
//    array.bubbleSort()
//    array.selectSort()
//    array.insertSort()
//    array.quickSort()
    array.mergeSort()
    array.print()
}

fun Array<Int>.print() {
    forEach {
        print("$it ")
    }
}

fun Array<Int>.bubbleSort() {
    if (size == 1) {
        return
    }

    for (i in lastIndex downTo 1) {
        for (j in 0 until i) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

fun Array<Int>.selectSort() {
    for (i in lastIndex downTo 1) {
        var maxIndex = 0
        for (j in 0..i) {
            if (this[maxIndex] < this[j]) {
                maxIndex = j
            }
        }
        val temp = this[i]
        this[i] = this[maxIndex]
        this[maxIndex] = temp
    }
}

fun Array<Int>.insertSort() {
    for (i in indices) {
        var idx = i
        while (0 < idx && this[idx - 1] > this[idx]) {
            val temp = this[idx - 1]
            this[idx - 1] = this[idx]
            this[idx] = temp
            idx--
        }
    }
}

fun Array<Int>.quickSort(left: Int = 0, right: Int = lastIndex) {
    if (left >= right) {
        return
    }

    var l = left
    for (i in left until right) {
        if (this[i] < this[right]) {
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

fun Array<Int>.mergeSort(left: Int = 0, right: Int = lastIndex) {
    if (left >= right) {
        return
    }

    val mid = (left + right) / 2
    mergeSort(left, mid)
    mergeSort(mid + 1, right)

    var l = 0
    var r = 1
    val result = Array(right - left + 1) {
        if (right < mid + r) {
            this[left + l++]
        } else if (mid < left + l) {
            this[mid + r++]
        }
        else if (this[left + l] < this[mid + r]) {
            this[left + l++]
        } else {
            this[mid + r++]
        }
    }
    for (i in result.indices) {
        this[left + i] = result[i]
    }
}
