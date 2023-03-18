package programmers.highScoreKit.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumber { // 가장 큰 수
    // 모든 숫자 다 사용하면 자릿 수는 고정
    // 숫자 크기 비교연산시 (Comparator 따로 구현?) 최고자리 숫자 큰값, 같으면 다음 자릿수 큰 값


    public static void main(String[] args) {
        Integer[] numbers = {6,10,2}; // 원소는 0~1000, 길이는 1~100,000(많네)
//        int[] numbers = {3,30,34,5,9};

        // array 를 Integer[] 변경필요

        /*
        * 정렬기준 정의
        * 1. 최고자리 숫자 큰값
        * 2. 다음 자릿수 큰 값 (다음 자릿수 가 존재하지 않으면 3.으로)
        * 3. 자릿수 짧은 값
        * */
        // array 를 전체 정렬 vs '힙'을 이용한 반 정렬 (어짜피 최대값 순으로 뽑아낼테니)

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });




        String answer = ""; // 정답이 너무 클 수 있으니 문자열로 바꿔 return
        // answer 에 추가 연산

        // answer return 값 확인
        System.out.println(answer);



    }
}
