val nk = readLine()!!.trim().split(" ").map { it.toInt() }
val n = nk[0]
val k = nk[1]
val arr = IntArray(n) { readLine()!!.toInt() }.sortedArray()
var answer = 0

fun main() {
    for (i in 0..n - 1) {
        for (j in i + 1..n - 1) {
            if (arr[i] + arr[j] > k) {
                break
            }

            if (arr[i] + arr[j] <= k) {
                answer++
            }
        }
    }

    print(answer)
}