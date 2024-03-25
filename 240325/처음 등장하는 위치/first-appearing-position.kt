import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { x -> x.toInt() }.toList()

    val map: TreeMap<Int, Int> = TreeMap()

    var index = 1
    for (number in numbers) {
        if (!map.containsKey(number)) {
            map[number] = index
        }
        index++
    }

    for ((number, index) in map.entries) {
        println("$number $index")
    }
}