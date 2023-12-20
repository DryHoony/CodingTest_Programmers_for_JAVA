package programmers.highScoreKit.stackQueue;

import java.util.*;

public class StockPrice {

    public static void main(String[] args) {

        int[] price = {1,2,3,2,3}; // 4,3,1,1,0
        // 값은 1~10,000  길이는 2~100,000
        // 더 작은 숫자가 나올때 까지의 길이(거리) 기록

        // 연산용 변수
        int l = price.length; // 길이
        int[] answer = new int[l]; // 답
        int calIndex = 0; // 현재 위치, 탐색 위치

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int x : price){
            // 1. x값 map.keySet() 순회 연산 - x값이 더 작으면 answer 에 할당
            for (int key:map.keySet()){
                if(x < key){
                    // asnwer 할당
                    for(int i:map.get(key)){
                        answer[i] = calIndex - i;
                    }
                    // map 에서 key 제거
                    map.remove(key); // keySet 조회-반복문 연산에 문제 없을까?
                }
            }

            // 2. x값 map 추가 연산 - 존재/비존재 구분
            if(map.containsKey(x)){
                // 존재하면 - value 값 List 에 추가
                map.get(x).add(calIndex);
            }
            else {
                // 존재하지 않으면 - key 로 추가
                map.put(x, new ArrayList<>());
                map.get(x).add(calIndex);
            }
            calIndex ++; // 다음 index
        }

        // 마무리 연산 - 남아있는 key,value 에 대해 answer 값 할당 연산
        calIndex--;
        for (int key:map.keySet()){



        }


        System.out.println("map 출력확인"); // ok
        for(int key:map.keySet()){
            System.out.println("key = " + key);
            System.out.println(map.get(key));
        }

        System.out.println();
        System.out.println("답은 = ");
        for (int a:answer){
            System.out.println(a);
        }
    }

}
