fun updatePrice (productsMap: MutableMap<String, Double>, product: String, newPrice: Double) {
    if (productsMap.containsKey(product)) {
        productsMap[product] = newPrice
    } else {
        println("Товар не найден")
    }
}
fun main(){
    val productsMap = mutableMapOf<String, Double>()
    productsMap["Товар1"] = 100.0
    productsMap["Товар2"] = 150.0
    productsMap["Товар3"] = 200.0
    println("Список товаров")
    productsMap.forEach { (product, price) -> println(product + ": " + price) }
    updatePrice(productsMap,"Товар2", 1200000.0)
    println("Обновленный список")
    productsMap.forEach { (product, price) -> println(product + ": " + price) }
}
