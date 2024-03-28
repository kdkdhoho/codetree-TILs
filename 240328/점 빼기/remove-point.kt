import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()

fun main() {
    val points: TreeSet<Point> = TreeSet()
    for (i in 1..n) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        points.add(Point(x, y))
    }

    val answer = StringBuilder()
    for (i in 1..m) {
        val k = sc.nextInt()
        val result = points.ceiling(Point(k, k)) ?: Point(-1, -1)
        answer.append("${result.x} ${result.y}\n")

        if (result != Point(-1, -1)) {
            points.remove(result)
        }
    }
    print(answer)
}

data class Point(
    val x: Int,
    val y: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int {
        if (this.x != o.x) {
            return this.x - o.x
        }
        return this.y - o.y
    }
}