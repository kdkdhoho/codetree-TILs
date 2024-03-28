import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val m = sc.nextInt()
    
    val targets: TreeSet<Int> = TreeSet()

    for (i in 1..m) {
        val target = sc.nextInt()

        val bigger = targets.ceiling(target) ?: n
        val lower = targets.floor(target) ?: 0

        val diff1 = bigger - target
        val diff2 = target - lower

        val max = Math.max(diff1, diff2)
        println(max)
        
        targets.add(target)
    }
}