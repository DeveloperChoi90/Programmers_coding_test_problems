package Programmers_coding_test;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class test2 {
    public String[] solution(String[] records) {
        String[] answer = {};
        Queue<String> notice_name_que = new LinkedList<>();
        Queue<String> notice_msg_que = new LinkedList<>();
        Queue<String> store_stack = new LinkedList<>();

        for(String str : records){
            String[] alarm = str.split(" ");
            String name = alarm[0], msg = alarm[1];
            notice_name_que.offer(name);
            notice_msg_que.offer(msg);
        }

        while(!notice_msg_que.isEmpty()){
            int cnt = get_same_msg(notice_msg_que);
            if(){}
            if(cnt > 1){
                for(int i = 0; i < cnt; i++){
                    String[] name = notice_name_que.poll();
                    String[] msg = notice_msg_que.poll();
                }
            }
            String name = notice_name_que.poll();
            String msg = notice_msg_que.poll();


        }
        return answer;
    }

    public int get_same_msg(Queue<String> alarm){
        String[] notice = alarm.toArray(new String[alarm.size()]);
        int cnt = 1;

        for(int i = 0; i < alarm.size() - 1; i++){
            if(notice[i] == notice[i+1]) cnt++;
            else break;
        }
        return cnt;
    }
}