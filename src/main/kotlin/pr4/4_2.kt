package pr4
fun program(){
    val norms = readLine().orEmpty().split(" ").map { it.toInt() }
    val A = norms[0]
    val B = norms[1]
    val C = norms[2]
    val K = norms[3]
    val days = mutableListOf<List<Int>>()
    for (i in 1..7) {
        val nutr = readLine().orEmpty().split(" ").map { it.toInt() }
        days.add(nutr)
    }
    val allA = days.sumBy { it[0] }
    val allB = days.sumBy { it[1] }
    val allC = days.sumBy { it[2] }
    val allK = days.sumBy { it[3] }
    if (allA <= A && allB <= B && allC <= C && allK <= K) {
        println("Отлично")
    } else {
        println("Нужно есть поменьше")
    }
}
fun main() {
    program()
}
