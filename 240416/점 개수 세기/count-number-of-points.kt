/**
수직선 상 위에 서로 다른 위치에 N개의 점이 있다.
Q개의 질의에 대해 각각 구간 내 점의 개수는?

1 <= N, Q <= 10^5
-10^9 <= points[i] <= 10^9
-10^9 <= a <= b <= 10^9
*/

import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val q = sc.nextInt()
val treeSet = TreeSet<Int>()
val treeMap = TreeMap<Int, Int>()
val answer = StringBuilder()

fun main() {
    for (i in 1..n) {
        treeSet.add(sc.nextInt())
    }

    var count = 1
    while (!treeSet.isEmpty()) {
        val minNum = treeSet.pollFirst()
        treeMap.put(minNum, count)
        count += 1
    }

    for (i in 1..q) {
        val a = sc.nextInt()
        val b = sc.nextInt()

        val start = treeMap.get(treeMap.ceilingKey(a)) ?: 0
        val end = treeMap.get(treeMap.floorKey(b)) ?: 0

        val result = end - start + 1
        answer.append(result).append("\n")
    }

    print(answer)
}