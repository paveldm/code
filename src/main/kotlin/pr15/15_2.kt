data class Country(val name: String, val continent: String, val population: Int, val area: Int)

fun main(){
    val countries = sequenceOf(
        Country("Россия", "Европа", 140000000, 17098246),
        Country("Канада", "Северная Америка", 328200000, 9985000),
        Country("Китай", "Азия", 1403500365, 9640011),
        Country("Аргентина", "Южная Америка", 45810000, 2780000),
        Country("Новая Зеландия", "Океания", 5123000, 268021),
        Country("Египет", "Африка", 109300000, 1002000),
    )

    val filteredByContinent = countries.filter { it.continent == "Европа" }
    println("Страны в Европе:")
    filteredByContinent.forEach { println(it.name) }

    val population50M = filteredByContinent.any { it.population > 50000000 }
    println("Есть ли страны с населением > 50 млн.: $population50M")

    val filteredByArea = countries.filter { it.area > 500000 }
    println("Страны, площадь которых > 500 тыс. кв. км.:")
    filteredByArea.forEach { println(it.name) }

    val population100M = filteredByArea.all { it.population < 100000000 }
    println("Все ли страны имеют население < 100 млн.: $population100M")
}
