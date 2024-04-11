import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val q = sc.nextInt()
val arr = IntArray(n + 1)
val prefix = Array(n + 1) { IntArray(3) }

fun main() {
    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    prefix[0] = IntArray(3)
    for (i in 1..n) {
        val count = IntArray(3)
        val before = prefix[i-1]
        for (j in 0..2) {
            count[j] = before[j]
        }
        
        when (arr[i]) {
            1 -> count[0]++
            2 -> count[1]++
            3 -> count[2]++
            else -> { }
        }

        prefix[i] = count
    }

    val answer = StringBuilder()
    for (i in 1..q) {
        val s = sc.nextInt()
        val e = sc.nextInt()

        val count = getCount(s, e)
        for (j in 0..2) {
            answer.append(count[j]).append(" ")
        }
        answer.append("\n")
    }
    print(answer)
}

fun getCount(s: Int, e: Int): IntArray {
    val end = prefix[e]
    val start = prefix[s - 1]

    val result = IntArray(3)
    for (i in 0..2) {
        result[i] = end[i] - start[i]
    }
    return result
}