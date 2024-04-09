import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val arr = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    val sums = IntArray(n + 1)
    sums[1] = arr[1]
    for(i in 2..n) {
        sums[i] = sums[i - 1] + arr[i]
    }

    var answer = 0
    for (i in k..n) {
        val s = i - k + 1
        val e = i

        val sum = sums[e] - sums[s - 1]
        answer = Math.max(answer, sum)
    }

    print(answer)
}