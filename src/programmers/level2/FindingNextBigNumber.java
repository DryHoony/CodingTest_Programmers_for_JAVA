package programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

public class FindingNextBigNumber { // 뒤에 있는 큰 수 찾기

    public static void main(String[] args) {
        int[] numbers = {2,3,3,5}; // 길이 4~1,000,000, 값 1~1,000,000
        // 각 원소에 대해 자신 보다 크고 가장 가까이 있는 수를 '뒷 큰수'
        // 모든 원소에 대해 '뒷 큰수' array 를 출력, 뒷 큰수가 없으면 -1

        int l = numbers.length;
        int[] result = new int[l];

        // Stack 사용 >> 큰 수는 및에 깔린다.
        Stack<Integer> stack = new Stack<>(); // 인덱스만 할당 numbers[i]로 출력


        stack.push(0);
        for (int i = 1; i < l; i++) {

            // 스택에 담긴 수 vs numbers[i] 비교
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                result[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        // stack 에 남은 값들 모두 -1
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

//        return result;

    }

    public static void main0(String[] args) { // 실패 - 시간초과 4개
        int[] numbers = {2,3,3,5}; // 길이 4~1,000,000, 값 1~1,000,000
        // 각 원소에 대해 자신 보다 크고 가장 가까이 있는 수를 '뒷 큰수'
        // 모든 원소에 대해 '뒷 큰수' array 를 출력, 뒷 큰수가 없으면 -1

        int l = numbers.length;
        int[] result = new int[l];


        ArrayList<int[]> waitingArray = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            int n = numbers[i];
            System.out.println(n +"연산 >> ");

            // waiting 앞에서 부터 n 보다 작은 값은 제거, 및 result 로 출력
            while(!waitingArray.isEmpty()){
                if(waitingArray.get(0)[0] < n){
                    result[waitingArray.get(0)[1]] = n;
                    waitingArray.remove(0);
                }
                else break; // 더 큰 값이 남아있으면 그대로 waiting
            }


            // waiting 에 n을 추가(맨 앞에 추가 함으로서 자동 정렬 효과)
            waitingArray.add(0, new int[] {n,i});

            System.out.print("waitingArray 확인 >> ");
            for (int[] wait:waitingArray){
                System.out.print(wait[0]+","+wait[1]+" / ");
            }
            System.out.println();
        }

        // 연산종료 후 waiting 에 남은 값은 -1 할당
        for (int[] wait:waitingArray){
            result[wait[1]] = -1;
        }

//        return result;
        System.out.println("답은 >> "+ result);
    }
}
