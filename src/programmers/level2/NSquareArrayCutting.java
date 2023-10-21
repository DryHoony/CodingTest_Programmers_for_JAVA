package programmers.level2;

public class NSquareArrayCutting { // N^2 배열 자르기

    public static void main(String[] args) {
        int n = 4; // 1~10^7
        long left = 7;
        long right = 14;
        // 0 <= left <= right < n^2
        // right - left < 10^5

        // n행 n열의 2차원배열 (i = 1,2,...,n)
        // arr[i,j] = max(i,j)
        // 각 행을 (군수열 화) 이어붙여 1차원 배열로 만듬 >> left ~ right 까지를 출력
        // i행 (i군) = i i ... i (i+1) (i+2) ... n
        // 1차원 배열의 k번째 = (k/n) 군의 (k-1)%n+1 번째 값

        // 연산용 변수
        int l = (int) (right - left) + 1;
        int[] answer = new int[l];


        // 연산
        for (long i = left; i <= right ; i++) {
            // Index i 에 대해

            System.out.println((i/n)+1 + "군의 " + ((i)%n+1) + "번째 값");

            answer[(int) (i-left)] = (int) Math.max((i/n)+1, (i)%n+1);
        }

        System.out.println("답은 = " + answer);
    }
}
