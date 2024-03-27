import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val m = sc.nextInt()

    val treeSet: TreeSet<Int> = TreeSet()
    for (i in 1..n) {
        treeSet.add(sc.nextInt())
    }

    val answer = StringBuilder()
    for (i in 1..m) {
        val number = sc.nextInt()
        answer.append(treeSet.ceiling(number) ?: -1).append("\n")
    }
    print(answer)
}