package programmers.level2;

public class Dot { // 점찍기

    public static void main(String[] args) {
        int k=2; // 격자간격 1~1,000,000
        int d=4; // 원 반경 1~1,000,000

        // 연산용 변수
        long answer=1L; // 원점 무조건 포함 - 1개
        // 축 연산 - x,y
        answer += d/k * 2;
        System.out.println("축은 ="+answer);


        // 1사분면 연산
        for (int x = k; x < d; x+=k) {
            int y = (int) Math.sqrt(Math.pow(d,2) - Math.pow(x,2));
            answer += y/k;
        }

        System.out.println("답은 >> "+answer);
    }
}
