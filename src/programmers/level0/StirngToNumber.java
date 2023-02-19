package programmers.level0;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StirngToNumber {

    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static java.util.List<Integer> stringToInt(String str){
        java.util.List<Integer> answer = new ArrayList<>();
        String [] strs = str.split("");
        for(String s:strs){
            if (isNumber(s)) answer.add( Integer.parseInt(s));
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "p2o4i8gj2";
        ArrayList<Integer> answer = (ArrayList<Integer>) stringToInt(str);
        System.out.println(answer);


        // 오름차순 정렬 - List를 정렬하는 방법
        Collections.sort(answer);
        System.out.println(answer);

    }
}
