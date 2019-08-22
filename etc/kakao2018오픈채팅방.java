import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
       private static class Node {
        String uid;
        int flag;
        Node(String uid,int flag) {
            this.uid = uid;
            this.flag = flag;
        }
    }

    public String[] solution(String[] record) {
        int N = record.length;
        int length = 0;
        List<Node> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<N;++i) {
            String[] temp = record[i].split(" ");
            switch (temp[0]) {
                case "Enter":
                    enterUser(temp[1],temp[2],map);
                    list.add(new Node(temp[1],1));
                    length++;
                    break;
                case "Leave" :
                    list.add(new Node(temp[1],2));
                    length++;
                    break;
                case "Change" :
                    changeUser(temp[1],temp[2],map);
                    break;
            }
        }
        String[] answer = new String[length];

        for(int i=0;i<list.size();++i) {
            StringBuilder sb = new StringBuilder();
            Node temp = list.get(i);
            sb.append(map.get(temp.uid)+ "님이 ");
            if(temp.flag == 1) {
                sb.append("들어왔습니다.");
            }else {
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private void changeUser(String uid, String name, HashMap<String, String> map) {
        map.put(uid,name);
    }

    private void enterUser(String uid, String name,HashMap<String,String> map) {
        map.put(uid,name);
    }
}
