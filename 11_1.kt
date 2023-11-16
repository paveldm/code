class Product(val name: String, val price: Double)

class Order {
    var products = mutableListOf<Product>()
    var status = "В обработке"
    var discount = 0.0

    fun initializeOrder(init: Order.() -> Unit) {
        init()
    }

    fun processOrder() {
        // Обработка заказа
        status = "Обработан"
    }

    fun calculateDiscount() {
        // Расчет скидки на основе суммы заказа
        discount = if (products.sumByDouble { it.price } > 500) {
            0.1
        } else {
            0.0
        }
    }

    override fun toString(): String {
        return "Order(products=$products, status='$status', discount=$discount)"
    }
}

fun main() {
    val order = Order()

    order.initializeOrder {
        products.add(Product("Product 1", 100.0))
        products.add(Product("Product 2", 200.0))
        products.add(Product("Product 3", 300.0))
        calculateDiscount()
        processOrder()
    }

    println(order)
}