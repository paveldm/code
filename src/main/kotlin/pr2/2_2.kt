package pr2
fun main(){
    val N: Int = readLine().orEmpty().toInt()
    val arr : Array<Int>
    arr = Array(N,{0})
    for (i in 0..N-1){
        arr[i] = readLine().orEmpty().toInt()
    }
    val map = mutableMapOf<Int,Int>()
    for (i in arr){
        if (map.containsKey(i)) {
            map += i to map.getValue(i) + 1
        }
        else{
            map[i] = 1
        }
    }
    for(key in map.keys) {
        println("$key: ${map.get(key)}")
    }
}
