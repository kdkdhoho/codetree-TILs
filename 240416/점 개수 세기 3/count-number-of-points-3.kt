import java.util.*

val sc = Scanner(System.`in`)
    
val n = sc.nextInt()
val q = sc.nextInt()

fun main() {
    val treeSet = TreeSet<Int>()
    for (i in 0..n-1) {
        treeSet.add(sc.nextInt())
    }
    
    val hashMap = hashMapOf<Int, Int>()
    var count = 1
    while (!treeSet.isEmpty()) {
        val minNum = treeSet.pollFirst()
        hashMap.put(minNum, count++)
    }

    val answer = StringBuilder()
    for (i in 1..q) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        
        val s = hashMap.get(a)!!
        val e = hashMap.get(b)!!

        answer.append(e - s + 1).append("\n")
    }
    print(answer)
}