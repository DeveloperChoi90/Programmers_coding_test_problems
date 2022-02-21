import java.util.*;

public class Programmers_Reporting{
    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution s = new Solution();
        long start = System.nanoTime();
        int[] ans = s.solution(id_list, report, k);
        long end = System.nanoTime();
        for(int i : ans) {
            System.out.println(i);
        }
        System.out.println("수행시간" + (end - start) + "ns");
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> list = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            index.put(id_list[i], i);
        }

        for(String repo : report){
            String[] ids = repo.split(" ");
            String from_id = ids[0], to_id = ids[1];
            if(!list.containsKey(to_id)) list.put(to_id, new ArrayList<>());
            List<Integer> tmp = list.get(to_id);
            if(!tmp.contains(index.get(from_id))) tmp.add(index.get(from_id));
        }

        for(int i = 0; i < id_list.length; i++){
            String id = id_list[i];
            if(list.containsKey(id) && list.get(id).size() >= k) {
                for(int idx : list.get(id)){
                    answer[idx]++;
                }
            }
        }
        return answer;
    }
}