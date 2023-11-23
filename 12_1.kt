abstract class Transport(val name: String, val maxSpeed: Int)
class Car(name: String, maxSpeed: Int) : Transport(name, maxSpeed)
class Bicycle(name: String, maxSpeed: Int) : Transport(name, maxSpeed)
class Boat(name: String, maxSpeed: Int) : Transport(name, maxSpeed)
fun List<Transport>.filterByMaxSpeed(maxSpeed: Int): List<Transport> {
    return this.filter { it.maxSpeed <= maxSpeed }
}
fun List<Transport>.printInfo() {
    this.forEach { println(it.name + " " + it.maxSpeed) }
}
fun main() {
    val vehicles = listOf(
        Car("Car1", 200),
        Bicycle("Bicycle1", 30),
        Boat("Boat1", 50),
        Car("Car2", 180),
        Bicycle("Bicycle2", 25),
        Boat("Boat2", 40)
    )
    val filteredVehicles = vehicles.filterByMaxSpeed(100)
    filteredVehicles.printInfo()
}