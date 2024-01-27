package programmers.level2;


import java.util.ArrayList;

public class LineUpWay { // 줄서는 방법
    public static void main(String[] args) {
        int n = 3; // 20이하 자연수
        long k = 5;

        // 연산용 변수
        long count = 0; // k 도달시 종료
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] answer = new int[n];
        int aIndex = 0;
        // list 에 있는 숫자를 answer 에 할당, 그 과정에서 경우의 수 count 에 누적

        // 연산
        // 1. 자릿수 찾기 : count + F(i) <= k 를 만족하는 max(i)값 찾기
        // 2. 자릿수 할당 : list 에서 해당 '위치 값' 제거 및 answer 에 할당
        // 3. count==k 일때까지 1,2 반복 (list 에 원소가 남을 경우 순서 그대로 answer 에 할당 with aIndex)




        System.out.println("답은 = ");
    }

    public static long Factorial(int n){
        long a = 1;
        for (int i = 2; i <= n; i++) {
            a *= i;
        }
        return a;
    }

}
