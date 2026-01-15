package Programmers.JAVA.Lv0;

import java.util.ArrayList;

public class SliceArray {
    public ArrayList<String> solution(String my_str, int n){
        ArrayList<String> result = new ArrayList();
        for(int i=0; i < my_str.length(); i+=n){
            int endIndex = Math.min(i+n, my_str.length());
            String sub = my_str.substring(i, endIndex);
            result.add(sub);
        }

        return result;
    }

    public static void main(){
        SliceArray m = new SliceArray();
        System.out.println(m.solution("abc1Addfggg4556b", 6));
    }
}
