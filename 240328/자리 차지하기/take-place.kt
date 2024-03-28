import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()

fun main() {
    val seats: TreeSet<Int> = TreeSet()
    for (seat in 1..m) {
        seats.add(seat)
    }

    var count = 0
    for (i in 1..n) {
        val x = sc.nextInt()

        if (seats.floor(x) == null) {
            break
        }
        count++
        seats.remove(seats.floor(x))
    }
    print(count)
}