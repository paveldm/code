package pr2

fun main(){
    val N: Int = readLine().orEmpty().toInt()
    val arr : Array<Double>
    arr = Array(N,{0.0})
    for (i in 0..N-1){
        arr[i] = readLine().orEmpty().toDouble()
    }
    val avg = arr.average()
    println(avg)
}
