import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val k = sc.nextInt()
val arr = Array(n + 1) { IntArray(n + 1) }
val prefix = Array(n + 1) { IntArray(n + 1) }

fun main() {
    for (row in 1..n) {
        for (col in 1..n) {
            arr[row][col] = sc.nextInt()
        }
    }

    for (row in 1..n) {
        for (col in 1..n) {
            prefix[row][col] = prefix[row-1][col] + prefix[row][col-1] - prefix[row-1][col-1] + arr[row][col]
        }
    }

    var answer = 0
    for (row in 1..n) {
        for (col in 1..n) {
            var sum = 0

            for (r in row-k..row+k) {
                if (r in 1..n) {
                    val gap = k - Math.abs(row - r)
                    val startCol = if (col - gap < 1) 1 else (col - gap)
                    val endCol = if (col + gap > n) n else (col + gap)

                    sum += getSectionSum(r, startCol, r, endCol)
                }
            }

            answer = Math.max(answer, sum)
        }
    }
    print(answer)
}

fun getSectionSum(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    return prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1]
}