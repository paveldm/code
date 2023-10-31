package pr6

class TimeUnit {
    private var hours: Int
    private var minutes: Int
    private var seconds: Int

    constructor(hours: Int, minutes: Int, seconds: Int) {
        this.hours = hours
        this.minutes = minutes
        this.seconds = seconds
    }
    constructor(hours: Int, minutes: Int) : this(hours, minutes, 0)
    constructor(hours: Int) : this(hours, 0)

    fun format24() {
        println(String.format("%02d:%02d:%02d", hours, minutes, seconds))
    }

    fun format12() {
        val amPm = if (hours >= 12) "pm" else "am"
        val hour12 = if (hours % 12 == 0) 12 else hours % 12
        println(String.format("%02d:%02d:%02d $amPm", hour12, minutes, seconds))
    }

    fun addTime(hours: Int, minutes: Int, seconds: Int) {
        this.hours += hours
        this.minutes += minutes
        this.seconds += seconds
        if (this.seconds >= 60) {
            this.minutes += this.seconds / 60
            this.seconds %= 60
        }
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60
            this.minutes %= 60
        }
        this.hours %= 24

    }
}
fun main() {
    val time1 = TimeUnit(15, 30, 45)

    println("Время в 24-часовом формате (15:30:45):")
    time1.format24()

    println("То же время в 12-часовом формате:")
    time1.format12()

    println("Добавление переданного времени к установленному в TimeUnit (+02:30:15):")
    time1.addTime(2, 30, 15)
    time1.format24()
}