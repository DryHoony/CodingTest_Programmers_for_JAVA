package programmers.highScoreKit.stackQueue;

import java.util.Stack;

public class HateSameNumber { // 같은 숫자는 싫어
    // 해당문제의 조건으로는 int preN 을 설정해 중복확인 후 ArrayList 에 추가하는게 더 효율적


    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        // peek 을 이용해 최근 입력값을 확인하기 위해 Stack 을 사용
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]); //없으면 peek() 에서 EmptyStackException

        for(int n:arr){
            if(n==stack.peek()){
                continue;
            }else {
                stack.push(n);
            }
        }

        // 결과반환 - 타입변경
        Integer[] answer = stack.toArray(new Integer[0]);
//        System.out.println(answer);
        for(int i:answer){
            System.out.println(i);
        }



    }
}
