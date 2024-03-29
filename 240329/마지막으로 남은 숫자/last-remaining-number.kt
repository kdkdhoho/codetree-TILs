import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val pq: PriorityQueue<Int> = PriorityQueue(reverseOrder())

fun main() {
    for (i in 1..n) {
        pq.add(sc.nextInt())
    }

    while (pq.size >= 2) {
        val num1 = pq.poll()
        val num2 = pq.poll()

        val diff = abs(num1 - num2)

        when {
            diff != 0 -> pq.add(diff)
            else -> { }
        }
    }

    if (pq.isEmpty()) {
        print(-1)
    } else {
        print(pq.poll())
    }
}