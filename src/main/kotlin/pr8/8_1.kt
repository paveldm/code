enum class DrinkType(val volume: Int) {
    COLA(1000), WATER(500), TEA(250), COFFEE(300);
    fun getDrinkName(): String {
        return when (this) {
            COLA -> "Cola"
            WATER -> "Water"
            TEA -> "Tea"
            COFFEE -> "Coffee"
        }
    }
    fun getDrinkVolume(drinkType: DrinkType): Int {
        return drinkType.volume
    }
}
fun main() {
    val cola = DrinkType.COLA
    val water = DrinkType.WATER
    val tea = DrinkType.TEA
    val coffee = DrinkType.COFFEE
    println(cola.getDrinkName() + " " + cola.getDrinkVolume(cola) +  "мл")
    println(water.getDrinkName() + " " + water.getDrinkVolume(water) +  "мл")
    println(tea.getDrinkName() + " " + tea.getDrinkVolume(tea) +  "мл")
    println(coffee.getDrinkName() + " " + coffee.getDrinkVolume(coffee) +  "мл")
}
