package pr2
fun main(){
    val N: Int = readLine().orEmpty().toInt()
    val arr : Array<String>
    arr = Array(N,{""})
    for (i in 0..N-1) {
        arr[i] = readLine().orEmpty()
    }
    for (i in  0..N-2){
        for (j in i+1..N-1){
            if (arr[i] == arr[j]) {
                println(arr[i])
                return
            }
        }
    }
}
