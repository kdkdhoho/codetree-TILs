import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextInt()

    val numbersA: MutableList<Int> = mutableListOf()
    val numbersB: MutableList<Int> = mutableListOf()

    for (i in 1..n) {
        numbersA.add(sc.nextInt())
    }
    for (i in 1..m) {
        numbersB.add(sc.nextInt())
    }

    val setA: HashSet<Int> = HashSet(numbersA)
    numbersB.forEach { x -> setA.remove(x) }

    val setB: HashSet<Int> = HashSet(numbersB)
    numbersA.forEach { x -> setB.remove(x) }

    val result: HashSet<Int> = HashSet()
    result.addAll(setA)
    result.addAll(setB)

    print(result.count())
}