package programmers.highScoreKit.Heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy { // 더 맵게
    // 모든 원소 k이상
    // 연산 값 = min1 + min2*2
    // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.



    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12}; // size 2 ~ 1,000,000 / 원소 0~1,000,000
        int k = 7;

        // 최소힙 - priority Queue로 대체
        Queue<Integer> priority = new PriorityQueue<>();
        for(int i:scoville){
            priority.add(i);
        }

        // 연산 test - ok
//        System.out.println(priority);
//        System.out.println(priority.peek()); // min 값
//        priority.add(priority.poll() + priority.poll()*2);
//        System.out.println(priority);
//        priority.add(priority.poll() + priority.poll()*2);
//        System.out.println(priority);

        int count=0;
        while(priority.peek() < k){ // k이상 될때까지 연산

            if(priority.size()==1){ //하나 남았는데 k이상 아니면 탈락
                System.out.println("return -1");
                break;
            }

            priority.add(priority.poll() + priority.poll()*2);
            count++;
        }

        System.out.println(count);







    }
}
