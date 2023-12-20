data class Student(val name: String, val age: Int, val averageGrade: Double, val missedClasses: Int)
fun main() {
    val students = sequenceOf(
        Student("Иван", 19, 4.5, 2),
        Student("Мария", 21, 4.2, 1),
        Student("Петр", 22, 4.8, 0),
        Student("Анна", 20, 4.6, 3)
    )
    val sortedByAverageGrade = students.sortedByDescending { it.averageGrade }
    println("Отсортированные по среднему баллу студенты:")
    sortedByAverageGrade.forEach { println(it) }
    val averageAge = students.map { it.age }.average()
    println("Средний возраст студентов: $averageAge")
    val studentsOlderThan20 = sortedByAverageGrade.takeWhile { it.age > 20 }
    println("Студенты старше 20 лет:")
    studentsOlderThan20.forEach { println(it) }
    val bestStudent = students.maxByOrNull { it.averageGrade }
    println("Лучший студент: $bestStudent")
}
