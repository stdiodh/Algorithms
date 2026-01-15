package Programmers.JAVA.Lv0;

public class Factorial {
    public int solution(int n){
        int cnt = 1;
        int answer = 1;
        while(true) {
            answer *= cnt;
            if (answer > n) {
                break;
            }
            cnt++;
        }
        cnt--;
        return cnt;
    }
    public static void main(String[] args){
        Factorial m = new Factorial();
        int n = 3628800;
        System.out.println(m.solution(n));

    }
}
