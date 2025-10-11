import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] spell, String[] dic) {
        String sortedSpell = Arrays.stream(spell)
                                     .sorted()
                                     .collect(Collectors.joining());

        for (String word : dic) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (sortedSpell.equals(sortedWord)) {
                return 1;
            }
        }
        return 2;
    }
}