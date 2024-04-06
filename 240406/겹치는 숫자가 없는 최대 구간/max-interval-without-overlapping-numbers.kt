import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val arr = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    val set = hashSetOf<Int>()
    var answer = 0
    var j = 0
    for (i in 1..n) {
        while (j + 1 <= n && !set.contains(arr[j + 1])) {
            j++
            set.add(arr[j])
        }

        answer = Math.max(answer, j - i + 1)

        set.remove(arr[i])
    }

    print(answer)
}