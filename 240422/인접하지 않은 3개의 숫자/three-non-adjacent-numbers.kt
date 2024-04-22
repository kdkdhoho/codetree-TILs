import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val nums = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        nums[i] = sc.nextInt()
    }
    
    if (n == 5) {
        print(nums[0] + nums[2] + nums[4])
        return
    }

    val dp = Array(n) { PriorityQueue<Int>() }
    dp[0].add(nums[0])
    dp[1].add(nums[1])
    dp[2].add(nums[0])
    dp[2].add(nums[2])

    // println(dp.contentToString())

    for (i in 3..n-1) {
        val caseA = PriorityQueue(dp[i - 3])
        val caseB = PriorityQueue(dp[i - 2])
        val caseC = PriorityQueue(dp[i - 1])
        caseA.add(nums[i])
        caseB.add(nums[i])

        val sumOfCaseA = getSum(caseA)
        val sumOfCaseB = getSum(caseB)
        val sumOfCaseC = getSum(caseC)

        val maxSum = Math.max(sumOfCaseA, Math.max(sumOfCaseB, sumOfCaseC))

        // println("caseA=$caseA caseB=$caseB caseC=$caseC")
        // println("sumOfCaseA=$sumOfCaseA sumOfCaseB=$sumOfCaseB sumOfCaseC=$sumOfCaseC")
        // println("maxSum=$maxSum")

        when (maxSum) {
            sumOfCaseC -> dp[i] = caseC
            sumOfCaseB -> dp[i] = caseB
            sumOfCaseA -> dp[i] = caseA
            else -> { }
        }
        // println(dp.contentToString())
    }

    var answer = 0
    for (i in 0..n-1) {
        val treeSet = dp[i]
        if (treeSet.size == 3) {
            val sum = getSum(treeSet)
            answer = Math.max(answer, sum)
        }
    }
    print(answer)
}

fun getSum(pq: PriorityQueue<Int>): Int {
    var result = 0
    for (num in pq) {
        result += num
    }
    return result
}