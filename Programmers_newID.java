import java.util.Locale;

public class Programmers_newID {
    public static void main(String[] args) {
        String[] new_id = new String[] {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        Solution sol = new Solution();
        for (String id : new_id) {
            System.out.println(sol.solution(id));
        }
    }

    public static class Solution {
        public String solution(String new_id) {
            StringBuilder answer = new StringBuilder(new_id);
            // 1단계
            answer = new StringBuilder(answer.toString().toLowerCase());
            // 2단계
            answer = new StringBuilder(answer.toString().replaceAll("[^-_.a-z0-9]", ""));
            // 3단계
            answer = new StringBuilder(answer.toString().replaceAll("[.]{2,}", "."));
            // 4단계
            answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));
            // 5단계
            if(answer.toString().equals("")) {
                answer.append("a");
            }
            // 6단계
            if(answer.length() >= 16) {
                answer = new StringBuilder(answer.substring(0, 15));
                if(answer.charAt(14) == '.') {
                    answer = new StringBuilder(answer.toString().replaceAll("[.]$", ""));
                }
            }
            // 7단계
            if(answer.length() <= 2) {
                while (answer.length() < 3) {
                    answer.append(answer.charAt(answer.length() - 1));
                }
            }
            return answer.toString();
        }
    }
}
