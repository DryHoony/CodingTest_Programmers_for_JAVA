package programmers.level2;

public class NumberExpression { // 숫자의 표현
    // 연속한 자연수로 표현 하는 경우의 수

    public static void main(String[] args) {
        int n = 15;

        int answer=0;
        int sum;

        for (int i = 1; i <= n/2; i++) {
            // i부터 연속한 자연수 합으로 n 표현 try
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if(sum >= n) break;
            }
            if(sum==n) answer++;
        }

        // 자기 자신 추가
        answer++;

        System.out.println("답은 = " + answer);
    }

}
