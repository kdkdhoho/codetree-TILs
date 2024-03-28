import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()
val nums = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        nums[i] = sc.nextInt()
    }
    
    val treeSet: TreeSet<Int> = TreeSet()

    for (i in 0..n-1) {
        treeSet.add(nums[i])
    }

    var answer = Int.MAX_VALUE
    for (i in 0..n-1) {
        val num = nums[i]
        val target = num + m
        val result = treeSet.ceiling(target) ?: continue
        val diff = result - num
        answer = Math.min(answer, diff)
    }
    print(answer)
}