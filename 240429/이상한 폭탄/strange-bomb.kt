import kotlin.math.max

fun main() {
    val n_k = readLine()!!.split(" ")
    val n = n_k[0].toInt()
    val k = n_k[1].toInt()

    val arr = IntArray(n)
    for (i in 0..n-1) {
        arr[i] = readLine()!!.toInt()
    }

    val prefix = Array(n) { hashSetOf<Int>() }
    for (i in n-2 downTo 0) {
        prefix[i] = HashSet(prefix[i + 1])
        if (i < n-1-k) {
            prefix[i].remove(arr[i + k + 1])
        }
        prefix[i].add(arr[i + 1])
    }

    var answer = -1
    for (i in 0..n-1-k) {
        if (prefix[i].contains(arr[i])) {
            answer = max(answer, arr[i])
        }
    }
    print(answer)
}