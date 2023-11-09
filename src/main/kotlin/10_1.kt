import java.time.LocalDate

class FormValidator {
    fun validateName(name: String) {
        if (name.length < 2 || name.length > 20 || name[0].isLowerCase()) {
            throw Exception("Некорректное имя")
        }
    }
    fun validateBirth(birth: LocalDate) {
        val currentDate = LocalDate.now()
        val minDate = LocalDate.of(1900, 1, 1)
        if (birth.isBefore(minDate) || birth.isAfter(currentDate)) {
            throw Exception("Некорректная дата рождения")
        }
    }
    fun validateGender(gender: Gender) {
        if (gender !in Gender.values()) {
            throw Exception("Некорректный пол")
        }
    }
    fun validateWeight(weight: String) {
        try {
            val parsedWeight = weight.toDouble()
            if (parsedWeight <= 0) {
                throw Exception("Некорректный вес")
            }
        } catch (e: NumberFormatException) {
            throw Exception("Некорректный вес")
        }
    }
}

enum class Gender {
    Male, Female
}

fun main() {
    val formValidator = FormValidator()
    val name = "John"
    val birth = LocalDate.of(1900, 5, 15)
    val gender = Gender.Male
    val weight = "70.5"
    try {
        formValidator.validateName(name)
        formValidator.validateBirth(birth)
        formValidator.validateGender(gender)
        formValidator.validateWeight(weight)
    } catch (e: Exception) {
        println(e.message)
    }
}