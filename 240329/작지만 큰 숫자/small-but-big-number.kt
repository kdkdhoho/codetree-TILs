import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()

fun main() {
    val numbers: TreeSet<Int> = TreeSet()

    for (i in 1..n) {
        numbers.add(sc.nextInt())
    }

    val answer = StringBuilder()
    for (i in 1..m) {
        val number = sc.nextInt()
        val result = numbers.floor(number)

        when {
            result == null -> answer.append(-1)
            else -> {
                answer.append(result)
                numbers.remove(result)
            }
        }

        answer.append("\n")
    }

    print(answer)
}