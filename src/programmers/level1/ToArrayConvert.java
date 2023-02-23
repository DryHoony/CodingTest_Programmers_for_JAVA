package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class ToArrayConvert {

    public static int[] intConvert(ArrayList<Integer> list){
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (int) list.get(i);
        }
        return answer;
    }

    public static ArrayList<Integer> intConvert2(int[] list){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i:list){
            answer.add(i);
        }
        return answer;
    }

    public static String[] stringConvert(ArrayList<String> list){
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] list = {4,3,2,1};
        ArrayList<Integer> list2 = intConvert2(list);

        // 가장 작은 수 제거
        int min = list2.get(0);
        for(int i:list2){
            if(i<min) min = i;
        }
        list2.remove(list2.indexOf(min));

//        return intConvert(list2);







    }
}
