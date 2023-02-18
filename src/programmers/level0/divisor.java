package programmers.level0;

public class divisor { // 순서쌍(ordered pair) 추가

    public int divisorCount(int n){
        if(n==1) return 1;

        int answer = 0;
        int r = (int)Math.sqrt(n);

        // 제곱근 전까지 약수확인
        for (int i = 1; i <= r; i++) {
            if(n%i==0) answer+=2;
        }

        // 제곱수일 경우
        if(r==Math.sqrt(n)) answer--;

        return answer;
    }



    public static void main(String[] args) {
        divisor d = new divisor();

        System.out.println(d.divisorCount(20));

    }
}
