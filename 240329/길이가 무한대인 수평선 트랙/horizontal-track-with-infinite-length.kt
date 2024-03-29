import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val t = sc.nextInt()

fun main() {
    val people: MutableList<Person> = mutableListOf()
    for (i in 1..n) { // O(N)
        val start = sc.nextInt()
        val speed = sc.nextInt()
        people.add(Person(start, speed))
    }

    val result: TreeSet<Person> = TreeSet()
    for (i in 0..n-1) { // O(N)
        result.add(people[i])
    }

    var answer = 1
    var person = result.first()
    while (person != null) { // O(N)
        val nextPerson = result.higher(person) ?: null

        if (nextPerson != null) {
            if (nextPerson.getLast(t) == person.getLast(t)) {
                person = nextPerson
                continue
            }

            if (nextPerson.start > person.start) {
                answer++
            }
        }
        person = nextPerson
    }

    print(answer)
}

data class Person(
    val start: Int,
    val speed: Int
): Comparable<Person> {

    fun getLast(time: Int): Int {
        return start + speed * time
    }

    override fun compareTo(o: Person): Int {
        if (this.getLast(t) == o.getLast(t)) {
            return this.start - o.start
        }
        return this.getLast(t) - o.getLast(t)
    }
}