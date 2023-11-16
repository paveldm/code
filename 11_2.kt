// Определение класса товара
class Product<T>(val name: String, val price: Double, val description: String) {
    override fun toString(): String {
        return "Product(name='$name', price=$price, description='$description')"
    }
}

// Определение класса каталога
class Catalog<T> {
    private val products = mutableListOf<Product<T>>()

    // Функция добавления товара в каталог
    fun addProduct(product: Product<T>) {
        products.add(product)
    }

    // Функция вывода информации о всех товарах
    fun displayProducts() {
        for (product in products) {
            println(product)
        }
    }

    // Функция поиска товара по названию
    fun searchProductByName(name: String): Product<T>? {
        for (product in products) {
            if (product.name == name) {
                return product
            }
        }
        return null
    }

    // Функция фильтрации товаров по цене
    fun filterByPrice(minPrice: Double, maxPrice: Double): List<Product<T>> {
        return products.filter { product -> product.price in minPrice..maxPrice }
    }
}

// Функция покупки товара
fun <T> purchase(catalog: Catalog<T>, productName: String): String {
    val product = catalog.searchProductByName(productName)
    return if (product != null) {
        "Покупка товара: $product"
    } else {
        "Товар не найден"
    }
}

// Пример использования
fun main() {
    // Создание экземпляра каталога товаров
    val catalog = Catalog<String>()

    // Добавление товаров в каталог
    catalog.addProduct(Product("Телефон", 100.0, "Смартфон Samsung"))
    catalog.addProduct(Product("Ноутбук", 500.0, "Ноутбук Lenovo"))
    catalog.addProduct(Product("Футболка", 20.0, "Футболка Adidas"))

    // Вывод информации о всех товарах
    catalog.displayProducts()

    // Поиск товара по названию
    val product = catalog.searchProductByName("Телефон")
    println("Поиск товара: $product")

    // Фильтрация товаров по цене
    val filteredProducts = catalog.filterByPrice(50.0, 200.0)
    println("Фильтрация товаров:")
    for (filteredProduct in filteredProducts) {
        println(filteredProduct)
    }

    // Покупка товара
    val purchaseResult = purchase(catalog, "Ноутбук")
    println(purchaseResult)
}