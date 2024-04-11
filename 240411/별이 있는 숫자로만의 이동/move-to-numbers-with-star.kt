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
    val r1 = if (r-k < 1) 1 else r-k
    val c1 = if (c-k < 1) 1 else c-k
    val r2 = if (r+k > n) n else r+k
    val c2 = if (c+k > n) n else c+k
    var result = getSum(r1, c1, r2, c2)

    for (i in 0..k-1) {
        result -= getSum(r-k+i, c+1+i, r-k+i, c+k) // 1사분면
        result -= getSum(r-1-i, c-k, r-1-i, c-k+i) // 2사분면
        result -= getSum(r+1+i, c-k, r+1+i, c-k+i) // 3사분면
        result -= getSum(r+k-i, c+1+i, r+k-i, c+k) // 4사분면
    }

    return result

    // for (i in 0..k-1) { // 1사분면
    //     val startRow = r-k+i
    //     val startCol = c+1+i
    //     val endRow = r-k+i
    //     val endCol = c+k

    //     result -= getSum(startRow, startCol, endRow, endCol)

    //     if (!inArray(startRow, startCol) || !inArray(endRow, endCol)) {
    //         result -= 0
    //     } else {
    //         result -= getSum(startRow, startCol, endRow, endCol)
    //     }
    // }
    // for (i in 0..k-1) { // 2사분면
    //     val startRow = r-1-i
    //     val startCol = c-k
    //     val endRow = r-1-i
    //     val endCol = c-k+i

    //     if (!inArray(startRow, startCol) || !inArray(endRow, endCol)) {
    //         result -= 0
    //     } else {
    //         result -= getSum(startRow, startCol, endRow, endCol)
    //     }
    // }
    // for (i in 0..k-1) { // 3사분면
    //     val startRow = r+1+i
    //     val startCol = c-k
    //     val endRow = r+1+i
    //     val endCol = c-k+i

    //     if (!inArray(startRow, startCol) || !inArray(endRow, endCol)) {
    //         result -= 0
    //     } else {
    //         result -= getSum(startRow, startCol, endRow, endCol)
    //     }
    // }

    // for (i in 0..k-1) {
    //     result -= getSum(r+1+i, c-k, r+1+i, c-k+i) // 3사분면
    //     result -= getSum(r+k-i, c+1+i, r+k-i, c+k) // 4사분면
    // }
    // return result
}

fun getSum(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    if (!inArray(r1, c1) || !inArray(r2, c2)) {
        return 0
    }
    return prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1]
}

fun inArray(r: Int, c: Int): Boolean {
    return r >= 1 && r <= n && c >= 1 && c <= n
}