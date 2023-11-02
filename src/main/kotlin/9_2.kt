class BestRepairEver {
    fun canRepair(device: String): Boolean {
        return device == "компьютер" || device == "телефон"
    }
}

fun main() {
    val workshop = BestRepairEver()

    println(workshop.canRepair("компьютер")) // true
    println(workshop.canRepair("телефон")) // true
    println(workshop.canRepair("телевизор")) // false
}