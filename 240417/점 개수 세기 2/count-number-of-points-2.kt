import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val q = sc.nextInt()
val treeSet = TreeSet<Point>()
val answer = StringBuilder()

fun main() {
    for (i in 1..n) {
        val point = Point(sc.nextInt(), sc.nextInt())
        treeSet.add(point)
    }

    for (i in 1..q) { // O(Q)
        val x1 = sc.nextInt()
        val y1 = sc.nextInt()
        val x2 = sc.nextInt()
        val y2 = sc.nextInt()
        val p1 = Point(x1, y1)
        val p2 = Point(x2, y2)

        val startPoint: Point? = treeSet.ceiling(p1) // O(logN)
        val endPoint: Point? = treeSet.floor(p2) // O(logN)

        when {
            startPoint == null || endPoint == null -> answer.append(0).append("\n")

            else -> {
                var count = 0
                var currentPoint: Point = startPoint
                while (currentPoint != endPoint) { // O(N)
                    if (y1 <= currentPoint.y && currentPoint.y <= y2) {
                        count++
                    }
                    currentPoint = treeSet.higher(currentPoint) ?: break
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
): Comparable<Point> {
    
    override fun compareTo(o: Point): Int {
        if (this.x == o.x) {
            return this.y - o.y
        }
        return this.x - o.x
    }
}