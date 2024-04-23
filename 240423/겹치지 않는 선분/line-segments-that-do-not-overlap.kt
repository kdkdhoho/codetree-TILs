import java.util.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val pq = PriorityQueue<Point>()

    for (i in 1..n) {
        pq.add(Point(sc.nextInt(), sc.nextInt()))
    }

    // println(pq)

    var answer = 1
    var beforePoint = pq.poll()
    var isFirstCollision = false

    while (!pq.isEmpty()) {
        val point = pq.poll()
        
        // println("beforePoint=$beforePoint")
        // println("point=$point")
        
        if (beforePoint.isCollision(point)) {
            // println("Collision !! ")
            if (!isFirstCollision) {
                // println("첫 번째 충돌")
                answer -= 1
            } else {
                // println("첫 번째 충돌 아님")
                // Nothing
            }
            isFirstCollision = false
        } else {
            answer += 1
        }

        // println("answer=$answer")

        if (point.x2 > beforePoint.x2) {
            // println("point.x2 > beforePoint.x2")
            beforePoint = point
            isFirstCollision = false
        }
    }

    print(answer)
}

data class Point(
    val x1: Int,
    val x2: Int
): Comparable<Point> {
    
    fun isCollision(o: Point): Boolean {
        if (o.x1 < this.x1 && o.x2 >= this.x2) {
            return true
        }
        if (this.x1 == o.x1 || this.x2 == o.x2) {
            return true
        }
        if (o.x1 > this.x1 && o.x2 <= this.x2) {
            return true
        }
        return false
    }

    override fun compareTo(o: Point): Int {
        if (this.x1 == o.x1) {
            return this.x2 - o.x2
        }
        return this.x1 - o.x1
    }
}