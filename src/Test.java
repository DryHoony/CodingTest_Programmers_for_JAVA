import java.util.*;

public class Test {

    public static void main(String[] args) {
        // 소수 찾기
        // 입력값이 1~7 이하의 문자열
        String numbers = "17"; // 3
//        String numbers = "011"; //2






    }

    // 소수판별함수
    public static boolean primeCheck(int n){
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if(n%i==0) return false; // 약수 존재
        }
        return true;
    }

}









