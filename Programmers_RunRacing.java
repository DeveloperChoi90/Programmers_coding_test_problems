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

    public String[] sol(String[] players, String[] callings) {
        RacingNode root = new RacingNode(), node = root;
        HashMap<String, RacingNode> map = new HashMap<>();

        for (String player : players) {
            node.next = new RacingNode(player, node);
            node = node.next;
            map.put(player, node);
        }

        RacingNode[] arr = new RacingNode[4];  // 왜 4?

        for (String call : callings) {
            RacingNode runner = map.get(call);
            arr[0] = runner.prev.prev;
            arr[1] = runner;
            arr[2] = runner.prev;
            arr[3] = runner.next;

            arr[0].next = arr[1];
            arr[1].next = arr[2];
            arr[2].next = arr[3];

            arr[1].prev = arr[0];
            arr[2].prev = arr[1];
            if (arr[3] != null) {
                arr[3].prev = arr[2];
            }
        }

        int idx = 0;
        root = root.next;

        while (root != null) {
            players[idx++] = root.name;
            root = root.next;
        }
        return players;
    }
}

class RacingNode {

    RacingNode prev, next;
    String name;

    RacingNode() {
    }

    RacingNode(String name) {
        this.name = name;
    }

    RacingNode(String name, RacingNode prev) {
        this(name);
        this.prev = prev;
    }
}

