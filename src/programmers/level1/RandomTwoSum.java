package programmers.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomTwoSum { // 두개 뽑아서 더하기

    public static int[] intConvert(ArrayList<Integer> list){
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
        System.out.println(answer);




    }
}
