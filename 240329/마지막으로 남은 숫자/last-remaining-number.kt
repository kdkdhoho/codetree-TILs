import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val pq: PriorityQueue<Int> = PriorityQueue(reverseOrder())

fun main() {
    for (i in 1..n) {
        pq.add(sc.nextInt())
    }

    while (pq.count() >= 2) {
        val num1 = pq.poll()
        val num2 = pq.poll()

        val diff = Math.abs(num1 - num2)

        when {
            diff != 0 -> pq.add(diff)
            else -> { }
        }
    }

    print(pq.poll())
}