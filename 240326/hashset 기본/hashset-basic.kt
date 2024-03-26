import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = readLine()!!.toInt()
    
    val set: HashSet<Int> = HashSet()
    val answer = StringBuilder()

    for (i in 1..n) {
        val inputs = readLine()!!.split(" ")
        val command = inputs[0]
        val x = inputs[1].toInt()

        when (command) {
            "find" -> {
                when {
                    set.contains(x) -> answer.append("true\n")
                    else -> answer.append("false\n")
                }
            }
            "add" -> set.add(x)
            else -> set.remove(x)
        }
    }
    print(answer)
}