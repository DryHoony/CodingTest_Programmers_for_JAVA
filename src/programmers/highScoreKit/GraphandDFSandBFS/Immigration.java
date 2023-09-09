package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.LongStream;

public class Immigration { // 입국심사
    // 이진탐색(프로그래머스 분류는 이진탐색인데, 왜지??)
    // 심사관의 수가 10만까지 이므로 최소공배수 구하기 벅참


    public static void main(String[] args) {
        int n = 6; // 인원수 1~1억 명
        int[] times = {7,10}; // 심사관 1~10만 명, 심사시간 1~1억분

        Arrays.sort(times);

        // 탐색 범위 1 ~ 1,000,000,000,000,000,000 까지면 ok 가상의 list 있다고 상상
        // 연산용 변수
        long left=1L; // 접미사 L 주의
//        long r= 1000000000000000000L;
        long right = (long) times[times.length-1]*n;
        long answerTime = right; //최소 비교를 위해 최댓값을 초기할당
        long m;
        long countN;

        // P1 - countN 이 2 이상 변활때
        // P2 - 최소시간 맞추기 t=12,13,14 값이 똑같다면? 답은 12
        // 이진탐색 - 반복문 이용
        while(left <= right){
            m = (left+right)/2;
            countN = targetTimeAccumulateCount(times, m); // 같잖아

//            if(countN == n) break;
            if (countN < n) left = m+1;
            else{
                right = m-1;
                answerTime = Math.min(answerTime,m); // P1,2 를 모두 해결해준다!!
            }
        }


        System.out.println("답은 " + answerTime);
    }

    // 굉장히 무거운 가보다,,2/9 실패(시간초과)
//    public static void main0(String[] args) {
//        int n = 6; // 인원수 1~1억 명
//        int[] times = {7,10}; // 심사관 1~10만 명, 심사시간 1~1억분
//        // 전체 심사시간 최솟값 return
//        Arrays.sort(times); // 오름차순 - 미리 정렬상태라는 보장X
//
//
//        // 연산용 변수
//        int max = times[times.length-1]; // 가장 큰 시간
//        int cycle=0; // max 한 사이클에 연산되는 인원 수
//        int r; // cycle 이 돈 바퀴 수
//
//        // step1 - 한 cycle 수 구하기
//        for (int t:times){
//            cycle += max/t;
//        }
//        // step2 - cycle 이 대략 몇 바퀴 돌았는지 구하기 >> r
//        r = n/cycle;
//        // step3 -  근접한 시간을 구하기, 해당 시간까지의 인원 수 도출
//        long targetTime = (long) max * r;
//        int countN = targetTimeAccumulateCount(times, targetTime); // 연산 인원수
//        System.out.println("n과 비교할 중간연산 인원수 : "+countN);
//
//        // step4 - countN 과 n을 비교하여 targetTime을 ++ 또는 --로 연산 >> countN 을 n에 맞춤
//        // countN 이 정확히 n과 일치하지 않을 수도 있다! since 공배수가 연산되어 countN가 2이상 +- 될때!! >> 대소관계 바뀜 주의
//        while(countN > n){
//            // targetTime 줄이며 연산
//            targetTime--;
//            countN -= targetTimeCount(times, targetTime);
//        }
//        while(countN < n){
//            // targetTime 늘리며 연산
//            // 중복시간에 걸려 "countN>=n" 이 되는 건 괜찮, but 반대로 countN<n 이 되면 곤란,,따라서 줄이는 연산 먼저
//            targetTime++;
//            countN += targetTimeCount(times, targetTime);
//        }
//
//        System.out.println("최종 인원 수 : "+countN);
//        System.out.println("정답은 >> "+targetTime);
//    }


    // 여러번 쓰면 복잡도 상당히 증가, 큰 숫자 범위 연산시 long 타입임에 주의!
    public static long targetTimeAccumulateCount(int[] times, long target){
        long countN = 0;
        for(long i:times){
            countN += target/i;
        }

        return countN;
    }

    // 이것도 무겁지 않을까?
    public static int targetTimeCount(int[] times, long target){
        int countN = 0;
        for(int i:times){
            if(target%i==0) countN++;
        }

        return countN;
    }

}
