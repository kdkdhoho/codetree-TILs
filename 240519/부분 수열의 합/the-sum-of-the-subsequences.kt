import java.util.*
import kotlin.system.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()
var arr = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        arr[i] = sc.nextInt()
    }
    recursive(0, 0, 0)
    print("No")
}

fun recursive(
    index: Int,
    count: Int,
    sum: Int
) {
    if (index == n) {
        if (count > 0 && sum == m) {
            print("Yes")
            exitProcess(0)
        }
        return
    }

    for (i in 0..n-1) {
        recursive(index + 1, count + 1, sum + arr[i])
        recursive(index + 1, count, sum)
    }
}