import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val b = sc.nextInt()
val emptyNumber = hashSetOf<Int>()
val count = IntArray(n + 1)

fun main() {
    for (i in 1..b) {
        emptyNumber.add(sc.nextInt())
    }

    for (i in 1..k) { // O(K)
        when (emptyNumber.contains(i)) {
            true -> count[i] = count[i - 1] + 1
            else -> count[i] = count[i - 1]
        }
    }

    for (i in k+1..n) { // O(K)
        val s = i - k + 1

        count[i] = count[i - 1]
        
        if (emptyNumber.contains(s - 1)) {
            count[i]--
        }
        if (emptyNumber.contains(i)) {
            count[i]++
        }
    }

    var answer = Int.MAX_VALUE
    for (i in 1..n) {
        answer = Math.min(answer, count[i])
    }
    print(answer)
}