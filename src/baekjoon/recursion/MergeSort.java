package baekjoon.recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort { //병합정렬, 합병정렬 - 미완성!!

    // 비재귀로 구현 - bottom up방식
    public static int[] mergesort0(int[] list){
        ArrayList<Integer> answer = new ArrayList<>();

        return null;
    }


    // 재귀로 구현
    public static ArrayList<Integer> mergesort(ArrayList<Integer> list){
        // 분할(divide), 정복(conquer)
        // 결합(combine, merge)

        return merge((ArrayList<Integer>) list.subList(0,list.size()/2),list.subList(list.size()/2,list.size()));

    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, List<Integer> list2){

        // list1과 list2를 정렬하여 합병, list1,list2는 정렬되어 있다고 가정
        ArrayList<Integer> answer = new ArrayList<>();
        int i=0;
        int j = 0;

        while(i<list1.size() && j<list2.size()){
            if (list1.get(i) <= list2.get(j)){
                answer.add(list1.get(i));
                i++;
            }else{
                answer.add(list2.get(j));
                j++;
            }

            if(i==list1.size()){ // list1끝이면
                while(j<list2.size()){
                    answer.add(list2.get(j));
                    j++;
                }
            } else if (j==list2.size()) { //list2끝이면
                while(i< list1.size()){
                    answer.add(list1.get(i));
                    i++;
                }
            }
        }

        return answer;
//        return intConvert(answer);
    }

    public static int[] intConvert(ArrayList<Integer> list){
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (int) list.get(i);
        }
        return answer;
    }





    public static void main(String[] args) {
        int[] list = {1,5,8,5,4,3,5,8,2};

//        // merge 작동확인
//        int[] list1 = {1,3,5,7,9};
//        int[] list2 = {2,4,6,7,8,9};
//        System.out.println(merge(list1,list2));


    }
}
