import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val q = sc.nextInt()

val count = IntArray(1_000_001)
val points = hashSetOf<Int>()

fun main() {
    for (i in 1..n) {
        points.add(sc.nextInt())
    }

    if (points.contains(0)) {
        count[0] = 1
    } else {
        count[0] = 0
    }
    for (i in 1..count.size-1) {
        count[i] = count[i - 1]
        if (points.contains(i)) {
            count[i]++
        }
    }

    val answer = StringBuilder()
    for (i in 1..q) {
        val s = sc.nextInt()
        val e = sc.nextInt()

        val cnt = count[e] - count[s - 1]
        answer.append(cnt).append("\n")
    }
    print(answer)
}