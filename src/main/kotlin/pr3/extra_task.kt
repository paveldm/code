package pr3

import kotlin.random.Random
fun main() {
    val passwordLength = enterPasswordLength()
    val password = generatePassword(passwordLength)
    println("Безопасный пароль: " + password)
}

fun enterPasswordLength(): Int {
    print("Введите длину пароля (N >= 8): ")
    var passwordLength = readLine()?.toIntOrNull()
    while (passwordLength == null || passwordLength < 8) {
        println("Пароль с " + passwordLength + " количеством символов небезопасен")
        print("Введите длину пароля (n >= 8): ")
        passwordLength = readLine()?.toIntOrNull()
    }
    return passwordLength
}

fun generatePassword(length: Int): String {
    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowers = "abcdefghijklmnopqrstuvwxyz"
    val nums = "0123456789"
    val specials = "_*-"
    val allCharacters = upper + lowers + nums + specials
    val password = buildString {
        repeat(length) {
            val randomChar = allCharacters[Random.nextInt(0, allCharacters.length)]
            append(randomChar)
        }
    }
    return password
}