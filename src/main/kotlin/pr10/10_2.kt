package pr10

data class User(val name: String, val age: Int, val friends: List<String>)

fun main() {
    val userList = object {
        val users = listOf(
            User("Петя", 25, listOf("Вася", "Ваня")),
            User("Вася", 22, listOf("Петя", "Ваня")),
            User("Ваня", 30, listOf("Петя", "Вася")),
        )
    }
    val oldestUser = userList.users.maxByOrNull { it.age }
    println("Старший пользователь в списке: " +  oldestUser?.name + ", его возраст: " + oldestUser?.age)
}