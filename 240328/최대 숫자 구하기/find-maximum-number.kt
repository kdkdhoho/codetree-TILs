import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()

fun main() {

    val treeSet: TreeSet<Int> = TreeSet()
    for (i in 1..m) {
        treeSet.add(i)
    }
    
    for (i in 1..n) {
        val num = sc.nextInt()

        treeSet.remove(num)

        println(treeSet.last())
    }
}