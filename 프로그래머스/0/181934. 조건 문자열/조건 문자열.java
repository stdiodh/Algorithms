import java.util.Objects;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if(Objects.equals(ineq, "<") && Objects.equals(eq, "=")){
            if(n <= m){
                answer = 1;
            }
        }
        if(Objects.equals(ineq, ">") && Objects.equals(eq, "=")){
            if(n >= m){
                answer = 1;
            }
        }
        
         if(Objects.equals(ineq, "<") && Objects.equals(eq, "!")){
            if(n < m){
                answer = 1;
            }
        }
            
        if(Objects.equals(ineq, ">") && Objects.equals(eq, "!")){
            if(n > m){
                answer = 1;
            }
        }
        return answer;
    }
}