import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val points = mutableListOf<Point>()
    for (i in 1..n) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        points.add(Point(a, +1))
        points.add(Point(b,-1))
    }
    points.sort()

    var answer = 0
    var sum = 0
    var startX = 0
    for (point in points) {
        sum += point.weight

        if (point.weight == 1 && sum == 1) {
            startX = point.x
        }
        if (point.weight == -1 && sum == 0) {
            val length = point.x - startX
            answer = max(answer, length)
        }
    }

    print(answer)
}

data class Point(
    val x: Int,
    val weight: Int
): Comparable<Point> {

    override fun compareTo(o: Point) = this.x - o.x
}