import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val treeSet: TreeSet<Int> = TreeSet()
    val answer = StringBuilder()

    val n = sc.nextLine().toInt()
    for (i in 1..n) {
        val split = sc.nextLine().split(" ")
        val command = split[0]

        when (command) {
            "add" -> treeSet.add(split[1].toInt())
            "remove" -> treeSet.remove(split[1].toInt())
            "find" -> answer.append(treeSet.contains(split[1].toInt())).append("\n")
            "lower_bound" -> answer.append(treeSet.ceiling(split[1].toInt()) ?: "None").append("\n")
            "upper_bound" -> answer.append(treeSet.higher(split[1].toInt()) ?: "None").append("\n")
            "largest" -> when (treeSet.isEmpty()) {
                true -> answer.append("None\n")
                else -> answer.append(treeSet.last()).append("\n")
            }
            "smallest" -> when (treeSet.isEmpty()) {
                true -> answer.append("None\n")
                else -> answer.append(treeSet.first()).append("\n")
            } 
            else -> { }
        }
    }
    print(answer)
}