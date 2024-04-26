import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val treeMap = TreeMap<Int, Int>()
    for (i in 1..n) {
        val a = sc.nextInt()
        val b = sc.nextInt()

        treeMap.put(a, 1)
        treeMap.put(b, -1)
    }

    var answer = 0
    var sum = 0
    for ((x, weight) in treeMap) {
        sum += weight
        answer = max(answer, sum)
    }

    print(answer)
}