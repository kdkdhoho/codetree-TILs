import java.util.*
import kotlin.math.max

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val points = mutableListOf<Point>()
    for (i in 1..n) {
        val s = sc.nextInt()
        val e = sc.nextInt()
        points.add(Point(s, +1))
        points.add(Point(e, -1))
    }
    points.sort()

    var maxOverlap = 0
    var overlap = 0
    for (point in points) {
        overlap += point.w
        maxOverlap = max(maxOverlap, overlap)
    }
    
    print(maxOverlap)
}

data class Point(
    val x: Int,
    val w: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int {
        if (this.x == o.x) {
            return o.w - this.w
        }
        return this.x - o.x
    }
}