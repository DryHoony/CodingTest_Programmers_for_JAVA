package programmers.level1;


public class IfDivisorCountEven { // 약수의 개수와 덧셈

    public static boolean powNumber(int n){
        if((int)Math.sqrt(n) == Math.sqrt(n)) return true;
        else return false;
    }

    public static void main(String[] args) {
        // 약수가 홀수인 것은 제곱수임을 이용.
        int left = 24;
        int right = 27;
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (powNumber(i)) answer -= i;
            else answer += i;
        }

        System.out.println(answer);

    }

}
