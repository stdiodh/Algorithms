import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
        }

        ArrayList<Character> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for(Character key : sortedKeys) {
            if (map.get(key) == 1) {
                answer.append(key);
            }
        }

        return answer.toString();
    }
}