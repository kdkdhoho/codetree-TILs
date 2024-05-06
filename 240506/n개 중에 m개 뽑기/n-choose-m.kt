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
    startNum: Int,
    selectedNums: MutableList<Int>
) {
    if (selectedNums.size == m) {
        answer.append(selectedNums.joinToString(" ")).append("\n")
        return
    }

    for (num in startNum..n) {
        selectedNums.add(num)
        recursive(num + 1, selectedNums)
        selectedNums.removeAt(selectedNums.size - 1)
    }
}