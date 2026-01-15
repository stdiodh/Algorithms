package Programmers.JAVA.Lv0;

public class MakeIt2D {
    public int[][] solution(int[] num_list, int n) {
        int rows = num_list.length / n;
        int[][] answer = new int[rows][n];
        for(int i=0; i < num_list.length; i++){
            answer[i / n][i % n] = num_list[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        MakeIt2D m = new MakeIt2D();
        int[] num_list = {1, 2, 3, 4, 5, 6};
        int n = 2;

        int[][] result = m.solution(num_list, n);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        // 출력:
        // 1 2
        // 3 4
        // 5 6
    }
}