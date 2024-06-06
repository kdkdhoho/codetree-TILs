import kotlin.math.max

val n = readLine()!!.toInt()
val arr = readLine()!!.trim().split(" ").map { it.toInt() }

/**
1 2 3
i
    j

0 0 0
1 2 3

answer = 2
*/
fun main() {
    var answer = Int.MIN_VALUE
    var i = 0
    var j = 0
    val cnt = IntArray(100_000 + 1)
    cnt[arr[0]]++

    while (i < n) {
        if (cnt[arr[j]] > 1) {
            answer = max(answer, (j - i))
            cnt[arr[i]]--
            i++
        } else {
            j++
            if (j >= n) break
            cnt[arr[j]]++
        }
    }

    if (answer == Int.MIN_VALUE) {
        answer = n
    }
    print(answer)
}