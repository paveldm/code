package pr3
fun game(){
    val M: Int = (0..1000).random()
    var x: Int
    println(M)
    while (true){
        x = readLine().orEmpty().toInt()
        if (x == M){
            return println("Победа!")
        }
        else if (x > M){
            println("Это число больше загаданного.")
        }
        else if (x < M){
            println("Это число меньше загаданного.")
        }
        else if (x < 0){
            break
        }
    }
}
fun main(){
    game()
}
