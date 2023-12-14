package pr1
fun main() {
    var arr: Array<Int> = arrayOf(0, 0, 0, 0)
    var S:String = "ATGCCTCTCTC"
    for (i in S){
        if (i == 'A'){
            arr[0] += 1
        }
        if (i == 'T'){
            arr[1] += 1
        }
        if (i == 'G'){
            arr[2] += 1
        }
        if (i == 'C'){
            arr[3] += 1
        }
    }
    for (i in arr){
        print("$i ")
    }
}
