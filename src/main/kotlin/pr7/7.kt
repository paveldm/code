package pr7

abstract class Person(val name: String)

class Author(name: String, var books: MutableList<Book> = mutableListOf()) : Person(name)

class Book(val name: String, val author: Author)

class Visitor(name: String, var id: Int? = null, var book: Book? = null) : Person(name)

class Library {
    val books = mutableListOf<Book>()

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
        }
    }

    fun returnBook(visitor: Visitor) {
        if (visitor.book != null) {
            visitor.book = null
        }
    }
}

fun main() {
    val author = Author("Николай Гоголь")
    val book1 = Book("Мертвые души", author)
    val book2 = Book("Шинель", author)
    val visitor = Visitor("Иван")

    val library = Library()
    library.addBook(book1)
    library.addBook(book2)

    val foundBook = library.findBook("Мертвые души")
    if (foundBook != null) {
        println("Найденная книга: " + foundBook.name)
    }

    val authorBooks = library.findAuthorBooks(author)
    println("Книги автора " + author.name + ": " + authorBooks.map { it.name })

    library.borrowBook(visitor, "Мертвые души")
    println("Одолженная книга: " + visitor.book?.name)

    library.returnBook(visitor)
    println("Возвращенная книга: " + visitor.book)

    library.removeBook("Мертвые души", visitor)
    print("Список книг в библиотеке после удаления книги \"Мертвые души\": ")
    library.books.forEach{ print(it.name) }
}