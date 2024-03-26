import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val set: HashSet<Int> = HashSet()

    for (i in 1..n) {
        val number = sc.nextInt()
        set.add(number)
    }

    print(set.count())
}