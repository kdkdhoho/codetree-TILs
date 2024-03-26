import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val numbers = sc.nextLine().split(" ").map { x -> x.toInt() }

    val map: TreeMap<Int, Int> = TreeMap()

    var index = 1
    for (number in numbers) {
        if (!map.containsKey(number)) {
            map.put(number, index++)
        }
    }

    val answer: StringBuilder = StringBuilder()
    for ((number, index) in map) {
        answer.append("$number $index\n")
    }
    print(answer)
}