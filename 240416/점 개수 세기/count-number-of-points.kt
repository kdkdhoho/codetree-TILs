import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val q = sc.nextInt()
val treeSet = TreeSet<Int>()
val hashMap = hashMapOf<Int, Int>()
val answer = StringBuilder()

fun main() {
    for (i in 1..n) { // O(N)
        treeSet.add(sc.nextInt()) // O(logN)
    } // O(NlogN)

    var count = 1
    for (num in treeSet) { // O(N)
        hashMap.put(num, count) // O(logN)
        count += 1
    } // O(NlogN)

    for (i in 1..q) { // O(Q)
        val a = sc.nextInt()
        val b = sc.nextInt()

        val newA = treeSet.ceiling(a) ?: 0
        val newB = treeSet.floor(b) ?: 0

        if (newA == 0 || newA > newB) {
            answer.append(0).append("\n")
            continue
        }

        val start = hashMap.get(newA)!! // O(logN)
        val end = hashMap.get(newB)!! // O(logN)

        val result = end - start + 1
        answer.append(result).append("\n")
    } // O(QlogN)

    print(answer)
}