package Programmers.JAVA.Lv0;

import java.util.*;

public class CombineString {
    public int solution(String[] strArr) {
        Map<Integer, Integer> lengthCountMap = new HashMap<>();

        for(String word: strArr){
            int length = word.length();
            int count = lengthCountMap.getOrDefault(length, 0);
            lengthCountMap.put(length, count+1);
        }

        if(lengthCountMap.isEmpty()){
            return 0;
        }
        return Collections.max(lengthCountMap.values());
    }
}
