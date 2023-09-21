package programmers.level2;

import java.util.*;

public class MandarinChoose { // 귤 고르기

    public static void main(String[] args) {
        int k=6; // 한상자 갯수 1~100,000
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3}; // 크기 1~,10,000,000
        // 서로 다른 종류(크기) 최소화 하기
        // 정렬할 필요는 없고 전체에서 최댓값만 고르면 된다 >> heap 연산

        // tangerine 을 탐색 - 각 크기의 갯수를 기록 - 최댓값만 알면 된다.
        // 중간종료 -  만약 최댓값이 k 도달하면 return 1 (한 종류로 완성)
        // 탐색종료 -  각 최댓값을 k 도달할 때까지 합한다.


        int l = tangerine.length;
        Map<Integer,Integer> countMap = new HashMap<>(); // [종류, 갯수]


        // k 이후
        for (int i = 0; i < l; i++) {
            if(countMap.containsKey(tangerine[i])){
                countMap.put(tangerine[i],countMap.get(tangerine[i])+1); // 1개 추가
            }
            else countMap.put(tangerine[i],1); // 새로 할당

            if(countMap.get(tangerine[i]) == k){
                // 조기 종료 조건
//                return 1;
                System.out.println("연산 조기 종료!!! 이후 출력 메시지 의미없음");
            }
        }


        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        for(int i:countMap.values()){ // 할당
            maxHeap.add(i);
        }
        int maxSum = 0;
        int answer=0;

        while(maxSum<k){
            maxSum += maxHeap.poll();
            answer++;
        }

        System.out.println("답은 >> "+ answer);































    }
}
