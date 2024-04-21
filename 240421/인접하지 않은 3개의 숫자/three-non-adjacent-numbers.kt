import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val nums = IntArray(n)
    for (i in 0..n - 1) {
        nums[i] = sc.nextInt()
    }

    if (n == 5) {
        print(nums[0] + nums[2] + nums[4])
        return
    }

    val dp = Array(n) { TreeSet<Int>() }
    dp[0].add(nums[0])
    dp[1].add(nums[1])
    dp[2].add(nums[0])
    dp[2].add(nums[2])

    for (i in 3..n - 1) { // O(N)
        val case1 = TreeSet(dp[i - 1])
        val case2 = TreeSet(dp[i - 2])
        val case3 = TreeSet(dp[i - 3])

        if (dp[i - 2].size < 3) {
            case2.add(nums[i])
        } else {
            if (dp[i - 2].first() < nums[i]) {
                case2.pollFirst()
                case2.add(nums[i])
            }
        }

        if (dp[i - 3].size < 3) {
            case3.add(nums[i])
        } else {
            if (dp[i - 3].first() < nums[i]) {
                case3.pollFirst()
                case3.add(nums[i])
            }
        }

        val a = getSum(case1)
        val b = getSum(case2)
        val c = getSum(case3)
        val max = Math.max(a, Math.max(b, c))

        when (max) {
            getSum(case1) -> dp[i] = case1
            getSum(case2) -> dp[i] = case2
            getSum(case3) -> dp[i] = case3
            else -> {}
        }
    }

    var answer = 0
    for (i in 0..n - 1) {
        if (dp[i].size == 3) {
            val sum = getSum(dp[i])
            answer = Math.max(answer, sum)
        }
    }
    print(answer)
}

fun getSum(treeSet: TreeSet<Int>): Int {
    var result = 0
    for (num in treeSet) {
        result += num
    }
    return result
}