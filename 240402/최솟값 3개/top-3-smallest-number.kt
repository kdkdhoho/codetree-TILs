import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

fun main() {
    val pq: PriorityQueue<Int> = PriorityQueue()
    val answer = StringBuilder()

    for (i in 1..n) {
        val num = sc.nextInt()
        pq.add(num)

        if (pq.size < 3) {
            answer.append(-1)
        } else {
            val minNumbers = IntArray(3)
            var result = 1

            for (j in 0..2) {
                val minNumber = pq.poll()
                result *= minNumber
                minNumbers[j] = minNumber
            }

            answer.append(result)

            for (j in 0..2) {
                val minNumber: Int = minNumbers[j]
                pq.add(minNumber)
            }
        }

        answer.append("\n")
    }

    print(answer)
}