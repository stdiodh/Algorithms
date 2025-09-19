import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) { 
        int pow = 1;
        
        while(pow < arr.length){
            pow *= 2;
        }
        
        int[] answer = new int[pow];
        
        System.arraycopy(arr, 0, answer, 0, arr.length);
        
        return answer;
    }
}