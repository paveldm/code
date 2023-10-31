package pr4

fun sortingWords(words: Array<String>, k: Int): List<String> {
    val wordsMap = mutableMapOf<String, Int>()
    for (word in words) {
        wordsMap[word] = wordsMap.getOrDefault(word, 0) + 1
    }

    val sortedWords = wordsMap.keys.sortedWith(compareByDescending<String> { wordsMap[it] }.thenByDescending { it })
    return sortedWords.subList(0, k)
}
fun main() {
    val words = arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "day")
    val k = 4
    val result = sortingWords(words, k)
    println(result)
}