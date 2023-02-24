package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci { // 0 1 1 2 3 5...

    public static int fibonacci(int n){ // 전통적인 재귀 정의ver
        //초항
        if(n==0 || n==1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // list 작성 ver
    public static int fibonacci2(int n){
        int[] list = new int[n+1]; //n은 인덱스 크기(갯수)는 n+1
        if(n==0 || n==1) return n;

        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i < n+1; i++) {
            list[i] = list[i-1] + list[i-2];
        }
        return list[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n번째 피보나치 항 출력
        System.out.println(fibonacci2(n));
    }
}
