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
    println("num=$num nums=$nums")
    if (nums.size == m) {
        answer.append(nums.joinToString(" ")).append("\n")
        return
    }

    for (num in num..n) {
        nums.add(num)
        recursive(num + 1, nums)
        nums.removeAt(nums.size - 1)
    }
}