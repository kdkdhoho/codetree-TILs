import kotlin.math.max

fun main() {
    val n_k = readLine()!!.split(" ")
    val n = n_k[0].toInt()
    val k = n_k[1].toInt()

    val arr = IntArray(n)
    for (i in 0..n-1) {
        arr[i] = readLine()!!.toInt()
    }

    val R = IntArray(n)
    val hashMap = hashMapOf<Int, Int>()
    hashMap.put(arr[n - 1], n - 1)
    for (i in n-2 downTo 0) {
        if (hashMap.containsKey(arr[i])) {
            R[i] = hashMap[arr[i]]!!
        } else {
            R[i] = -1
        }

        hashMap.put(arr[i], i)
    }

    var answer = -1
    for (i in 0..n-2) {
        if (R[i] > 0) {
            answer = max(answer, arr[i])
        }
    }
    print(answer)
}