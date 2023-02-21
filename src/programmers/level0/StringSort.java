package programmers.level0;

import java.util.Arrays;

public class StringSort {

    // String을 정렬, 대소문자 구분, 대문자 우선
    public static String sort(String str){
        char[] slist = str.toCharArray();
        Arrays.sort(slist);

        return new String(slist);
    }

    public static void main(String[] args) {
        System.out.println(sort("akvmBnCarAeofh"));
    }
}
