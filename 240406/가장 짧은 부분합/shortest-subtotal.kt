import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val s = sc.nextInt()
val arr = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    var answer = n
    var j = 0
    var sum = 0

    for (i in 1..n) {
        while (j + 1 <= n && sum < s) {
            sum += arr[j + 1]
            j++
        }

        if (sum < s) {
            break
        }

        answer = Math.min(answer, j - i + 1)

        sum -= arr[i]
    }

    print(answer)
}