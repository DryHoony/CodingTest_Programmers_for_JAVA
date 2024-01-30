package somthingFun;

public class FibonacciGoldenRatioConverge {

    public static void main(String[] args) {
        int n = 30;

        // 피보나치 수열생성 by DP
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(n+"개의 피보나치 수열");
        for (int f:fib){
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.println("------------------------------");

        // Fib(i)/Fib(i-1) 비율 측정 >> 수렴확인
        for (int i = 2; i < n; i++) {
            System.out.print(i + "번째 비율 >> ");
            System.out.println(fib[i] +"/"+ fib[i-1] + " = " + (float)fib[i]/fib[i-1]);
        }



    }

}
