package pr3

fun main() {
    val S: String = readLine().orEmpty().toString()
    var newS: String = ""
    for (char in S) {
        when (char) {
            'А' -> newS += ".- "
            'Б' -> newS += "-... "
            'В' -> newS += ".-- "
            'Г' -> newS += "--. "
            'Д' -> newS += "-.. "
            'Е' -> newS += ". "
            'Ё' -> newS += ". "
            'Ж' -> newS += "...- "
            'З' -> newS += "--.. "
            'И' -> newS += ".. "
            'Й' -> newS += ".--- "
            'К' -> newS += "-.- "
            'Л' -> newS += ".-.. "
            'М' -> newS += "-- "
            'Н' -> newS += "-. "
            'О' -> newS += "--- "
            'П' -> newS += ".--. "
            'Р' -> newS += ".-. "
            'С' -> newS += "... "
            'Т' -> newS += "- "
            'У' -> newS += "..- "
            'Ф' -> newS += "..-. "
            'Х' -> newS += ".... "
            'Ц' -> newS += "-.-. "
            'Ч' -> newS += "---. "
            'Ш' -> newS += "---- "
            'Щ' -> newS += "--.- "
            'Ъ' -> newS += ".--.-. "
            'Ы' -> newS += "-.-- "
            'Ь' -> newS += "-..- "
            'Э' -> newS += "..-.. "
            'Ю' -> newS += "..-- "
            'Я' -> newS += ".-.- "
        }
    }
    println(newS)
}