package pr5
class Student {
    private var name: String = ""
    private var surname: String = ""
    private var grades: IntArray = IntArray(10)
    fun getName(): String { return name }
    fun setName(newName: String) { name = newName }
    fun getSurname(): String { return surname }
    fun setSurname(newSurname: String) { surname = newSurname }
    fun getGrades(): IntArray { return grades }
    fun setGrades(newGrades: IntArray) { grades = newGrades }
    fun addGrade(newGrade: Int) {
        for (i in 0 until grades.size - 1) {
            grades[i] = grades[i + 1]
        }
        grades[grades.size - 1] = newGrade
    }
    fun calculateAverageGrade(): Double {
        var sum = 0
        for (grade in grades) { sum += grade }
        return sum.toDouble() / grades.size
    }
}
fun main() {
    val student = Student()
    student.setName("Петр")
    student.setSurname("Петров")
    student.setGrades(intArrayOf(4, 5, 3, 3, 5, 2, 4, 5, 2, 4))
    println(student.getName() + " " + student.getSurname())
    println("Оценки: ${student.getGrades().joinToString()}")
    println("Средний балл: " + student.calculateAverageGrade())
    student.addGrade(2)
    println("Обновленные оценки: ${student.getGrades().joinToString()}")
}
