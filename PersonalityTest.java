import java.util.ArrayList;
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

                char ch = survey[i].charAt(0);
                if( val > 0 && val < 4) {
                    map.put(ch, map.getOrDefault(ch, 0) + 4 - val);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) + val - 4);
                }
            }

            return String.valueOf(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T') +
                    (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F') +
                    (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M') +
                    (map.getOrDefault('A', 0) >= map.getOrDefault('A', 0) ? "A" : 'N');
        }
    }
}

