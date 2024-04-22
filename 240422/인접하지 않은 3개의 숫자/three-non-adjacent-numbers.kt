import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val nums = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        nums[i] = sc.nextInt()
    }

    val L = IntArray(n)
    L[0] = nums[0]
    for (i in 1..n-1) {
        L[i] = Math.max(L[i - 1], nums[i])
    }

    val R = IntArray(n)
    R[n - 1] = nums[n - 1]
    for (i in n-2 downTo 0) {
        R[i] = Math.max(R[i + 1], nums[i])
    }

    var max = 0
    for (i in 2..n-3) {
        val value = nums[i] + L[i - 2] + R[i + 2]
        max = Math.max(max, value)
    }
    print(max)
}