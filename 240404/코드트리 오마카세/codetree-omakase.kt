import java.util.*

val sc = Scanner(System.`in`)

val L = sc.nextInt()
val Q = sc.nextInt()

val belt = LinkedList<MutableMap<String, Int>>()
val peopleNames = arrayOfNulls<String>(L)
val peopleAmounts = arrayOfNulls<Int>(L)
val answer = StringBuilder()

fun main() {
    for (i in 0..L-1) {
        belt.add(mutableMapOf())
    }
    sc.nextLine()
    
    for (i in 1..Q) {
        val split = sc.nextLine().split(" ")
        val command = split[0]

        when (command) {
            "100" -> {
                val x = split[2].toInt()
                val name = split[3]

                val map: MutableMap<String, Int> = belt.get(x)
                if (map.containsKey(name)) {
                    map.put(name, map.get(name)!! + 1)
                } else {
                    map.put(name, 1)
                }

                if (peopleNames[x] != null) {
                    eat(x, peopleNames[x]!!)
                }
            }
            "200" -> {
                val x = split[2].toInt()
                val name = split[3]
                val amount = split[4].toInt()

                peopleNames[x] = name
                peopleAmounts[x] = amount

                eat(x, name)
            }
            "300" -> {
                rotate()
                eatEveryBody()
                takePicture()
            }
            else -> { }
        }

        rotate()
        eatEveryBody()
    }

    print(answer)
}

fun rotate() {
    val map = belt.pollLast()
    belt.addFirst(map)
}

fun eat(x: Int, name: String) {
    val map: MutableMap<String, Int> = belt.get(x)

    if (map.containsKey(name)) {
        val currentAmount = map.get(name)!!
        val eatenAmount = currentAmount - (peopleAmounts[x] ?: 0)

        if (eatenAmount <= 0) {
            map.remove(name)
        } else {
            map.put(name, eatenAmount)
        }

        val remainPersonAmount = (peopleAmounts[x] ?: 0) - currentAmount
        peopleAmounts[x] = remainPersonAmount
    }

    if (peopleAmounts[x] ?: 0 <= 0) {
        peopleNames[x] = null
        peopleAmounts[x] = null
    }
}

fun eatEveryBody() {
    for (x in 0..L-1) {
        val personName = peopleNames[x]
        if (personName != null) {
            eat(x, personName)
        }
    }
}

fun takePicture() {
    var sushiCount = 0
    var peopleCount = 0

    for (x in 0..L-1) {
        val map = belt.get(x)
        for ((k, v) in map) {
            sushiCount += v
        }

        if (peopleNames[x] != null) {
            peopleCount++
        }
    }

    answer.append("$peopleCount $sushiCount\n")
}