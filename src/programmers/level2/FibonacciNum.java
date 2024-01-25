package programmers.level2;

import java.util.ArrayList;

public class FibonacciNum { // 피보나치 수

    public static void main(String[] args) {
        int n = 5;

        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        // 연산 2~n 까지
        for (int i = 2; i <= n; i++) {
            fib.add((fib.get(i-2) + fib.get(i-1))%1234567);
        }

        System.out.println("답은 = " + fib.get(n));
    }
}
