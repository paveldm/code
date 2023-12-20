package pr9
abstract class Animal {
    abstract val name: String
    abstract val wayOfBirth: String
    fun eat() {
        println("$name ест")
    }
    fun sleep() {
        println("$name спит")
    }
}
interface Flying {
    fun fly()
}
interface Swimming {
    fun swim()
}
class Bat : Animal(), Flying {
    override val name: String = "Летучая мышь"
    override val wayOfBirth: String = "Рождается"
    override fun fly() {
        println("$name летает медленно")
    }
}
class Dolphin : Animal(), Swimming {
    override val name: String = "Дельфин"
    override val wayOfBirth: String = "Рождается"
    override fun swim() {
        println("$name плавает быстро")
    }
}
class GoldFish : Animal(), Swimming {
    override val name: String = "Золотая рыбка"
    override val wayOfBirth: String = "Мечет икру"
    override fun swim() {
        println("$name плавает медленно")
    }
}
class Eagle : Animal(), Flying {
    override val name: String = "Орел"
    override val wayOfBirth: String = "Откладывает яйца"
    override fun fly() {
        println("$name летает быстро")
    }
}
fun main() {
    val bat = Bat()
    bat.eat()
    bat.sleep()
    bat.fly()
    val dolphin = Dolphin()
    dolphin.eat()
    dolphin.sleep()
    dolphin.swim()
    val goldFish = GoldFish()
    goldFish.eat()
    goldFish.sleep()
    goldFish.swim()
    val eagle = Eagle()
    eagle.eat()
    eagle.sleep()
    eagle.fly()
}
