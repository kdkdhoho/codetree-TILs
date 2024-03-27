import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextInt()

    val invited: HashSet<Int> = HashSet()
    invited.add(1)

    for (i in 1..m) {
        val k = sc.nextInt()

        var notInvitedPerson = 0
        var invitedCount = 0
        for (j in 1..k) {
            val person = sc.nextInt()
            
            if (person in invited) {
                invitedCount++
            } else {
                notInvitedPerson = person
            }
        }

        if (invitedCount == k - 1) {
            invited.add(notInvitedPerson)
        }
    }

    print(invited.count())
}