package programmers.level2;

public class JumpAndBlank { // 점프와 순간이동
    // 0에서 출발
    // 점프는 +1, 순간이동은 *2
    // 정확히 목표 도달 거리에 안착해야함


    public static void main(String[] args) {
        int N; // 목표 도달 거리
        int result; // 건전지 사용량

        N = 5000;

        result = solution(N);
        int result1 = solution1(N);
        if(result == result1)
            System.out.println("답은 = " + result);
        else {
            System.out.println("틀림!!!");
        }
    }

    public static int solution(int n){ // 역방향 연산 (우박수열과 비슷)
        int answer = 0;

        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
//                answer ++;
                System.out.println("순간이동 반띵 n = " + n);
            } else {
                n -= 1;
                answer ++;
                System.out.println(">> "+ answer + "번째 점프 결과 n = " + n);
            }
        }

        return answer;
    }

    public static int solution1(int n){ // 순방향 연산, DP 사용
        int[] dp = new int[n+1]; // index n값 그대로 이용

        dp[1] = 1; // 최초할당

        for(int i=2; i<=n; i++){
            if(i % 2 == 0){
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        return dp[n];
    }


}
