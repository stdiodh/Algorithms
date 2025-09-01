package Programmers.JAVA.Lv0;

import java.util.*;

public class CharOnlyOnce {
    public String solution(String s) {
        String answer = "";
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(charMap.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(char c : keys){
            if(charMap.get(c) == 1){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
