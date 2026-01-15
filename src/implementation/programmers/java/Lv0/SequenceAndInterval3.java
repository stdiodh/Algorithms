package Programmers.JAVA.Lv0;

public class SequenceAndInterval3 {
    public int[] solution(int[] arr, int[][] queries){
        for(int i=0; i < queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            int tmp = 0;
            tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
        return arr;
    }
}
