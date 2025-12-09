fun main(){
    val fileNames = mutableListOf<String>()
    var str = ""

    val n = readln().toInt()
    repeat(n){
        fileNames.add(readln())
    }

    val nameLength = fileNames[0].length

    for(x in 0..<nameLength){
        var flag = true
        val target = fileNames[0][x]
        for(y in 1..<n){
            if(target != fileNames[y][x]){
                flag = false
                break
            }
        }
        str += if(flag) target
        else "?"
    }
    println(str)
}