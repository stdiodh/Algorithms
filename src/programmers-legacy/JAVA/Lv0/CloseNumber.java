package Programmers.JAVA.Lv0;

public class CloseNumber {
    public int solution(int[] array, int n){
        int answer = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i < array.length; i++){
            int num = array[i];
            int diff = Math.abs(n - num);

            if(minDiff > diff){
                minDiff = diff;
                answer = num;
            } else if(minDiff == diff){
                answer = Math.min(array[i-1], num);
            }
        }
        return answer;
    }
    public static void main(){
        CloseNumber m = new CloseNumber();
        int[] arr = {10, 11, 12};
        int n = 20;
        System.out.println(m.solution(arr, n));
    }
}