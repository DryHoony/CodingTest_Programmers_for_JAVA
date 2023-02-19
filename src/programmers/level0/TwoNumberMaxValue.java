package programmers.level0;

import java.util.Arrays;

public class TwoNumberMaxValue { // 정수 배열의 두개의 원소 곱 최댓값 만들기// 정수 배열의 두개의 원소 곱 최댓값 만들기// 정수 배열의 두개의 원소 곱 최댓값 만들기

    public static int multipleMax(int[] numbers){ // 정렬이용
        Arrays.sort(numbers); // 함수 사용후에도 정렬되어 있을까? 확인바람

        return Math.max(numbers[0] * numbers[1],
                numbers[numbers.length-1] * numbers[numbers.length-2]);
    }

    public static int multipleMax2(int[] numbers){ // 정렬이용X, 훨씬빠름
        int max1 = numbers[1]; // 최대
        int max2 = numbers[0];
        int min1 = numbers[0]; // 최소
        int min2 = numbers[1];

        if(numbers[0] > numbers[1]){
            max1 = numbers[0]; // 최대
            max2 = numbers[1];
            min1 = numbers[1]; // 최소
            min2 = numbers[0];
        }
        // 초기화 완료

        for (int i=2; i< numbers.length; i++){
            int n = numbers[i];
            if(n>0){ // 양수 max값 연산
                if(n<=max2) continue;
                else if (n<=max1) max2 = n;
                else{
                    max2 = max1;
                    max1 = n;
                }
            }else { // 음수 min값 연산
                if (min2 <= n) continue;
                else if (min1<=n) min2 = n;
                else{
                    min2 = min1;
                    min1 = n;
                }
            }
        }
        return Math.max(max1*max2, min1*min2);
    }


    public static void main(String[] args) {
        int[] numbers = {0, -31, 24, 10, 1, 9};

        System.out.println(multipleMax2(numbers));
    }

}
