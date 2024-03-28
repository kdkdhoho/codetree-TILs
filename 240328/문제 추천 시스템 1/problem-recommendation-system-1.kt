import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextLine().toInt()

fun main() {
    val problems: TreeSet<Problem> = TreeSet()

    for (i in 1..n) {
        val split = sc.nextLine().split(" ")
        val number = split[0].toInt()
        val diff = split[1].toInt()
        problems.add(Problem(number, diff))
    }

    val answer = StringBuilder()
    val m = sc.nextLine().toInt()
    for (i in 1..m) {
        val split = sc.nextLine().split(" ")

        when (split[0]) {
            "rc" -> when (split[1]) {
                "1" -> answer.append(problems.last().number).append("\n")
                "-1" -> answer.append(problems.first().number).append("\n")
                else -> { }
            }
            "ad" -> problems.add(Problem(split[1].toInt(), split[2].toInt()))
            "sv" -> problems.remove(Problem(split[1].toInt(), split[2].toInt()))
            else -> { }
        }
    }

    print(answer)
}

data class Problem(
    val number: Int, 
    val diff: Int
): Comparable<Problem> {

    override fun compareTo(o: Problem): Int {
        if (this.diff != o.diff) {
            return this.diff - o.diff
        }
        return this.number - o.number
    }
}