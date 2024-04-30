import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val points = arrayOfNulls<Point>(n)
    for (i in 0..n-1) {
        val values = readLine()!!.split(" ")
        points[i] = Point(values[0].toInt(), values[1].toInt())
    }

    var answer = Int.MAX_VALUE
    for (point in points) {
        val a = point!!.x + 1
        val b = point!!.y + 1

        val count = IntArray(5)
        for (p in points) {
            val area = getArea(p, a, b)
            count[area]++
        }

        var m = 0
        for (i in 1..4) {
            m = max(m, count[i])
        }
        answer = min(answer, m)
    }

    print(answer)
}

fun getArea(point: Point?, a: Int, b: Int): Int {
    val x = point!!.x
    val y = point!!.y

    if (x > a && y > b) {
        return 1
    }
    if (x < a && y > b) {
        return 2
    }
    if (x < a && y < b) {
        return 3
    }
    if (x > a && y < b) {
        return 4
    }
    throw IllegalArgumentException()
}

data class Point(
    val x: Int,
    val y: Int
)