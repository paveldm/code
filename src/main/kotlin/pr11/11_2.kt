class Product2<T>(val name: String, val price: Double, val description: String, val category: T)
class Catalog<T> {
    private val products: MutableList<Product2<T>> = mutableListOf()
    fun addProduct(product: Product2<T>) {
        products.add(product)
    }
    fun displayProducts() {
        for (product in products) {
            println("Название: ${product.name}, Цена: ${product.price}, Описание: ${product.description}, Категория: ${product.category}")
        }
    }
    fun findProductByName(name: String): Product2<T>? {
        return products.find { it.name == name }
    }
    fun filterByPrice(minPrice: Double, maxPrice: Double): List<Product2<T>> {
        return products.filter { it.price in minPrice..maxPrice }
    }
}
fun <T> purchase(catalog: Catalog<T>, productName: String): String {
    val product = catalog.findProductByName(productName)
    return if (product != null) {
        "Покупка завершена"
    } else {
        "Товар не найден"
    }
}
fun main() {
    val electronicsCatalog = Catalog<String>()
    val laptop = Product2("Ноутбук", 1500.0, "Игровой", "Электроника")
    val smartphone = Product2("Смартфон", 800.0, "256 Гб", "Электроника")
    electronicsCatalog.addProduct(laptop)
    electronicsCatalog.addProduct(smartphone)
    println("Товары из категории \"Электроника\":")
    electronicsCatalog.displayProducts()
    val purchaseResult = purchase(electronicsCatalog, "Смартфон")
    println(purchaseResult)
    val filteredProducts = electronicsCatalog.filterByPrice(700.0, 1200.0)
    println("Фильтрация по цене:")
    for (product in filteredProducts) {
        println("Название: ${product.name}, Цена: ${product.price}, Категория: ${product.category}")
    }
}
