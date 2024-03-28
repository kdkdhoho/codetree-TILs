import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextInt()

    val treeSet: TreeSet<Point> = TreeSet()

    for (i in 1..n) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        treeSet.add(Point(x, y))
    }

    for (i in 1..m) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        val point = Point(x, y)

        if (treeSet.ceiling(point) == null) {
            println("-1 -1")
        } else {
            val result = treeSet.ceiling(point)
            println("${result.x} ${result.y}")
        }
    }
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