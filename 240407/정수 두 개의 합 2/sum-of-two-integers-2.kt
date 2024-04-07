import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val nums = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        nums[i] = sc.nextInt()
    }

    var answer = 0
    var sum = 0
    var j = 0

    for (i in 1..n) {
        while (j + 1 <= n && sum + nums[j + 1] <= k) {
            sum += nums[j + 1]
            j++
        }

        if (i != j) {
            answer++
        }

        sum -= nums[i]
    }
    print(answer)
}