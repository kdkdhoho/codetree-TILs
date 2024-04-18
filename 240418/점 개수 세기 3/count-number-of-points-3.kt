import java.util.*
import java.io.*

val reader = BufferedReader(InputStreamReader(System.`in`))

val input1 = reader.readLine().split(" ")
val n = input1[0].toInt()
val q = input1[1].toInt()

val treeSet = TreeSet<Int>()
val hashMap = hashMapOf<Int, Int>()
val answer = StringBuilder()

fun main() {
    val input2 = reader.readLine().split(" ")
    for (i in 0..n-1) { // O(N)
        treeSet.add(input2[i].toInt()) // O(logN)
    } // O(NlogN)

    var number = 1
    for (x in treeSet) { // O(N)
        hashMap.put(x, number) // O(1)
        number += 1
    }

    for (i in 1..q) { // O(Q)
        val input3 = reader.readLine().split(" ")
        val startPointValue = input3[0].toInt()
        val endPointValue = input3[1].toInt()

        val startPointNumber = hashMap.get(startPointValue)!! // O(1)
        val endPointNumber = hashMap.get(endPointValue)!! // O(1)

        when {
            startPointNumber > endPointNumber -> answer.append(0)
            else -> {
                val count = endPointNumber - startPointNumber + 1
                answer.append(count)
            }
        }
        answer.append("\n")
    }

    print(answer)
}