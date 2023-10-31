package pr6

class AmazingString(input: CharArray) {
    private var charArray: CharArray = input

    constructor(input: String) : this(input.toCharArray())
    fun getSymbol(index: Int): Char {
        if (index < 0 || index >= charArray.size) {
            throw IndexOutOfBoundsException("Index out of bounds")
        }
        return charArray[index]
    }
    fun length(): Int {
        return charArray.size
    }
    fun print() {
        println(String(charArray))
    }
    fun checkSubstring(substring: CharArray): Boolean {
        return String(charArray).contains(String(substring))
    }
    fun checkSubstring(substring: String): Boolean {
        return String(charArray).contains(substring)
    }
    fun delSpace() {
        val notSpace = charArray.indexOfFirst { !it.isWhitespace() }
        if (notSpace >= 0) {
            charArray.copyInto(charArray, 0, notSpace)
        }
    }
    fun reverse() {
        var start = 0
        var end = charArray.size - 1
        while (start < end) {
            val temp = charArray[start]
            charArray[start] = charArray[end]
            charArray[end] = temp
            start++
            end--
        }
    }
}

fun main() {
    val amazingString = AmazingString("a")
    amazingString.print()

    var i :Int = readLine()!!.toInt()
    println("Символ № $i: ${amazingString.getSymbol(i)}")

    println("Длина строки: ${amazingString.length()}")

    println("Содержит ли подстроку \"23\": ${amazingString.checkSubstring("23")}")
    println("Содержит ли подстроку \"31\": ${amazingString.checkSubstring("31")}")

    amazingString.delSpace()
    println("После удаления ведущих пробелов:")
    amazingString.print()

    amazingString.reverse()
    println("Разворот:")
    amazingString.print()
}