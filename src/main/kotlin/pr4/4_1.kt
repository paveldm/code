package pr4
fun isSymmetric(matrix: Array<IntArray>, n: Int): Boolean {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[i][j] != matrix[n - j - 1][n - i - 1]) {
                return false
            }
        }
    }
    return true
}
fun main() {
    val n = readLine().orEmpty().toInt()
    val matrix = Array(n) { IntArray(n) { 0 } }
    for (i in 0 until n) {
        val row = readLine().orEmpty().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            matrix[i][j] = row[j]
        }
    }
    val res = isSymmetric(matrix, n)
    println(res)
}
