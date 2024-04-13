import java.util.*

val sc = Scanner(System.`in`)
    
val n = sc.nextInt()
val q = sc.nextInt()

fun main() {
    val treeSet = TreeSet<Int>()
    for (i in 0..n-1) {
        treeSet.add(sc.nextInt())
    }
    
    // K: 주어진 점
    // V: 1번 째부터 해당 점까지의 전체 점의 수
    val treeMap = TreeMap<Int, Int>()
    var count = 1
    while (!treeSet.isEmpty()) {
        val minNum = treeSet.pollFirst()
        treeMap.put(minNum, count++)
    }

    val answer = StringBuilder()
    for (i in 1..q) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        
        val s = treeMap.get(treeMap.ceilingKey(a)) ?: 0
        val e = treeMap.get(treeMap.floorKey(b)) ?: 0

        answer.append(e - s + 1).append("\n")
    }
    print(answer)
}