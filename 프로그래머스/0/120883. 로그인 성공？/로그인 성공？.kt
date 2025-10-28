class Solution {
    fun findDB(find: String, dbData: String) : Boolean {
        if(find == dbData) {
            return true
        }
        return false
    }
    
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        var answer: String = ""
        val id = id_pw[0]
        val pw = id_pw[1]
        val dbSize = db.size
        
        var idFlag = false
        var pwFlag = false
        
        repeat(dbSize) { i ->
            idFlag = findDB(id, db[i][0])
            pwFlag = findDB(pw, db[i][1])
            
            if(idFlag && pwFlag) {
                answer = "login"
                return@repeat
            } else if(idFlag || pwFlag) {
                answer = "wrong pw"
                return@repeat
            } else {
                answer = "fail"
            }
        }
        
        return answer
    }
}