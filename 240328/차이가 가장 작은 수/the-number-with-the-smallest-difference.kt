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
        val x = nums[i]

        val x1 = treeSet.ceiling(x + m) ?: null
        val x2 = treeSet.floor(x - m) ?: null

        if (x1 != null && x2 != null) {
            val gap1 = Math.abs(x1 - x)
            val gap2 = Math.abs(x2 - x)
            val result = Math.min(gap1, gap2)
            answer = Math.min(answer, result)
        } else if (x1 != null && x2 == null) {
            val gap = Math.abs(x1!! - x)
            answer = Math.min(answer, gap)
        } else if (x1 == null && x2 != null) {
            val gap = Math.abs(x2!! - x)
            answer = Math.min(answer, gap)
        } else {
            
        }
    }

    if (answer == Int.MAX_VALUE) {
        print(-1)
    } else {
        print(answer)
    }
}