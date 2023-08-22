package programmers.highScoreKit.dynamicProgramming;

public class N_Expression { // N으로 표현

    public static void main(String[] args) {
        int N = 5;
        int number = 12; // 4
        // N과 사칙연산을 통해 number 만들기, 나누기 연산에서 나머지는 무시

        // 연산용 변수
        int count=0;


        // 메모이제이션 f(n)
        // 각 숫자에 대한 count
        // f(n+1) = f(n-1) <= f(n) + 2 // N/N 으로 1 차이 만들 수 있다. 물론 더 간단한 방법으로 만들 수 도 있으므로 <=


        System.out.println("답은 = " + count);
    }

}
