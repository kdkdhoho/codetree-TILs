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
    for (i in 0..n-1) {
        treeSet.add(input2[i].toInt())
    }

    var number = 1
    for (x in treeSet) {
        hashMap.put(x, number)
        number += 1
    }

    for (i in 1..q) {
        val input3 = reader.readLine().split(" ")
        var startPointValue: Int? = input3[0].toInt()
        var endPointValue: Int? = input3[1].toInt()

        startPointValue = treeSet.ceiling(startPointValue) ?: null
        endPointValue = treeSet.floor(endPointValue) ?: null
        
        when {
            startPointValue == null || endPointValue == null -> answer.append(0)
            
            else -> {
                val startPointNumber = hashMap.get(startPointValue)!!
                val endPointNumber = hashMap.get(endPointValue)!!

                when {
                    startPointNumber > endPointNumber -> answer.append(0)
                    else -> {
                        val count = endPointNumber - startPointNumber + 1
                        answer.append(count)
                    }
                }
            }
        }
        
        answer.append("\n")
    }

    print(answer)
}