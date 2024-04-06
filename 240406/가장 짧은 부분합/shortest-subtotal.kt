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
            sum -= arr[i]
            i++
        }

        var length = 0
        if (i == j) {
            if (arr[i] == s) {
                length = 1
            } else {
                length = 2
            }
        } else {
            length = j - i + 1
        }
        answer = Math.min(answer, length)
        
        j++
    }

    when (answer) {
        n -> print(-1)
        else -> print(answer)
    }
}