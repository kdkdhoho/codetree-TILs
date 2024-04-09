import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val arr = IntArray(n + 1)
val sums = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    for (i in 1..n) {
        sums[i] = sums[i - 1] + arr[i]
    }

    var answer = 0
    for (e in 1..n) {
        for (s in 1..e) {
            val sum = sums[e] - sums[s - 1]
            
            when (sum) {
                k -> answer++
                else -> { }
            }
        }
    }

    print(answer)
}