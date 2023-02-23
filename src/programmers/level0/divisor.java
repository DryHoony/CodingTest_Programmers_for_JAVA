package programmers.level0;

import java.util.ArrayList;
import java.util.List;

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

    //약수집합
    public static List<Integer> divisorList(int n){
        List<Integer> list = new ArrayList<>();

        int r = (int)Math.sqrt(n);
        for(int i=1; i<=r; i++){
            if(n%i==0) list.add(i); //약수이면 추가 (제곱수까지 커버)
        }

        int l = list.size();
        if (r==Math.sqrt(n)){ // 제곱수 일때
            for(int i=l-2; i>=0; i--){
                list.add(n/list.get(i));
            }
        }else{ // 제곱수 아닐때
            for(int i=l-1; i>=0; i--){
                list.add(n/list.get(i));
            }
        }

        return list;
    }

    //약수의 합
    public static int divisorSum(int n){ // 음이 아닌 정수 n에 대해
        int answer=0;
        int r = (int)Math.sqrt(n);

        // 제곱근 전까지 연산
        for(int i=1; i<=r; i++){
            if(n%i==0){
                answer += i + n/i;
            }
        }
        // 제곱수일 경우 중복제거
        if (r==Math.sqrt(n)) answer -= r;

        return answer;
    }

    public static void main(String[] args) {
        divisor d = new divisor();

        System.out.println(d.divisorCount(36));
        System.out.println(divisorList(36));




    }
}
