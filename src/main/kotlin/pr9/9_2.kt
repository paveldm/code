package pr9

interface Device {
    fun isRepairable(): Boolean
}
abstract class RepairShop {
    abstract fun repair(device: Device): Boolean
}
class BestRepairEver : RepairShop() {
    override fun repair(device: Device): Boolean {
        return device.isRepairable()
    }
}
class Computer : Device {
    override fun isRepairable(): Boolean {
        return true
    }
}
class Phone : Device {
    override fun isRepairable(): Boolean {
        return false
    }
}
fun main() {
    val repairShop = BestRepairEver()
    val computer = Computer()
    val phone = Phone()
    println("Мастерская сможет починить компьютер - ${repairShop.repair(computer)}")
    println("Мастерская сможет починить телефон - ${repairShop.repair(phone)}")
}