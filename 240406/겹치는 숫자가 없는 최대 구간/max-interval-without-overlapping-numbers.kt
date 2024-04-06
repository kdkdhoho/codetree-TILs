import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val arr = IntArray(n)

fun main() {
    for (i in 0..n-1) {
        arr[i] = sc.nextInt()
    }

    var i = 0
    var j = 0
    var answer = 0
    val set = hashSetOf<Int>()

    while (true) {
        if (!set.contains(arr[j])) {
            set.add(arr[j])
            j++
            continue
        }

        answer = Math.max(answer, (j-1)-i+1)
        while (true) {
            if (i >= j || !set.contains(arr[j])) {
                break
            }

            set.remove(arr[i])
            i++
        }

        answer = Math.max(answer, j - i + 1)
        
        j++
        if (j >= n) {
            break
        } else {
            set.add(arr[j])
        }
    }

    print(answer)
}