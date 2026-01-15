package Programmers.JAVA.Lv0;

import java.util.Arrays;
import java.util.Stack;

public class CtrlZ {
    public int solution(String s){
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split(" ");
        stack.addAll(Arrays.asList(arr));

        for(int i=0; i < arr.length; i++){
            if(stack.isEmpty()){
                break;
            }
            String now = stack.pop();
            if(now.equals("Z")){
                stack.pop();
            } else {
                int nowToInt = Integer.parseInt(now);
                answer += nowToInt;
            }
        }
        return answer;
    }

    public static void main(){
        CtrlZ s = new CtrlZ();
        String sentence = "1 2 Z 3";
        System.out.println(s.solution(sentence));
    }
}
