import java.util.*

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
    var overlapCount = 0
    for ((x, weight) in treeMap) {
        if (weight == 1 && overlapCount == 0) {
            answer++
        }

        overlapCount += weight
    }

    print(answer)
}