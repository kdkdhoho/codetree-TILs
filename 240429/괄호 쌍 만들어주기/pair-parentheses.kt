fun main() {
    val s = readLine()!!

    var openCount = 0
    var closeCount = 0
    for (i in 0..s.length-2) {
        when (s[i]) {
            '(' -> {
                if (s[i+1] == '(') {
                    openCount++
                }
            }
            ')' -> {
                if (s[i+1] == ')') {
                    closeCount++
                }
            }
        }
    }

    print(openCount * closeCount)
}