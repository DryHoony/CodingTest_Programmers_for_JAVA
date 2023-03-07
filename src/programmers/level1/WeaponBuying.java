package programmers.level1;

public class WeaponBuying { // 기사단원의 무기

    // 약수의 갯수
    public static int divisorCount(int n){
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

    public static int divisorCountLimit(int n, int limit, int power){ // limit 은 power 값으로 반환
        if(n==1) return 1;

        int answer = 0;
        int r = (int)Math.sqrt(n);

        // 제곱근 전까지 약수확인
        for (int i = 1; i < r; i++) {
            if(n%i==0) answer+=2;
            if(answer>limit) return power;
        }

        // 제곱수일 경우
        if(r==Math.sqrt(n)) answer++;
        else answer += 2;

        if(answer>limit) return power;
        return answer;
    }


    public static void main(String[] args) {
        int number = 10; // 기사번호 1~number
        int limit = 3; // 제한수치, 초과하면 power 값으로 대체
        int power = 2; //
        int answer=0;

        int n;
        for (int i = 1; i <= number; i++) {
            n = divisorCount(i);
            if(n>limit) answer+= power;
            else answer += n;

//            answer += divisorCountLimit(i,limit,power); // 오류가 있다.
        }

        System.out.println(answer);



    }
}
