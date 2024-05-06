import java.util.*
import kotlin.math.max

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val m = sc.nextInt()
val nums = mutableListOf<Int>()
var max = Int.MIN_VALUE

fun main() {
    for (i in 1..n) {
        nums.add(sc.nextInt())
    }

    recursive(0, mutableListOf())

    print(max)
}

fun recursive(
    idx: Int,
    selectedNums: MutableList<Int>
) {
    if (idx == n) {
        if (selectedNums.size == m) {
            var result = selectedNums[0]
            for (i in 1..selectedNums.size - 1) {
                result = result.xor(selectedNums[i])
            }
            max = max(max, result)
        }
        return
    }

    selectedNums.add(nums[idx])
    recursive(idx + 1, selectedNums)
    selectedNums.removeAt(selectedNums.size - 1)
    recursive(idx + 1, selectedNums)
}