package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySlice { // 배열자르기

    public int[] solution1(int[] numbers, int num1, int num2){ // copyOfRange 이용
      int[] answer =  Arrays.copyOfRange(numbers, num1, num2 + 1);
        return answer;
    }

    public int[] solution2(int[] numbers, int num1, int num2){ // 범위만큼 직접 할당
        int[] answer = new int[num2 - num1 + 1];

        for (int i = num1; i<= num2; i++){
            answer[i-num1] = numbers[i];
        }

        return answer;
    }

    public int[] solution3(int[] numbers, int num1, int num2){ //

        return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();
    }


    public int[] solution0(int[] numbers, int num1, int num2){ //

        return null;
    }








    public static void main(String[] args) {
        ArraySlice ls = new ArraySlice();
        int[] list = {1,2,3,4,5,6,7,8,9};

        int[] slList = ls.solution3(list,1,5); // 인덱스 1부터 5까지
        for(int i:slList){
            System.out.println(i);
        }


    }
}
