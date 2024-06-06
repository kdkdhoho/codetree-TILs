import kotlin.math.max

val n = readLine()!!.toInt()
val arr = readLine()!!.trim().split(" ").map { it.toInt() }

fun main() {
    var answer = 0
    var i = 0
    var j = 0
    val cnt = IntArray(100_000 + 1)
    cnt[arr[0]]++

    while (i < n) {
        if (cnt[arr[j]] <= 1) {
            j++
            if (j >= n) break
            cnt[arr[j]]++
        }

        if (cnt[arr[j]] >= 2) {
            answer = max(answer, (j - i))
            cnt[arr[i]]--
            i++
        }
    }

    if (answer == 0) {
        answer = n
    }
    print(answer)
}