import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val s = sc.nextLine()

    val L = IntArray(n)
    if (s[0] == 'C') {
        L[0] = 1
    }
    for (i in 1..n-1) {
        L[i] = L[i - 1]
        if (s[i] == 'C') {
            L[i]++
        }
    }

    val R = IntArray(n)
    if (s[n - 1] == 'W') {
        R[n - 1] = 1
    }
    for (i in n-2 downTo 0) {
        R[i] = R[i + 1]
        if (s[i] == 'W') {
            R[i]++
        }
    }

    var answer = 0L
    for (i in 1..n-2) {
        if (s[i] == 'O') {
            answer += L[i - 1] * R[i + 1]
        }
    }
    print(answer)
}