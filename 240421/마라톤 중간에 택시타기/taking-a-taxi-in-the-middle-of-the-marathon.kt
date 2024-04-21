import java.util.*
import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))

val n = br.readLine().toInt()
val points = arrayOfNulls<Point>(n)

fun main() {
    for (i in 0..n-1) {
        val split = br.readLine().split(" ")
        val point = Point(split[0].toInt(), split[1].toInt())
        points[i] = point
    }

    val L = IntArray(n)
    for (i in 1..n-1) {
        L[i] = L[i - 1] + points[i]!!.distanceWith(points[i - 1]!!)
    }

    val R = IntArray(n)
    for (i in n-2 downTo 0) {
        R[i] = R[i + 1] + points[i]!!.distanceWith(points[i + 1]!!)
    }

    var answer = Int.MAX_VALUE
    for (i in 1..n-2) {
        val distance = points[i-1]!!.distanceWith(points[i+1]!!) + L[i-1] + R[i+1]
        answer = Math.min(answer, distance)
    }
    print(answer)
}

data class Point(
    val x: Int,
    val y: Int
) {

    fun distanceWith(o: Point): Int {
        return Math.abs(this.x - o.x) + Math.abs(this.y - o.y)
    }
}