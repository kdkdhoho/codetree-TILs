import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val map: TreeMap<Int, Int> = TreeMap()
    for (i in 1..n) {
        val number = sc.nextInt()
        when {
            number !in map -> map[number] = i
            else -> {}
        }
    }

    val answer: StringBuilder = StringBuilder()
    for ((number, index) in map) {
        answer.append("$number $index\n")
    }
    print(answer)
}