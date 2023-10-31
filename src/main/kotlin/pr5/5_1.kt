package pr5
import kotlin.random.Random

class Cat {
    private fun sleep() {
        println("Sleep")
    }
    private fun meow() {
        println("Meow")
    }
    private fun eat() {
        println("Eat")
    }
    fun status() {
        val randomNumber = Random.nextInt(1, 4)
        when (randomNumber) {
            1 -> sleep()
            2 -> meow()
            3 -> eat()
        }
    }
}
fun main() {
    val cat = Cat()
    cat.status()
}