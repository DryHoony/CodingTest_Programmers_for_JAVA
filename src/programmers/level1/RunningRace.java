package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    // https://school.programmers.co.kr/learn/courses/30/lessons/178871/solution_groups?language=java
    // '리스트' 를 이용해 검색-호환(추월) 으로 구현한 것과 속도 차이가 얼마나 날까?

//    public static void main(String[] args) {
//        String[] players = {"mumu", "soe", "poe", "kai", "mine"}; // 초기위치, 5~50,000
//        String[] callings = {"kai", "kai", "mine", "mine"}; // 추월, 2~1,000,000
//
//        // Map<name, rank> - rank 값으로 검색할 수 없어 사용불가.
//        // '추월' 할 때마다 매번 등수 업데이트(앞, 뒤 사람)
//        // '이름'과 '등수'를 각각 key로 가지는 Map을 두개 활용 - 추월시 매번 업데이트
//
//        Map<String, Integer> nameMap = new HashMap(); // '이름'에 따른 등수
//        Map<Integer, String> rankMap = new HashMap<>(); // '등수'에 따른 이름
//
//        for (int i = 0; i < players.length; i++) {
//            nameMap.put(players[i], i+1);
//            rankMap.put(i+1, players[i]);
//        }
//        // 초기값
//
//        // 연산
//        for (String callPlayer:callings){
//            overtaking(nameMap, rankMap, callPlayer); // 추월
//        }
//
//        String[] result = new String[players.length];
//        for (int i = 0; i < players.length; i++) {
//            result[i] = rankMap.get(i+1);
//            System.out.println(rankMap.get(i+1)); // 확인출력용
//        }
//
////        System.out.println("result = " + result);
//
//
//    }

    private static void overtaking(Map<String, Integer> nameMap, Map<Integer, String> rankMap, String upPlayer) {
        Integer rank = nameMap.get(upPlayer)-1; // 추월한 등수, 낮은숫자 == 높은등수
        nameMap.put(upPlayer, rank); // nameMap up

        String downPlayer = rankMap.get(rank);
        nameMap.put(downPlayer, rank+1); // nameMap down

        rankMap.put(rank, upPlayer); // rankMap up
        rankMap.put(rank+1, downPlayer); // rankMap down
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"}; // 초기위치, 5~50,000
        String[] callings = {"kai", "kai", "mine", "mine"}; // 추월, 2~1,000,000

        Map<String, Integer> nameRank = new HashMap<>();
        for (int i = 0; i < players.length; i++) { // 초기화
            nameRank.put(players[i], i);
        }

        for(String call:callings){
            int rank = nameRank.get(call);
            players[rank] = players[rank-1]; // 추월당한 사람
            players[rank-1] = call; // 추월한 사람

            nameRank.put(players[rank], nameRank.get(players[rank])+1); // 추월당한 사람 순위
            nameRank.put(call, nameRank.get(call)-1); // 추월한 사람 순위
        }

//        System.out.println(players);
        for (String s:players){
            System.out.println(s);
        }

    }

}
