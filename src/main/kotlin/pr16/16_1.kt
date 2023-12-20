data class SportsActivity(val name: String, val sportType: String, val duration: Int)
fun main(){
    val activities = sequenceOf(
        SportsActivity("Иван", "Баскетбол", 60),
        SportsActivity("Петя", "Плавание", 45),
        SportsActivity("Вася", "Футбол", 90),
        SportsActivity("Кирилл", "Баскетбол", 75),
        SportsActivity("Мария", "Плавание", 30)
    )
    val formattedActivities = activities.map { activity ->
        "Участник: ${activity.name}, Вид спорта: ${activity.sportType}, Длительность: ${activity.duration} мин."
    }
    println("Отформатированные активности:")
    formattedActivities.forEach(::println)
    println('\n')
    val groupedBySportType = activities.groupBy { it.sportType }
    groupedBySportType.forEach(::println)
    println('\n')
    val averageDurationBySportType = activities.groupBy { it.sportType }.mapValues { (_, activities) ->
        activities.map { it.duration }.average()
    }
    val formattedAverageDurations = averageDurationBySportType.map { (sportType, avgDuration) ->
        "Вид спорта: $sportType, Средняя длительность: ${avgDuration.toInt()} мин."
    }
    println("Средние длительности по виду спорта:")
    formattedAverageDurations.forEach(::println)
}
