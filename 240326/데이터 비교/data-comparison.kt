import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val set: HashSet<Int> = HashSet()
    for (i in 1..n) {
        set.add(sc.nextInt());
    }

    val m = sc.nextInt()
    val answer = StringBuilder()
    for (i in 1..m) {
        val number = sc.nextInt()
        if (number in set) {
            answer.append("1 ")
        } else {
            answer.append("0 ")
        }
    }

    print(answer)
}