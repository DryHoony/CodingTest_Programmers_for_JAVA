package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefenceGame { // 디펜스 게임
    // 정렬까진 필요없고 최솟값만 빠르게 찾아 연산하면 되므로 '힙'을 이용해보자 >> ver3
    // 정렬과 비교해서 힙연산 굉장히 빠르고 효율적 (데이터가 많을수록 더!!)



    public static void main(String[] args) { // ver3 - 최소힙 사용
        int n=7; // 초기병사 1~1,000,000,000
        int k=3; // 무적권 횟수  1~500,000
        int[] enemy = {4,2,4,5,3,3,1}; // 길이 1~1,000,000, 값 1~1,000,000

        // 최소힙 사용
        Queue<Integer> minHeap = new PriorityQueue<>();

        // 무적권 갯수가 더 많으면 연산종료
        if(enemy.length <= k){
            System.out.println("return enemy.length");
        }


        // 초기 k까지 할당
        for (int i = 0; i < k; i++) {
            minHeap.add(enemy[i]);
        }


        int count=0; // n 전까지 가능
        // k 이후 연산
        for (int i = k; i < enemy.length; i++) {
            System.out.println(i+1 + "번째 라운드, count="+count);
            if(enemy[i] > minHeap.peek()){
                // 무적권 사용 변경
                count += minHeap.poll();
                minHeap.add(enemy[i]);
            }
            else count += enemy[i];

            if(count > n){
                System.out.println(i + "번째 라운드에서 중간 종료!!");
//                System.out.println(return i);
                break;
            }
        }

        System.out.println("끝까지 왔으면 답은 >> " + enemy.length);

    }

    public static void main1(String[] args) { // ver2 - 최적화 >> 실패4개 - 시간초과 2개, 런타임 에러 2개
        int n=7; // 초기병사 1~1,000,000,000
        int k=3; // 무적권 횟수  1~500,000
        int[] enemy = {4,2,4,5,3,3,1}; // 길이 1~1,000,000, 값 1~1,000,000


        // 무적(shield)
        int[] shield =  new int[k];
        int count=0; // 실드값 제외 enemy 합, n 값이 타겟

        // 초기 k개를 실드에 할당하고 시작 - 왜 런타임 에러??
        for (int i = 0; i < k; i++) {
            shield[i] = enemy[i];
        }
        Arrays.sort(shield);


        // k+1 부터 연산, 인덱스 [k]에서 출발
        for (int i = k; i < enemy.length; i++) {
            if(enemy[i] > shield[0]){ // 쉴드 연산 - 더 큰 값을 실드에 할당
                count += shield[0]; // 쉴드값 제외로 count 연산
                shield[0] = enemy[i];
                Arrays.sort(shield); // 오름차순 - 작은 값 부터 연산(업데이트)
            }
            else{
                count += enemy[i];
            }

            if(count > n){ // n 초과하면 round 못깸
                System.out.println("게임 종료!! 답은 >> "+ i);
                break;
            }

        }

        System.out.println("모든 라운드 완료했으면 답은 >> "+enemy.length);


    }

    public static void main0(String[] args) { // 실패 2개 - 시간초과
        int n=7; // 초기병사 1~1,000,000,000
        int k=3; // 무적권 횟수  1~500,000
        int[] enemy = {4,2,4,5,3,3,1}; // 길이 1~1,000,000, 값 1~1,000,000


        // 무적(shield)
        int[] shield =  new int[k];
        int count=0; // 실드값 제외 enemy 합, n 값이 타겟

        for (int i = 0; i < enemy.length; i++) {
            if(enemy[i] > shield[0]){ // 쉴드 연산 - 더 큰 값을 실드에 할당
                count += shield[0]; // 쉴드값 제외로 count 연산
                shield[0] = enemy[i];
                Arrays.sort(shield); // 오름차순 - 작은 값 부터 연산(업데이트)
            }
            else{
                count += enemy[i];
            }

            if(count > n){ // n 초과하면 round 못깸
                System.out.println("게임 종료!! 답은 >> "+ i);
                break;
            }

        }

        System.out.println("모든 라운드 완료했으면 답은 >> "+enemy.length);





    }
}
