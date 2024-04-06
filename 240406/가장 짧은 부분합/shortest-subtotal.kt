import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val s = sc.nextInt()
val arr = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        arr[i] = sc.nextInt()
    }

    var answer = n
    var j = 0
    var sum = arr[0]

    for (i in 0..n-1) {
        while (j + 1 < n && sum < s) {
            sum += arr[j + 1]
            j++
        }

        if (sum < s) {
            break
        }

        answer = Math.min(answer, j - i + 1)

        sum -= arr[i]
    }

    when (answer) {
        n -> print(-1)
        else -> print(answer)
    }
}