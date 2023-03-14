package programmers.highScoreKit.StackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment { // 기능개발


    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99}; // 현재 작업 진도 >> 목표 100
        int[] speeds = {1, 1, 1, 1, 1, 1}; // 작업 속도 - ++작업 진도/day

        int l = progresses.length;
        int[] dayRequired = new int[l]; // 작업 완료에 필요한 일(날자) 수
        for (int i = 0; i < l; i++) {
            dayRequired[i] = (100-progresses[i])/speeds[i];
            // 소수점 일 경우, '올림'연산필요 - 소수점일 때만 ++로 대체
            if((100-progresses[i])%speeds[i]!=0) dayRequired[i]++;
        }

        for (int i:dayRequired){
            System.out.println(i);
        }

//        dayRequired 의 원소를 Queue 연산 - Queue 나 Stack 이 필요할까?, 효율적일까?

        // 다른방법 try
        int today=0;
        int distributionCount=0;
        List<Integer> answer = new ArrayList<>();

        for(int d:dayRequired){

            if(d > today){ // 새로운 '큐' 걸림 - 뭘 배포하는지 저장할 필요없으므로 그냥 count 만 세면 ok
                answer.add(distributionCount); // 이전 '큐' 배포, 처음 반복문 돌때 비어있는 이전 '큐'가 배포됨, 추후 삭제 필요
                today = d; // today 업데이트
                distributionCount=1;
            }
            else{ // '큐'에 추가
                distributionCount++;
            }

        }

        // bigger 한 day 값이 나와야 배포하므로 마지막 '큐'는 배포X 상태로 남아있다. 따로 배포 필요
        answer.add(distributionCount);

        // 반복문 초기에 빈 '큐'가 최초 배포 >> 삭제 연산
        answer.remove(0);

        // 결과확인
        System.out.println(answer);





    }

}
