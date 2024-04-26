import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val dd = sc.nextLine().split(" ")
    val n = dd[0].toInt()
    val k = dd[1].toInt()
    val points = mutableListOf<Point>()

    var startX = 0
    for (i in 1..n) {
        val d = sc.nextLine().split(" ")
        val distance = d[0].toInt()
        val direction = d[1]

        when (direction) {
            "L" -> {
                val a = startX - distance
                val b = startX
                points.add(Point(a, +1))
                points.add(Point(b, -1))

                startX = a
            }
            else -> {
                val a = startX
                val b = startX + distance
                points.add(Point(a, +1))
                points.add(Point(b, -1))

                startX = b
            }
        }
    }
    points.sort()

    var answer = 0
    var sum = 0
    var overlapStartX = 0
    for (point in points) {
        val x = point.x
        val weight = point.weight

        sum += weight

        when (weight) {
            +1 -> {
                if (sum == k) {
                    overlapStartX = x
                }
            }
            else -> {
                if (sum == k - 1) {
                    val length = x - overlapStartX
                    answer += length
                }
            }
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