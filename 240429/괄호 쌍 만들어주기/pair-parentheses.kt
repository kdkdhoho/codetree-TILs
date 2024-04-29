fun main() {
    val s = readLine()!!
    val n = s.length

    val R = IntArray(n)
    for (i in n-2 downTo 0) {
        R[i] = R[i + 1]
        if (s[i] == ')' && s[i + 1] == ')') {
            R[i]++    
        }
    }

    var answer = 0
    for (i in 0..n-2) {
        if (s[i] == '(' && s[i+1] == '(') {
            answer += R[i]
        }
    }

    print(answer)
}