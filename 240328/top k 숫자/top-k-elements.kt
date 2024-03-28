import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val k = sc.nextInt()
val treeSet: TreeSet<Int> = TreeSet()

fun main() {
    for (i in 1..n) {
        treeSet.add(sc.nextInt())
    }
    
    val sortedSet = treeSet.descendingSet()
    val result = sortedSet.toList()
    val answer = StringBuilder()

    for (i in 0..k-1) {
        answer.append(result[i]).append(" ")
    }
    print(answer)
}