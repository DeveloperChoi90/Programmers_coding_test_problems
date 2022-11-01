import java.util.HashMap;
import java.util.Map;

public class PersonalityTest {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};
        Solution sol = new Solution();
        System.out.println(sol.solution(survey, choice));
    }

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            Map<Character, Integer> map = new HashMap<>();

            for (int i=0; i<survey.length; i++) {
                int val = choices[i];

                if( val > 0 && val < 4) {
                    char ch = survey[i].charAt(0);
                    map.put(ch, map.getOrDefault(ch, 0) + 4 - val);
                } else if (val > 4) {
                    char ch = survey[i].charAt(1);
                    map.put(ch, map.getOrDefault(ch, 0) + val - 4);
                }
            }

            return String.valueOf(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T') +
                    (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F') +
                    (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M') +
                    (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        }
    }
}

