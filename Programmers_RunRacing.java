import java.util.HashMap;
import java.util.Map;

public class Programmers_RunRacing {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> cur_rank = new HashMap<>();
        Map<Integer, String> cur_player = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            cur_rank.put(players[i], i);
            cur_player.put(i, players[i]);
        }
        int tmp_rank = 0;
        String tmp_player = null;
        for (String calling : callings) {
            tmp_rank = cur_rank.get(calling); // 불린 선수의 순위
            tmp_player = cur_player.get(tmp_rank - 1); // 순위 바뀌기전 선수
            cur_rank.put(calling, tmp_rank - 1); // 불린 선수 순위변경
            cur_player.put(tmp_rank - 1, calling); // 불린 선수 순위변경

            cur_rank.put(tmp_player, tmp_rank);
            cur_player.put(tmp_rank, tmp_player);
        }
        return cur_player.values().toArray(new String[0]);
    }
}
