import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val k = sc.nextInt()

    val arr = IntArray(n)
    for (i in 0..n-1) {
        arr[i] = sc.nextInt()
    }

    val hashMap = hashMapOf<Int, Int>()
    val R = IntArray(n)
    for (i in n-1 downTo 0) {
        if (hashMap.containsKey(arr[i])) {
            R[i] = hashMap[arr[i]]!!
        } else {
            R[i] = -1
        }

        hashMap.put(arr[i], i)
    }

    var answer = 0
    for (i in 0..n-1) {
        if (R[i] > 0 && abs(R[i] - i) <= k) {
            answer = max(answer, arr[i])
        }
    }
    print(answer)
}