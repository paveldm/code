fun main(){
    val colorsAndIntensity: Map<String, Int> = mapOf("Красный" to 120, "Синий" to 85, "Зеленый" to 74, "Желтый" to 99, "Фиолетовый" to 66)
    colorsAndIntensity.forEach { (color, intensity) -> println(color + ":" + intensity) }
}
