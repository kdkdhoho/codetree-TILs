val nk = readLine()!!.trim().split(" ").map { it.toInt() }
val n = nk[0]
val k = nk[1]
val arr = IntArray(n) { readLine()!!.toInt() }.sortedArray()

fun main() {
    var i = 0
    var j = 1
    var sum = arr[i] + arr[j]
    var answer = 0

    while (i < n) {
        if (sum <= k) {
            if (i == j) {
                j++
                if (j >= n) {
                    break
                }
                sum += arr[j]
            }

            answer++
            sum -= arr[j]
            j++
            if (j >= n) {
                break
            }
            sum += arr[j]
        } else {
            sum -= arr[i]
            i++
            if (i >= n) {
                break
            }
            sum += arr[i]
        }
    }

    print(answer)
}