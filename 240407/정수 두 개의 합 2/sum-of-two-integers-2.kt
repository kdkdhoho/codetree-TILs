import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()
val nums = IntArray(n + 1)

/**
j를 0부터 시작해서 앞으로 증가한다.
i != j && nums[j]를 더했을 때 sum > k가 되는 순간까지 증가한다.
증가가 끝났다면 count한다.

다음 i를 한 칸 앞으로 옮기며 sum -= nums[i]를 한다.
*/
fun main() {
    for (i in 1..n) {
        nums[i] = sc.nextInt()
    }

    var answer = 0
    var sum = 0
    var j = 0

    for (i in 1..n) {
        sum += nums[i]

        while (j + 1 <= n && sum + nums[j + 1] <= k) {
            j++
            sum += nums[j]

            if (i != j && sum <= k) {
                answer++
            }

            sum -= nums[j]
        }
        sum += nums[j]
        sum -= nums[i]
    }
    print(answer)
}