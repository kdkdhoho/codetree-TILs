import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val points = mutableListOf<Point>()

    if (n == 1) {
        print(1)
        return
    }

    for (i in 1..n) {
        points.add(Point(sc.nextInt(), sc.nextInt()))
    }
    points.sort()

    val L = IntArray(n)
    L[0] = points.first().x2
    for (i in 1..points.size-1) {
        L[i] = Math.max(L[i - 1], points[i].x2)
    }

    val R = IntArray(n)
    R[n - 1] = points.last().x2
    for (i in n-2 downTo 0) {
        R[i] = Math.min(R[i + 1], points[i].x2)
    }

    var answer = 0
    for (i in 0..n-1) {
        if (L[i] == R[i]) {
            answer++
        }
    }
    print(answer)
}

data class Point(
    val x1: Int,
    val x2: Int
): Comparable<Point> {

    override fun compareTo(o: Point): Int {
        if (this.x1 == o.x1) {
            return this.x2 - o.x2
        }
        return this.x1 - o.x1
    }
}