import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val m = sc.nextInt()
    
    val targets: TreeSet<Int> = TreeSet()

    for (i in 1..m) {
        val target = sc.nextInt()
        targets.add(target)

        var max = 0
        var x = 0
        while (x < n) {
            val nextX = targets.higher(x) ?: n

            var diff = 0
            if (x == 0 || nextX == n) {
                diff = nextX - x
            } else {
                diff = nextX - x - 1
            }

            max = Math.max(max, diff)
            
            x = nextX
        }

        println(max)
    }
}