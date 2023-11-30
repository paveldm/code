class Dish(val name: String, val price: Double, val weight: Double)
class Order(val customer: Customer, private val menu: Map<String, Dish>) {
    private val dishes: MutableMap<String, Int> = mutableMapOf()

    fun addDish(dishName: String, quantity: Int) {
        val dish = menu[dishName]
        if (dish != null) {
            dishes[dish.name] = dishes.getOrDefault(dish.name, 0) + quantity
        }
    }
    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for ((dishName, quantity) in dishes) {
            val dish = menu[dishName]
            if (dish != null) {
                totalPrice += dish.price * quantity
            }
        }
        return totalPrice
    }
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Заказ (${customer.name}):\n")
        for ((dishName, quantity) in dishes) {
            sb.append("${dishName}: ${quantity}\n")
        }
        sb.append("Общая стоимость: ${getTotalPrice()}")
        return sb.toString()
    }
}
class Customer(val id: Int, val name: String, val contact: String)
class Restaurant {
    private val menu: MutableMap<String, Dish> = mutableMapOf()
    private val customers: MutableSet<Customer> = mutableSetOf()
    private val orders: MutableMap<Int, Order> = mutableMapOf()
    private var orderIdCounter: Int = 1
    fun addDishToMenu(dish: Dish) {
        menu[dish.name] = dish
    }
    fun createOrder(customer: Customer): Int {
        customers.add(customer)
        val order = Order(customer, menu)
        orders[orderIdCounter] = order
        return orderIdCounter++
    }
    fun addDishToOrder(orderId: Int, dishName: String, quantity: Int) {
        val order = orders[orderId]
        if (order != null) {
            order.addDish(dishName, quantity)
        }
    }
    fun printMenu() {
        println("Меню:")
        for ((name, dish) in menu) {
            println("- ${name}: ${dish.price}")
        }
    }
    fun printOrder(orderId: Int) {
        val order = orders[orderId]
        if (order != null) {
            println(order)
        } else {
            println("Заказ не найден")
        }
    }
    fun printCustomers() {
        println("Клиенты:")
        for (customer in customers) {
            println("- ${customer.name} (${customer.contact})")
        }
    }
}
fun main() {
    val restaurant = Restaurant()
    restaurant.addDishToMenu(Dish("Пицца", 10.0, 0.7))
    restaurant.addDishToMenu(Dish("Бургер", 8.0, 0.3))
    restaurant.addDishToMenu(Dish("Салат", 6.0, 0.1))

    val customer1 = Customer(1, "Петр", "89454683069")
    val customer2 = Customer(2, "Иван", "89583642288")
    val orderId1 = restaurant.createOrder(customer1)
    val orderId2 = restaurant.createOrder(customer2)

    restaurant.addDishToOrder(orderId1, "Пицца", 2)
    restaurant.addDishToOrder(orderId1, "Салат", 1)
    restaurant.addDishToOrder(orderId2, "Бургер", 3)

    restaurant.printOrder(orderId1)
    restaurant.printOrder(orderId2)
    restaurant.printCustomers()
    restaurant.printMenu()
}
