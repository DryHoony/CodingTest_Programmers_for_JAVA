package programmers.highScoreKit.stackQueue;

import java.util.*;

public class StockPrice { // 주식가격
    // 초 단위로 기록된 주식가격
    // 각 초의 입장에서 가격이 떨어지지 않은(자신보다 낮은 가격이 되는) 기간(사이 간격)은 몇 초인지 return
    // 앞으로 연산(오른쪽 진행) - 재귀함수 이용해 보자!, 부분 정복 ver1
    // 뒤로 연산(왼쪽 진행) -


    public static int[] StockRisingSpan(int[] prices){
        int l = prices.length;
        int[] answer = new int[l];
        int min = prices[0]; // 초기화

        Stack<Integer> stack = new Stack<>();

        for (int n:prices) {
            if(n<min){
//                answer += StockSpanOperator(stack, n); // answer 에 추가할 방법 구현
                stack.clear(); // stack 초기화
                stack.push(n);
                min=n; // 최소값 갱신

            }
            else{
                stack.push(n);
            }

            // 끝자리 StockSpanOperator , 조금 다르다!

        }


        return null;
    }

    public static List<Integer> StockSpanOperator(Stack<Integer> stack, int n){
        // StockRisingSpan 의 부분 연산
        List<Integer> answer = new ArrayList<>(); // return
        int blank=0; // 건너뜀 횟수
        Stack<Integer> min = new Stack<>();
        min.push(n);

        while (!stack.empty()){
            if(stack.peek() < min.peek()){
                answer.add(0, min.size()+blank);
                blank ++;
            }
            else{
                // min 에서 어떤위치에 해당되는지 찾는 연산 And min을 update하는 연산
            }
        }




        return answer;
    }

//    public static int[] monoIncrease(Stack<Integer> stack){ // 단조증가
//        return null;
//    }


    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3}; // 길이 2~100000 (꽤 길다), 값 1~10000





    }

}
