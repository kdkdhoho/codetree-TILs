import java.util.*
import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))

val n = br.readLine().toInt()
val arr = Array(n + 1) { "" }
val H = IntArray(n + 1)
val S = IntArray(n + 1)
val P = IntArray(n + 1)

fun main() {
    for (i in 1..n) {
        arr[i] = br.readLine()
    }

    for (i in 1..n) {
        val b = arr[i]
        
        H[i] = H[i - 1]
        S[i] = S[i - 1]
        P[i] = P[i - 1]

        when (b) {
            "P" -> S[i]++
            "H" -> P[i]++
            else -> H[i]++
        }
    }

    var answer = Int.MIN_VALUE
    for (i in 1..n) {
        val a = Math.max(H[i] + (H[n] - H[i]), Math.max(H[i] + (S[n] - S[i]), H[i] + (P[n] - P[i])))
        val b = Math.max(S[i] + (S[n] - S[i]), Math.max(S[i] + (H[n] - H[i]), S[i] + (P[n] - P[i])))
        val c = Math.max(P[i] + (P[n] - P[i]), Math.max(P[i] + (H[n] - H[i]), P[i] + (S[n] - S[i])))

        val max = Math.max(a, Math.max(b, c))
        answer = Math.max(answer, max)
    }

    print(answer)
}