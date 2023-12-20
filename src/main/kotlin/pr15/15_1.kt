data class Book(val title: String, val author: String)
fun main() {
    val library = sequenceOf(
        Book("Book 1", "Author 1"),
        Book("Book 2", "Author 2"),
        Book("Book 3", "Author 1"),
        Book("Book 4", "Author 3"),
        Book("Book 5", "Author 1")
    )
    val uniqueAuthors = getUniqueAuthors(library)
    val booksByAuthor = getBooksByAuthor(library, "Author 1")
    println("Unique authors: $uniqueAuthors")
    println("Books by Author 1:")
    booksByAuthor.forEach { println(it.title) }
}
fun getUniqueAuthors(library: Sequence<Book>): List<String> {
    return library.map { it.author }.distinct().toList()
}
fun getBooksByAuthor(library: Sequence<Book>, author: String): List<Book> {
    return library.filter { it.author == author }.toList()
}
