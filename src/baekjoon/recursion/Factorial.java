package baekjoon.recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial { //백준에 제출시 class명을 Main으로 해야한다

    public static int factorial(int n){ //일반 재귀ver
        if (n<=1) return 1;
        return n*factorial(n-1);
    }

    public static int factorial2(int n){ // 꼬리재귀 이용ver
        return factorialTail(n,1);
    }

    public static int factorialTail(int n, int answer){
        if(n<=1) return answer;
        return factorialTail(n-1,n*answer);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // IOException, NumberFormatException

        System.out.println(factorial2(n));



    }
}
