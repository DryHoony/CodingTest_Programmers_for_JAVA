package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Poketmon { //폰켓몬

    public static Set<Integer> toSet(int[] nums){ // set으로 변환, 직접할당
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        return set;
    }

    public static Integer[] toInteger(int[] nums){
        Integer[] list = new Integer[nums.length];

        for(int i=0; i<nums.length; i++){
            list[i] = nums[i];
        }

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {3,3,3,2,2,4};
        int n = nums.length;


        //nums를 중복제거 또는 set화 하여 길이를 도출
        Set<Integer> set = toSet(nums);
//        Set<Integer> set = new HashSet<Integer>(Arrays.asList(toInteger(nums)));

        System.out.println(set);
        int m = set.size();






    }

}
