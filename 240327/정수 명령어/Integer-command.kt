import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val treeSet: TreeSet<Int> = TreeSet()

    val T = sc.nextLine().toInt()
    for (t in 1..T) {
        val k = sc.nextLine().toInt()

        for (i in 1..k) {
            val split = sc.nextLine().split(" ")

            when (split[0]) {
                "I" -> treeSet.add(split[1].toInt())
                else -> when (split[1]) {
                    "1" -> when (treeSet.isEmpty()) {
                        true -> { }
                        else -> treeSet.pollLast()
                    }
                    else -> when (treeSet.isEmpty()) {
                        true -> { }
                        else -> treeSet.pollFirst()
                    }
                }
            }
        }

        when (treeSet.isEmpty()) {
            true -> println("EMPTY")
            else -> println("${treeSet.last()} ${treeSet.first()}")
        }
        treeSet.clear()
    }
}