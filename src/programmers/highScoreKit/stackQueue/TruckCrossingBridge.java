package programmers.highScoreKit.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge { // 다리를 지나는 트럭

    public static void main(String[] args) {
        int bridge_length = 100; // (동시에)다리 건널 수 있는 최대 트럭 수
        int weight = 100; // 다리에 올라 갈 수 잇는 최대 무게 (다리에 완전히 오르지 않은 트럭 무게는 무시)
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; // 순서대로 건넘

        // 길이 bridge_length 인 Que 가 필요, 현재 Que 에 걸린 무게 측정할 변수 w 필요
        Queue<Integer> queue = new LinkedList<>();
        // 시간 간격을 맞추기 위해 '무게0인 가상의 트럭' 추가 - 초기화
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int time=0; // 걸린 시간
        int w=0; // 다리 지나는 트럭무게 합

        for(int truck:truck_weights){

            while(w+truck - queue.peek() > weight){ // (무게초과)지나갈 수 없으면 '가상트럭'연산
                w -= queue.poll();
                queue.add(0);
                time ++;
//                System.out.println(queue + " time = " + time); // 확인용
            }

            // 지나갈 수 있을 때
            w -= queue.poll();
            queue.add(truck);
            w += truck;
            time ++;
//            System.out.println(queue + " time = " + time); // 확인용

        }

        // 마지막 트럭이 다리끝에 올라탐 '길이' 만큼의 시간이 더 필요
        time += bridge_length;

        System.out.println(time);


    }
}
