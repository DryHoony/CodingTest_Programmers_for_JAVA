package programmers.level2;

import java.util.ArrayList;

public class Country124 { // 124 나라의 숫자
    // 숫자 124를 이용한 3진법 처럼 표현

    public static void main(String[] args) {
        int n = 4;

        System.out.println("n = " + n);

        // 연산용 변수
        String answer = "";
        ArrayList<Integer> ternaryScale = new ArrayList<>();
        int k;

        // 연산
        // 1. 3진법 변환
        // 2. 3진법 숫자 012 >> 124 변환

        // ternaryScale(3진법) 할당, 역순!!
        while(n>2){
            ternaryScale.add(n%3); // n=1,2 인 경우 못잡는다.
            n /= 3;
        }

        ternaryScale.add(n);
        n /= 3;

        System.out.println("ternaryScale = " + ternaryScale);

        for (int i = ternaryScale.size()-1; i >=0 ; i--) {
            k = ternaryScale.get(i);
            if(k==0){
                answer+="1";
            }else if(k==1){
                answer+="2";
            }else if(k==2){
                answer+="4";
            }
        }



        System.out.println("답은 = " + answer);
    }
}
