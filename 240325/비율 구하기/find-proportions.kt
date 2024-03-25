import java.util.*

fun main() {
    val answer: StringBuilder = StringBuilder()
    val n = readLine()!!.toInt()
    val map: TreeMap<String, Int> = TreeMap()

    for (i in 1..n) {
        val s = readLine()!!
        map.put(s, map.getOrDefault(s, 0) + 1)
    }

    for ((str, cnt) in map.entries) {
        val value: Double = (cnt * 100.0 / n)
        answer.append("$str ${String.format("%.4f", value)}").append("\n")
    }
    print(answer)
}