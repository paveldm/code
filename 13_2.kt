import java.util.*
import kotlin.random.Random

class Dish(val name: String, val price: Double, val weight: Double) {
    // возможно, здесь могут быть и другие характеристики блюда
}

class Order(val customer: Customer) {
    val orderItems = mutableMapOf<Dish, Int>()

    fun addDish(dish: Dish, quantity: Int) {
        orderItems[dish] = quantity
    }

    fun getTotalCost(): Double {
        var totalCost = 0.0
        for ((dish, quantity) in orderItems) {
            totalCost += dish.price * quantity
        }
        return totalCost
    }
}

class Customer(val id: Int, val name: String, val contactInfo: String) {
    // дополнительные свойства о клиенте
}

class Restaurant {
    val menu = mutableListOf<Dish>()
    val customers = mutableSetOf<Customer>()
    val orders = mutableMapOf<Int, Order>() // идентификатор заказа -> заказ

    fun addDishToMenu(dish: Dish) {
        menu.add(dish)
    }

    fun createOrder(customer: Customer): Int {
        val orderId = (1..1000).random(Random(System.nanoTime()))
        val order = Order(customer)
        orders[orderId] = order
        return orderId
    }

    fun addDishToOrder(orderId: Int, dish: Dish, quantity: Int) {
        val order = orders[orderId]
        order?.addDish(dish, quantity)
    }

    // Дополнительные функции для просмотра информации о заказах, клиентах и меню
}

fun main() {
    val restaurant = Restaurant()

    // Добавление блюд в меню
    val dish1 = Dish("Пицца Маргарита", 12.0, 0.7)
    val dish2 = Dish("Борщ", 8.5, 0.4)
    val dish3 = Dish("Стейк", 25.0, 0.5)
    restaurant.addDishToMenu(dish1)
    restaurant.addDishToMenu(dish2)
    restaurant.addDishToMenu(dish3)

    // Создание клиентов
    val customer1 = Customer(1, "Иван", "ivan@example.com")
    val customer2 = Customer(2, "Анна", "anna@example.com")
    restaurant.customers.add(customer1)
    restaurant.customers.add(customer2)

    // Создание заказов
    val orderId1 = restaurant.createOrder(customer1)
    val orderId2 = restaurant.createOrder(customer2)

    // Добавление блюд в заказы
    restaurant.addDishToOrder(orderId1, dish1, 2)
    restaurant.addDishToOrder(orderId1, dish3, 1)
    restaurant.addDishToOrder(orderId2, dish2, 4)

    // Вывод информации о заказах, клиентах и меню
    // ...
}
