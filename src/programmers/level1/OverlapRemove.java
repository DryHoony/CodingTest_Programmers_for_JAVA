package programmers.level1;

import java.util.ArrayList;

public class OverlapRemove {

    public static ArrayList<Integer> overlapRemove(int[] list){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int n:list){
            if(!answer.contains(n)) answer.add(n);
        }
        return answer;
    }

    public static int[] listTransform(ArrayList<Integer> list){
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (int) list.get(i);
        }
        return answer;
    }
    

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        int[] result = listTransform(overlapRemove(arr));

        for (int i:result){
            System.out.println(i);
        }





    }

}
