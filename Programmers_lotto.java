import java.util.*;

public class Programmers_lotto {
    public static void main(String[] args) {
        int[] lottos = {21, 2, 1, 11, 33, 44};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        Solution2 sol = new Solution2(lottos, win_nums);
        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));
    }
}

class Solution2 {
    protected int[] lottos;
    protected int[] win_nums;

    public Solution2(int[] lottos, int[] win_nums){
        this.lottos = lottos;
        this.win_nums = win_nums;
    }

    public int[] solution(int[] lottos, int[] win_nums) { // 최대등수, 최소등수를 값을 배열에 담아 리턴
        List<Integer> right_nums = new ArrayList<>();
        Map<Integer, Integer> win = new HashMap<>();

        for(int i = 0; i < win_nums.length + 1; i++){
            if(i == 0 || i == 1) win.put(i, 6);
            else win.put(i, 7 - i);
        }
        int cnt = 0;
        for(int num : lottos){
            if(num == 0) cnt++;
        }
        for(int i = 0; i < win_nums.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) right_nums.add(lottos[i]);
            }
        }
        int[] ans = {0, 0};
        if(right_nums.size() == 0 && lottos[0] == 0){
            ans[0] = win.get(6);
            ans[1] = win.get(0);
        }
        else if(right_nums.size() == 0){
            ans[0] = win.get(0);
            ans[1] = win.get(0);
        }
        else {
            ans[0] = win.get(cnt + right_nums.size());
            ans[1] = win.get(right_nums.size());
        }

        return ans;
    }
}
