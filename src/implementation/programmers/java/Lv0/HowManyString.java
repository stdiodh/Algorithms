package Programmers.JAVA.Lv0;

public class HowManyString {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i <= myString.length()-pat.length(); i++){
            String target = myString.substring(i, i+pat.length());
            if(target.equals(pat)){
                answer++;
            }
        }
        return answer;
    }
}
