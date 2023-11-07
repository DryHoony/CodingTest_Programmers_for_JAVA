package programmers.highScoreKit.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumber { // 가장 큰 수

    public static void main(String[] args) { // gpt 찬스 씀! - 처음부터 복잡도를 너무 생각하지 말자. 정의대로 일단 구현 try
        int[] numbers = {0,0,0}; // 길이 1~100,000 값 0~1,000

        // 연산용 변수
        int l = numbers.length;

        // 정수 배열을 문자열 배열로 변환
        String[] strNumbers = new String[l];
        for (int i = 0; i < l; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 문자열 정렬 - 정의 그대로 순서연산 정의 : 조합했을 때 더 큰 숫자 순서
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        if(strNumbers[0].equals("0")){
//            return "0";
            System.out.println("연산 종료!! return 0");
        }

        // 문자열 이어붙이기
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers){
            answer.append(str);
        }


        System.out.println("답은 = " + answer.toString());
    }







}
