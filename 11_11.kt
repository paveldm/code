class Product(val name: String, val price: Double)

class Order {
    var products: MutableList<Product> = mutableListOf()
    var status: String = "В обработке"
    var totalCost: Double = 0.0

    fun initializeOrder(init: Order.() -> Unit): Order {
        this.init()
        return this
    }
}

fun main() {
    // Пример использования
    val order = Order().initializeOrder {
        products.add(Product("Товар 1", 100.0))
        products.add(Product("Товар 2", 50.0))
        calculateTotalCost()
        processOrder()
    }

    println("Статус заказа: ${order.status}")
    println("Общая стоимость заказа: ${order.totalCost}")
}

fun Order.calculateTotalCost() {
    totalCost = products.sumByDouble { it.price }
}

fun Order.processOrder() {
    // Логика обработки заказа, например, установка статуса "Обработан"
    status = "Обработан"
}