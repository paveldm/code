package pr7
abstract class Person(val name: String)
class Author(name: String, var books: MutableList<Book> = mutableListOf()) : Person(name)
class Book(val name: String, val author: Author)
class Visitor(name: String, var id: Int? = null, var book: Book? = null) : Person(name)
class Library {
    val books = mutableListOf<Book>()
    val ratings = mutableMapOf<String, MutableList<Int>>()
    fun addBook(book: Book) {
        if (books.none { it.name == book.name }) {
            books.add(book)
        }
    }
    fun removeBook(name: String, visitor: Visitor) {
        val book = findBook(name)
        if ((book != null && book.author != null) && !(visitor.book == book)) {
            books.remove(book)
        }
    }
    fun findBook(name: String): Book? {
        return books.find { it.name == name }
    }
    fun findAuthorBooks(author: Author): List<Book> {
        return books.filter { it.author == author }
    }
    fun borrowBook(visitor: Visitor, name: String) {
        val book = findBook(name)
        if (book != null && visitor.book == null) {
            visitor.book = book
            if (visitor.id == null) {
                visitor.id = books.size + 1
            }
            if (!ratings.containsKey(name)) {
                ratings[name] = mutableListOf()
            }
        }
    }
    fun returnBook(visitor: Visitor, rating: Int) {
        if (visitor.book != null) {
            val bookName = visitor.book?.name
            if (bookName != null) {
                ratings[bookName]?.add(rating)
            }
            visitor.book = null
        }
    }
    fun getBookRating(bookName: String): Double? {
        val bookRatings = ratings[bookName]
        return bookRatings?.average()
    }
}
fun main() {
    val author = Author("Николай Гоголь")
    val book1 = Book("Мертвые души", author)
    val book2 = Book("Шинель", author)
    val visitor1 = Visitor("Иван")
    val visitor2 = Visitor("Петя")
    val library = Library()
    library.addBook(book1)
    library.addBook(book2)
    val foundBook = library.findBook("Мертвые души")
    if (foundBook != null) {
        println("Найденная книга: " + foundBook.name)
    }
    val authorBooks = library.findAuthorBooks(author)
    println("Книги автора " + author.name + ": " + authorBooks.map { it.name })
    library.borrowBook(visitor1, "Мертвые души")
    println("Одолженная книга: " + visitor1.book?.name)
    library.returnBook(visitor1, 4)
    library.borrowBook(visitor2, "Мертвые души")
    println("Одолженная книга: " + visitor2.book?.name)
    library.returnBook(visitor2, 2)
    val bookRating = library.getBookRating("Мертвые души")
    println("Оценка книги 'Мертвые души': $bookRating")
}
