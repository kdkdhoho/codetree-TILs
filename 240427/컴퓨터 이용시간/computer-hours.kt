import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()

    val people = arrayOfNulls<Person>(n + 1)
    val points = mutableListOf<Point>()

    for (i in 1..n) {
        val startTime = sc.nextInt()
        val endTime = sc.nextInt()
        people[i] = Person(i, startTime, endTime)

        points.add(Point(i, startTime, +1))
        points.add(Point(i, endTime, -1))
    } // O(N)
    points.sort() // O(NlogN)

    val pq = PriorityQueue<Int>()
    for (i in 1..n) {
        pq.add(i)
    }
    val answer = IntArray(n + 1)

    for (point in points) { // O(N)
        when (point.weight) {
            +1 -> {
                val remainSeatNumber = pq.poll() // O(logN)
                answer[point.personNumber] = remainSeatNumber
            }
            -1 -> {
                val seatNumber = answer[point.personNumber]
                pq.add(seatNumber)
            }
        }
    } // O(NlogN)

    val sb = StringBuilder()
    for (i in 1..n) { // O(N)
        sb.append(answer[i]).append(" ")
    }
    print(sb)
}

data class Person(
    val number: Int,
    val startTime: Int,
    val endTime: Int
)

data class Point(
    val personNumber: Int,
    val x: Int,
    val weight: Int
): Comparable<Point> {

    override fun compareTo(o: Point) = this.x - o.x
}