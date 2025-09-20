import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        switch (n) {
            case 1:
                answer = Arrays.copyOfRange(num_list, 0, b + 1);
                break;
            case 2:
                answer = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3:
                answer = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4:
                List<Integer> tempList = new ArrayList<>();
                for (int i = a; i <= b; i += c) {
                    tempList.add(num_list[i]);
                }
                answer = tempList.stream().mapToInt(Integer::intValue).toArray();
                break;
        }

        return answer;
    }
}