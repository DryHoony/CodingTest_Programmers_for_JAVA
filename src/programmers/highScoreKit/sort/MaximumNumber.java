package programmers.highScoreKit.sort;


import java.util.ArrayList;
import java.util.List;

public class MaximumNumber { // 가장 큰 수

    public static void main(String[] args) {
        int[] numbers = {3,30,34,5,9}; // 길이 1~100,000 값 0~1,000

        // 연산용 변수
        String answer = "";
        List<Integer>[] arr = new ArrayList[9];



        int count0 = 0;
        int digit;

        for (int n:numbers){
            if(n>=100){
                digit = n/100;

            } else if (n>=10) {

            } else if (n>0) {

            }else {
                count0++;
            }
        }




        System.out.println("답은 = " + answer);
    }
}
