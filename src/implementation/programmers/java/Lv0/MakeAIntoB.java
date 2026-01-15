package Programmers.JAVA.Lv0;

import java.util.HashMap;

public class MakeAIntoB {
    public int solution(String before, String after) {
        int answer = 0;
        HashMap<Character, Integer> beforeMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> afterMap = new HashMap<Character, Integer>();
        for(int i=0; i<before.length(); i++){
            char c = before.charAt(i);
            beforeMap.put(c, beforeMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<after.length(); i++){
            char c = after.charAt(i);
            afterMap.put(c, afterMap.getOrDefault(c, 0)+1);
        }

        if(beforeMap.equals(afterMap)){
            return 1;
        } else{
            return 0;
        }
    }

    public void main(){
        MakeAIntoB m = new MakeAIntoB();
        System.out.println(m.solution("olleh", "hello"));
    }
}
