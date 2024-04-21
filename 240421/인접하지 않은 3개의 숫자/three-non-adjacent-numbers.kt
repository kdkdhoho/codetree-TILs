import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }

    if (n == 5) {
        print(nums[0] + nums[2] + nums[4])
        return
    }

    var lastIndex = -1
    val dp = IntArray(n)
    dp[0] = nums[0]
    lastIndex = 0

    if (nums[0] > nums[1]) {
        dp[1] = nums[0]
    } else {
        lastIndex = 1
        dp[1] = nums[1]
    }

    for (i in 2..n-1) {
        if (lastIndex == i - 1) {
            if (dp[i - 1] < dp[i - 2] + nums[i]) {
                dp[i] = dp[i - 2] + nums[i]
                lastIndex = i
            } else if (dp[i - 1] >= dp[i - 2] + nums[i]) {
                dp[i] = dp[i - 1]
            }
        } else {
            if (dp[i - 2] + nums[i] < dp[i - 1] + nums[i]) {
                dp[i] = dp[i - 1] + nums[i]
                lastIndex = i
            } else {
                dp[i] = dp[i - 2] + nums[i]
                lastIndex = i
            }
        }
    }

    var answer = 0
    for (i in 0..n-1) {
        answer = Math.max(answer, dp[i])
    }
    print(answer)
}