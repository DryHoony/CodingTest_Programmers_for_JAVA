package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TravelPath { // 여행경로

    public static void main0(String[] args) { // 2/4 - 실패(런타임 에러)
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // 공항의 수 3~10000, 항공권 모두 사용, 경로2개 이상일 경우 알파벳 순서로 경로 선택
        // 경로가 존재한다면 순서는 (알파벳으로) 정해져있다.

        // 연산용 변수
        int l = tickets.length;
        String[] path = new String[l+1];
        path[0] = "ICN";

        // 연결 리스트 Map<String, List>
        Map<String, ArrayList<String>> adjMap = new HashMap<>();
        for (String[] ticket:tickets){
            if(!adjMap.containsKey(ticket[0])){
                // 출발지 없으면 초기화
                adjMap.put(ticket[0], new ArrayList<>());
            }
            adjMap.get(ticket[0]).add(ticket[1]);
        }

        // 각 ArrayList 정렬
        System.out.println(adjMap.values());
        for(ArrayList<String> arr: adjMap.values()){
            Collections.sort(arr);
        }


        String preNode="ICN";
        String nextNode;

        // 탐색
        for (int i = 1; i <= l; i++) {
//            preNode = path[i-1];
            nextNode = adjMap.get(preNode).get(0);
            adjMap.get(preNode).remove(0);
            path[i] = nextNode;
            preNode = nextNode;
        }

        System.out.println("정답 확인");

    }
}
