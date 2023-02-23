package programmers.level1;

public class ACipherSum { //자릿수(a cipher)의 합

    public static int sum(int n){
        int answer=0;
        while(n>0){
            answer += n%10;
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
