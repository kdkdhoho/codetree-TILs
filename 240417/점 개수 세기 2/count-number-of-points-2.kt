import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val reader = BufferedReader(InputStreamReader(System.`in`))

val input1 = reader.readLine().split(" ")
val n = input1[0].toInt()
val q = input1[1].toInt()
val treeSet = TreeSet<Point>()
val answer = StringBuilder()

fun main() {
    for (i in 1..n) {
        val input2 = reader.readLine().split(" ")
        val point = Point(input2[0].toInt(), input2[1].toInt())
        treeSet.add(point)
    }

    for (i in 1..q) { // O(Q)
        val input3 = reader.readLine().split(" ")
        val x1 = input3[0].toInt()
        val y1 = input3[1].toInt()
        val x2 = input3[2].toInt()
        val y2 = input3[3].toInt()
        val p1 = Point(x1, y1)
        val p2 = Point(x2, y2)

        val startPoint: Point? = treeSet.ceiling(p1) // O(logN)
        val endPoint: Point? = treeSet.floor(p2) // O(logN)

        when {
            startPoint == null || endPoint == null -> answer.append(0).append("\n")
            startPoint.x > endPoint.x -> answer.append(0).append("\n")

            else -> {
                var count = 0
                var currentPoint: Point = startPoint
                while (currentPoint != endPoint) { // O(N)
                    if (currentPoint.y in y1..y2) {
                        count++
                    }
                    currentPoint = treeSet.higher(currentPoint) ?: break // O(logN)
                }

                if (currentPoint != null && y1 <= currentPoint.y && currentPoint.y <= y2) {
                    count++
                }
                answer.append(count).append("\n")
            }
        }
    }

    print(answer)
}

data class Point(
    val x: Int,
    val y: Int
) : Comparable<Point> {
    override fun compareTo(o: Point): Int {
        if (this.x == o.x) {
            return this.y - o.y
        }
        return this.x - o.x
    }
}