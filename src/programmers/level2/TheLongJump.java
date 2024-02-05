package programmers.level2;

public class TheLongJump { // 멀리뛰기

    public static void main(String[] args) {
        int n = 5; // 1~2000
        // [1,2,3,5,...] 피보나치
//        if(n==1) return 1;

        // 연산용 변수
        long answer = 0; // 1234567 을 나눈 나머지를 return
        int[] answerList = new int[n];
        answerList[0] = 1;
        answerList[1] = 2;

        for (int i = 2; i < n; i++) {
            answerList[i] = (answerList[i-1] + answerList[i-2]) % 1234567;
        }


        System.out.println("답은 = " + answerList[n-1]);
    }
}
