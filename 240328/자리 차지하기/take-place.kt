import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()

fun main() {
    val seats: TreeSet<Int> = TreeSet()
    for (seat in 1..m) {
        seats.add(seat)
    }

    val xs = IntArray(n)
    for (i in 0..n-1) {
        xs[i] = sc.nextInt()
    }

    xs.sort()

    var count = 0
    for (x in xs) {
        if (seats.floor(x) == null) {
            continue
        }

        count++
        seats.remove(seats.floor(x))
    }
    print(count)
}