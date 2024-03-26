import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { x -> x.toInt() }

    println(numbers)

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