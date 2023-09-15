package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class TaskProcessing { //과제 진행하기
    // 시작 시간 우선, 이전과제 멈춤 - 최근 멈춤과제 계속 진행 >> Stack 사용

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}; // 과제이름, 시작시간, 소요시간
        // 3 ~ 1000, 시작시간은 모두 다르다

        // 시작 시작으로 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                return o1[1] - o2[1]; // 오름차순
                if( o1[1].split(":")[0].equals(o2[1].split(":")[0]) ){
                    // 시간이 같으면 분으로 비교
                    return Integer.parseInt(o1[1].split(":")[1]) - Integer.parseInt(o1[1].split(":")[1]);
                }
                return Integer.parseInt(o1[1].split(":")[0]) - Integer.parseInt(o1[1].split(":")[0]);
            }
        });


        // 연산용 변수
        class Plan {
            String name;
            int timeRemaining; // 분으로 기록

            public Plan(String name, String time) {
                this.name = name;
                this.timeRemaining = minuteCalculate(time);
            }


        }

        Stack<Plan> waitingPlan = new Stack<>();
        Plan plan;
        int nextPlanStartTime; // 새 과제 시작시간 - 우선적용!
        int nowTime=0; // 현재 시간
        int nextPlanIndex=0;


        int l = plans.length;
        String[] result = new String[l];
        int resultIndex=0;


        while(nextPlanIndex < l){
            // 새 과제 시작시간 점검
            nextPlanStartTime = minuteCalculate(plans[nextPlanIndex][1]);

            // waitingPlan 연산 - 다음 과제 시작전까지(혹은 Stack 빌 때 까지)
            while(nowTime < nextPlanStartTime){ // Stack 연산
                if(waitingPlan.isEmpty()){ // stack 에 과제 미션 없으면 다음 미션
                    nowTime = nextPlanStartTime;
                    break;
                }

                plan = waitingPlan.peek();
                if(nextPlanStartTime - nowTime >= plan.timeRemaining){ // Stack 과제 전체 연산 - Stack.pop, result 등록
                    waitingPlan.pop();
                    result[resultIndex] = plan.name;
                    resultIndex++;

                    nowTime += plan.timeRemaining;
                }
                else { // Stack 과제 부분 연산 - 시간만 update;
                    plan.timeRemaining -= nextPlanStartTime - nowTime;
                    nowTime = nextPlanStartTime;
                }

            }

            // 새 과제 Stack 에 할당
            plan = new Plan(plans[nextPlanIndex][0], plans[nextPlanIndex][2]);
            waitingPlan.push(plan);
            nextPlanIndex++;

        }

        // Stack 에 남은 과제 연산
        while (!waitingPlan.isEmpty()){
            plan = waitingPlan.pop();

            // 연산종료 후 result에 할당
            result[resultIndex] = plan.name;
            resultIndex++;
        }



        System.out.println("답은 return result");
    }

    public static int minuteCalculate(String t){
        int time=0;

        time += Integer.parseInt(t.split(":")[0])*60; // 시
        time += Integer.parseInt(t.split(":")[1]); // 분

        return time;
    }

    public static boolean isLeftTimeEarlier(String t1, String t2){
        if(t1.split(":")[0].equals(t2.split(":")[0]) ){
            // 시간이 같으면 분으로 비교
            if(Integer.parseInt(t1.split(":")[1]) < Integer.parseInt(t2.split(":")[1]))
                return true;
            return false;
        }

        if( Integer.parseInt(t1.split(":")[0]) < Integer.parseInt(t2.split(":")[0]) )
            return true;

        return false;
    }

}
