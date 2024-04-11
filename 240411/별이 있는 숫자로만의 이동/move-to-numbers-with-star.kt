import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val arr = Array(n + 1) { IntArray(n + 1) }
val prefix = Array(n + 1) { IntArray(n + 1) }

fun main() {
    for (i in 1..n) {
        for (j in 1..n) {
            arr[i][j] = sc.nextInt()
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j]
        }
    }

    var answer = 0
    for (r in 1..n) {
        for (c in 1..n) {
            val sum = getTotalSum(r, c)
            answer = Math.max(answer, sum)        
        }
    }
    print(answer)
}

fun getTotalSum(r: Int, c: Int): Int {
    var result = getSum(r-k, c-k, r+k, c+k)
    for (i in 0..k-1) {
        result -= getSum(r+k-i, c+1+i, r+k-i, c+k)
        result -= getSum(r+1+i, c-k, r+1+i, c-k+i)
        result -= getSum(r-1-i, c-k, r-1-i, c-k+i)
        result -= getSum(r-k+i, c+1+i, r-k+i, c+k)
    }
    return result
}

fun getSum(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    if (!inArray(r1, c1) || !inArray(r2, c2)) {
        return 0
    }
    return prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1]
}

fun inArray(i: Int, j: Int): Boolean {
    return i > 0 && i <= n && j > 0 && j <= n
}