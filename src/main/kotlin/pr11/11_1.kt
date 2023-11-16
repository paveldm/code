data class Product3(val name: String, val price: Double)

data class Order3(val products: List<Product3>, val status: String) {
    fun calculateTotalPrice(): Double {
        return products.sumByDouble { it.price }
    }

    fun applyDiscount(discount: Double) {
        val totalPrice = calculateTotalPrice()
        val discountedPrice = totalPrice * (1 - discount)
        println("Цена со скидкой: $discountedPrice")
    }
}

fun main() {
    val product1 = Product3("Продукт 1", 10.0)
    val product2 = Product3("Продукт 2", 20.0)
    val product3 = Product3("Продукт 3", 30.0)
    val order = Order3(listOf(product1, product2, product3), "В процессе")

    order.apply {
        applyDiscount(0.1)
        println("Статус заказа: $status")
    }
}