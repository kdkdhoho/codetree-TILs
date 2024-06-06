import kotlin.math.min

/**
5 1 3 5 10 7 4 9 2 8
  i
        j

sum = 19
s = 15
answer = Int.MAX_VALUE
*/
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
        }

        if (sum >= s) {
            answer = min(answer,(j - i + 1))
            sum -= arr[i]
            i++
        }
    }

    print(answer)
}