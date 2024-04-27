import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val points = mutableListOf<Point>()
    for (i in 1..n) { // O(N)
        val a = sc.nextInt()
        val b = sc.nextInt()

        points.add(Point(a, +1))
        points.add(Point(b, -1))
    }
    points.sort() // O(NlogN)

    var answer = 0
    var sum = 0
    var sectionStartX = 0
    for (point in points) {
        sum += point.weight

        if (point.weight == 1 && sum == 1) {
            sectionStartX = point.x
        }
        if (point.weight == -1 && sum == 0) {
            answer += (point.x - sectionStartX)
        }
    }

    print(answer)
}

data class Point(
    val x: Int,
    val weight: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int = this.x - o.x
}