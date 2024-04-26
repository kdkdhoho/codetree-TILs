import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

fun main() {
    val input1 = sc.nextLine().split(" ")
    val n = input1[0].toInt()
    val k = input1[1].toInt()
    val points = mutableListOf<Point>()

    var startX = 0
    for (i in 1..n) {
        val input = sc.nextLine().split(" ")
        val dist = input[0].toInt()
        val direction = input[1]

        var a = 0
        var b = 0
        when (direction) {
            "L" -> {
                a = startX - dist
                b = startX
                startX = a
            }
            else -> {
                a = startX
                b = startX + dist
                startX = b
            }
        }
        points.add(Point(a, +1))
        points.add(Point(b, -1))
    }
    points.sort()

    var answer = hashSetOf<Section>()
    var overlapCount = 0
    var overlapStartX = 0
    for (point in points) {
        val x = point.x
        val weight = point.weight

        when (weight) {
            -1 -> {
                if (overlapCount >= k) {
                    answer.add(Section(overlapStartX, x))
                }
            }
            +1 -> {
                overlapStartX = x
            }
            else -> { }
        }

        overlapCount += weight
    }

    var result = 0
    for (section in answer) {
        result += abs(section.a - section.b)
    }
    print(result)
}

data class Point(
    val x: Int,
    val weight: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int {
        return this.x - o.x
    }
}

data class Section(
    val a: Int,
    val b: Int
) {

}