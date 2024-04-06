import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val s = sc.nextInt()
val arr = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        arr[i] = sc.nextInt()
    }

    var i = 0
    var j = 0
    var sum = 0
    var answer = n

    while (j < n) {
        sum += arr[j]

        if (sum < s) {
            j++
            continue
        }

        while (i < j && sum >= s) {
            answer = Math.min(answer, j - i + 1)
            sum -= arr[i]
            i++
        }

        if (i == j && arr[i] == s) {
            answer = Math.min(answer, 1)
        }
        j++
    }

    when (answer) {
        n -> print(-1)
        else -> print(answer)
    }
}