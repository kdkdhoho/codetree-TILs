import kotlin.math.*

fun main() {
    val n = readLine()!!.toInt()
    val points = mutableListOf<Point>()
    for (i in 1..n) {
        val values = readLine()!!.split(" ")
        points.add(Point(values[0].toInt(), values[1].toInt()))
    }
    points.sort()

    var answer = Int.MAX_VALUE
    for (point in points) {
        val a = point.x + 1
        val b = point.y + 1

        // println("a=$a b=$b")

        val count = IntArray(5)

        for (p in points) {
            val area = getArea(p, a, b)
            count[area]++
        }

        // println(count.contentToString())

        var m = 0
        for (i in 1..4) {
            if (count[i] != 0) {
                m = max(m, count[i])
            }
        }
        answer = min(answer, m)

        // println("m=$m answer=$answer")
        // println()
    }

    print(answer)
}

fun getArea(point: Point, a: Int, b: Int): Int {
    val x = point.x
    val y = point.y

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
    return 0
}

data class Point(
    val x: Int,
    val y: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int {
        if (this.x == o.x) {
            return this.y - o.y
        }
        return this.x - o.x
    }
}