import java.util.HashMap;

class Solution {
    public int solution(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int maxCount = 0;
        int answer = 0;

        for (int key : map.keySet()) {
            int count = map.get(key);

            if (maxCount < count) {
                maxCount = count;
                answer = key;
            } else if (maxCount == count) {
                answer = -1;
            }
        }

        return answer;
    }
}
