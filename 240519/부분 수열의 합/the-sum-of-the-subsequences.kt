import kotlin.math.max

val nm = readLine()!!.trim().split(" ").map { it.toInt() }
val n = nm[0]
val m = nm[1]
val arr = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
val dp = Array(n) { IntArray(10_000) { -1 } }

fun main() {
    if (recursive(0, 0) > 0) {
        print("Yes")
    } else {
        print("No")
    }
}

fun recursive(
    i: Int,
    sum: Int
): Int {
    if (i == n) {
        if (sum == m) {
            return 0
        }
        return (-1e9).toInt()
    }
    if (dp[i][sum] != -1) {
        return dp[i][sum]
    }

    var result = (-1e9).toInt()
    if (sum + arr[i] <= m) {
        result = max(result, recursive(i + 1, sum + arr[i]) + 1)
    }
    result = max(result, recursive(i + 1, sum) + 1)
    dp[i][sum] = result
    return result
}