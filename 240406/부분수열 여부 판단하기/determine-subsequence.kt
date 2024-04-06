import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val m = sc.nextInt()

val numsA = IntArray(n)
val numsB = IntArray(m)

fun main() {
    var i = 0
    
    for (i in 0..n-1) {
        numsA[i] = sc.nextInt()
    }
    for (i in 0..m-1) {
        numsB[i] = sc.nextInt()
    }

    for (j in 0..m-1) {
        while (i < n && numsA[i] != numsB[j]) {
            i++
        }

        if (i >= n) {
            print("No")
            return
        }

        i++
    }

    print("Yes")
}