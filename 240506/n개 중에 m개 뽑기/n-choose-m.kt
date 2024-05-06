import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()
val answer = StringBuilder()

fun main() {
    recursive(1, mutableListOf())

    print(answer)
}

fun recursive(
    num: Int,
    nums: MutableList<Int>
) {
    if (num == n + 1) {
        if (nums.size == m) {
            answer.append(nums.joinToString(" ")).append("\n")
        }
        return
    }

    nums.add(num)
    recursive(num + 1, nums)
    nums.removeAt(nums.size - 1)
    recursive(num + 1, nums)
}