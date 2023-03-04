package programmers.level1;

import java.util.*;

public class RandomTwoSum { // 두개 뽑아서 더하기 , 미해결

    public static int[] intConvert(List<Integer> list){
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (int) list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {0,1,1,10,11,12,13,14,15};
        Set<Integer> set = new HashSet<>();
        int l = numbers.length;

        // 연산
        for (int i = 0; i < l-1; i++) {
            for (int j = i+1; j < l; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

//        System.out.println(set);


        List<Integer> answer = List.copyOf(set);
        int[] answer2 = intConvert(answer);
        Arrays.sort(answer2); // 필요하다!! - 집합에서의 변환이 정렬의 보장해 주지는 않나봄
        System.out.println(answer);




    }
}
