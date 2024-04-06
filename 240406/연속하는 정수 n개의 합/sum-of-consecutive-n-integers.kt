import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()
val arr = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    var j = 0
    var sum = 0
    var answer = 0
    for (i in 1..n) {
        while (j < n && sum < m) {
            sum += arr[j + 1]
            j++
        }

        if (j > n) {
            break
        }

        if (sum == m) {
            answer++
        }

        sum -= arr[i]
    }

    print(answer)
}