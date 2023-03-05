package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccusationResult { // 신고결과 받기, 카카오 기출 https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java

    public static ArrayList<String> overlapRemove(String[] list){
        ArrayList<String> answer = new ArrayList<>();
        for(String str:list){
            if(!answer.contains(str)) answer.add(str);
        }
        return answer;
    }

    public static String[] listTransform(ArrayList<String> list){
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"}; // 여러번 신고한 케이스 중복제거!!
        report = listTransform(overlapRemove(report)); //중복제거!
        int k = 3;


        // Map - <id,count>
        Map<String, Integer> map = new HashMap<>();
        for (String i:id_list){ // 초기화
            map.put(i,0);
        }

        String id="";
        // map 연산 - report에 신고받는사람 횟수 map에 추가
        for (String r:report){
            id = r.split(" ")[1]; // 신고받은 id
            map.put(id,map.get(id) + 1);
        }

        // map 에서 value가 k이상인 유저는 신고리스트!
        List<String> accusationList = new ArrayList<>();
        for (String i:id_list){
            if(map.get(i)>=k) accusationList.add(i);
        }

        map.clear(); // 메일받은 횟수로 재활용
        for (String i:id_list){ // 초기화
            map.put(i,0);
        }

        // 신고 당한 유저 반복문 - 신고한 유저에게 메일 횟수 ++ (answer에 해당하는 index에 ++)
        for(String r:report){
            id = r.split(" ")[1]; // 신고받은 id
            if (accusationList.contains(id)){ //정지이면 신고한 유저 메일 count++
                id = r.split(" ")[0]; //신고한 id
                map.put(id, map.get(id)+1); // 0일때 확인
            }
        }

        int[] answer = new int[id_list.length]; // 각 유저별 메일받은 횟수
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = map.get(id_list[i]);
        }

        // 완성 - 확인
        for (int i:answer){
            System.out.println(i);
        }













    }

}
