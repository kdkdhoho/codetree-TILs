import kotlin.math.min

val ns = readLine()!!.trim().split(" ").map { it.toInt() }
val n = ns[0]
val s = ns[1]
val arr = readLine()!!.trim().split(" ").map { it.toInt() }

fun main() {
    var i = 0
    var j = 0
    var sum = arr[0]
    var answer = Int.MAX_VALUE

    while (i < n) {
        if (sum < s) {
            j++
            if (j >= n) break
            sum += arr[j]
        } else {
            answer = min(answer, (j - i + 1))
            sum -= arr[i]
            i++
        }
    }

    if (answer == Int.MAX_VALUE) {
        print(-1)
    } else {
        print(answer)
    }
}