package pr5

class StudentService {
    fun bestStudent(students: Array<Student>): Student? {
        var bestStudent: Student? = null
        var gradeOfBest = 0.0
        for (student in students) {
            val averageGrade = student.calculateAverageGrade()
            if (averageGrade > gradeOfBest) {
                gradeOfBest = averageGrade
                bestStudent = student
            }
        }
        return bestStudent
    }

    fun sortBySurname(students: Array<Student>): Array<Student> {
        return students.sortedBy { it.getSurname() }.toTypedArray()
    }
}
fun main() {
    val student1 = Student()
    student1.setName("Петр")
    student1.setSurname("Петров")
    student1.setGrades(intArrayOf(5, 4, 3, 2, 4, 5, 3, 2, 5, 4))

    val student2 = Student()
    student2.setName("Иван")
    student2.setSurname("Иванов")
    student2.setGrades(intArrayOf(4, 5, 4, 3, 4, 5, 4, 5, 3, 2))

    val student3 = Student()
    student3.setName("Василий")
    student3.setSurname("Васильев")
    student3.setGrades(intArrayOf(3, 4, 3, 2, 4, 3, 3, 2, 2, 4))

    val students = arrayOf(student1, student2, student3)

    val studentService = StudentService()

    val bestStudent = studentService.bestStudent(students)
    if (bestStudent != null) {
        println(bestStudent.getName() + " " + bestStudent.getSurname() + "\n")
    } else {
        println("Нет")
    }

    val sortedStudents = studentService.sortBySurname(students)
    println("Сортировка по фамилии:")
    for (student in sortedStudents) {
        println("${student.getName()} ${student.getSurname()}")
    }
}