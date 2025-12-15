class Solution {
    public int[] solution(int[][] score) {
        int[] totalScores = new int[score.length];
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = 1;
            totalScores[i] = score[i][0] + score[i][1];
        }

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (totalScores[i] < totalScores[j]) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}