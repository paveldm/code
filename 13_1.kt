fun <T> getUniqueElements(inputList: ArrayList<T>): Set<T> {
    return inputList.toSet()
}
fun main() {
    val inputList = arrayListOf(1, 2, 3, 2, 4, 5, 1, 6)
    val uniqueElements = getUniqueElements(inputList)

    println("Уникальные элементы: $uniqueElements")
}