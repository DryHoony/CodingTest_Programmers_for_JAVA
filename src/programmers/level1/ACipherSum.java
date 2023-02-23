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

    // 하샤드 수 - 정수 n은 'n의 자릿수의 합'으로 나누어 진다.
    public static boolean hashad(int n){
        if(n%sum(n)==0) return true;
        else return false;
    }

    public static void main(String[] args) {

    }
}
