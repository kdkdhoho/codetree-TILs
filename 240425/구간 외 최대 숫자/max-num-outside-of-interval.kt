import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input1 = br.readLine().split(" ")
    val n = input1[0].toInt()
    val q = input1[1].toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }

    val L = IntArray(n)
    L[0] = nums[0]
    for (i in 1..n-1) {
        L[i] = max(L[i - 1], nums[i])
    }

    val R = IntArray(n)
    R[n - 1] = nums[n - 1]
    for (i in n-2 downTo 0) {
        R[i] = max(R[i + 1], nums[i])
    }

    val answer = StringBuilder()
    for (i in 1..q) {
        val input2 = br.readLine().split(" ")
        val a = input2[0].toInt() - 1
        val b = input2[1].toInt() - 1

        when (b) {
            n-1 -> answer.append(L[a - 1])
            else -> answer.append(max(L[a - 1], R[b + 1]))
        }
        answer.append("\n")
    }

    print(answer)
}