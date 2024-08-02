package programmers.level2;

public class JumpAndBlank { // 점프와 순간이동
    // 0에서 출발
    // 점프는 +1, 순간이동은 *2
    // 정확히 목표 도달 거리에 안착해야함


    public static void main(String[] args) {
        int N; // 목표 도달 거리
        int result; // 건전지 사용량


        result = solution(5000);
        System.out.println(result);
    }

    public static int solution(int n){
        int answer = 0;

        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
//                answer ++;
                System.out.println("순간이동 반띵 n = " + n);
            } else {
                n -= 1;
                answer ++;
                System.out.println(answer + "번째 점프 결과 n = " + n);
            }
        }

        return answer;
    }


}
