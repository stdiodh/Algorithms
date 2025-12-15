import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> solution(String[] quiz) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < quiz.length; i++) {
            String[] formula = quiz[i].split(" ");
            int x = Integer.parseInt(formula[0]);
            String operator = formula[1];
            int y = Integer.parseInt(formula[2]);
            int result = Integer.parseInt(formula[4]);

            if (operator.equals("+")) {
                if (x + y == result) {
                    answer.add("O");
                    continue;
                }
                answer.add("X");
            }

            if (operator.equals("-")) {
                if (x - y == result) {
                    answer.add("O");
                    continue;
                }
                answer.add("X");
            }
        }

        return answer;
    }
}