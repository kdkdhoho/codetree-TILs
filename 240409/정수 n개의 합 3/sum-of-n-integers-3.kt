import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val arr = Array(n + 1) { IntArray(n + 1) }
val sumArr = Array(n + 1) { IntArray(n + 1) }

fun main() {
    for (row in 1..n) {
        for (col in 1..n) {
            arr[row][col] = sc.nextInt()
        }
    }

    for (row in 1..n) {
        for (col in 1..n) {
            sumArr[row][col] = sumArr[row - 1][col] +
                            sumArr[row][col - 1] +
                            arr[row][col] -
                            sumArr[row - 1][col - 1]
        }
    }

    var answer = 0
    for (row in k..n) {
        for (col in k..n) {
            val row_ = row - k + 1
            val col_ = col - k + 1

            val sum = sumArr[row][col] - 
                    sumArr[row_ - 1][col] -
                    sumArr[row][col_ - 1] +
                    sumArr[row_ - 1][col_ - 1]
            answer = Math.max(answer, sum)
        }
    }

    print(answer)
}