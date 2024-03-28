import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val treeSet: TreeSet<Int> = TreeSet()

fun main() {
    treeSet.add(0)

    var answer = Int.MAX_VALUE
    for (i in 1..n) {
        val num = sc.nextInt()
        treeSet.add(num)

        val lower = treeSet.lower(num) ?: num
        val higher = treeSet.higher(num) ?: num

        if (lower == num) {
            val distance = higher - num
            answer = Math.min(distance, answer)
        } else if (higher == num) {
            val distance = num - lower
            answer = Math.min(distance, answer)
        } else {
            val dist1 = num - lower
            val dist2 = higher - num
            val result = Math.min(dist1, dist2)
            answer = Math.min(result, answer)
        }
        println(answer)
    }
}