package programmers.highScoreKit.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumber { // 가장 큰 수
    // 모든 숫자 다 사용하면 자릿 수는 고정
    // 숫자 크기 비교연산시 (Comparator 따로 구현?) 최고자리 숫자 큰값, 같으면 다음 자릿수 큰 값


    // 최고자릿수
    public static int firstCipherOfNumber(Integer n){
        while(n/10 != 0){ // 10으로 나눈 나머지가 0 일때까지 >> 한자리 수일때 까지
            n /= 10; // 자릿수 땡김
        }

        return n;
    }

    public static void main(String[] args) { // ver1 - 8/15, 런타임 에러(5), 실패(2)
//        int[] numbers = {6,10,2}; // 원소는 0~1000, 길이는 1~100,000(많네)
//        int[] numbers = {3,30,34,5,9};
//        int[] numbers = {5,7,6,3,276,5,1,58,3,2,2,4,85,63};
        int[] numbers = {1, 10, 100, 1000, 818, 81, 898, 89, 0, 0}; // 89/898/818/81/1/10/100/1000/0/0

        // array 를 Integer[] 변경필요
        Integer[] numberArray = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberArray[i] = numbers[i];
        }


        /*
        * 정렬기준 정의
        * 1. 최고자리 숫자 큰값 (0~9) 연산
        * 2. 반복문 연산 while
        * 2-1. 다음 자릿수로 넘어감(이하 자릿수 연산)
        * 2-2. 만약 둘중 자릿수가 더 없다면 '마지막 비교'로 연산종료
        * 2-3. 자릿수가 큰 값 return, (만약 자릿수가 없다면 이전 자릿수로 연산) (34 > 3 > 30, '3'을 다음 자릿수 연산에서 33으로 취급)
        * 2-4. 자릿수 연산에서 값이 같다면 2.1 부터 반복
        *
        * */
        // array 를 전체 정렬 vs '힙'을 이용한 반 정렬 (어짜피 최대값 순으로 뽑아낼테니)
        Arrays.sort(numberArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (firstCipherOfNumber(o1) != firstCipherOfNumber(o2))
//                    return firstCipherOfNumber(o2) - firstCipherOfNumber(o1); // 양수면 o2 return, 즉 큰 값 return
//                else if()

                String x = String.valueOf(o1);
                String y = String.valueOf(o2);
                String preN;

                if(x.charAt(0) != y.charAt(0)) // 1. 최고자리 숫자 비교
                    return y.charAt(0) - x.charAt(0); // 양수면 y return, 즉 큰 값 return
                else{

                    while(true){ // 2. 반복문 연산
                        preN = String.valueOf(x.charAt(0)); // 이전 자릿수 저장

                        // 2.1 다음 자릿수
                        x = x.substring(1);
                        y = y.substring(1);

                        //2.2 (둘중 하나라도) 자릿수 없을때 마지막 연산
                        if(x.equals("") || y.equals("")){
                            if(x.equals("")) x = preN; // 자릿수 없다면 이전 자릿수 값 할당
                            if(y.equals("")) y = preN; // "
                            return y.charAt(0) - x.charAt(0);
                        }

                        // 2.3 자릿수가 큰 값 return
                        else if (x.charAt(0) != y.charAt(0)) // 자릿수가 다를때만 연산, 같다면 2.4 로 반복문 연산
                            return y.charAt(0) - x.charAt(0); // 양수면 y return, 즉 큰 값 return
                    }

                }


            }
        });



        StringBuilder answer = new StringBuilder(); // 정답이 너무 클 수 있으니 문자열로 바꿔 return
        // answer 에 추가 연산
        for(int n:numberArray){
            answer.append(n);
        }

        String a = answer.toString();

        // answer return 값 확인
        System.out.println(a);




    }
}
