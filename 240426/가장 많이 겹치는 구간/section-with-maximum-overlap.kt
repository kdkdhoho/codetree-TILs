import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val weights = IntArray(200001)

fun main() {
    for (i in 1..n) {
        val x1 = sc.nextInt()
        val x2 = sc.nextInt()

        weights[x1]++
        weights[x2]--
    }

    var answer = 0
    var sum = 0
    for (i in 1..weights.size-1) {
        sum += weights[i]
        answer = max(answer, sum)
    }
    
    print(answer)
}