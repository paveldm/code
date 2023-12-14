package pr1
fun main() {
    var n :Int = readLine()!!.toInt()
    var k8 = n/8
    n = n%8
    var k4 = n/4
    n = n%4
    var k2 = n/2
    n = n%2
    print("$k8 $k4 $k2 $n")
}
