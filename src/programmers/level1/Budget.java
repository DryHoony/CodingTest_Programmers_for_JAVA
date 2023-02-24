package programmers.level1;



import programmers.level0.ReverseArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budget { //기출 https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=java

    // 답이 존재한다는 가정하에 꼼수
    public static int idiot(int[] d, int budget) {
        int count = 0;
        Arrays.sort(d);

        for(int n:d){
            if(n<=budget){
                budget -= n;
                count++;
            }else return count;
        }

        return count;
    }

    // Arraylist<Integer>의 원소의 합
    public static int listSum(ArrayList<Integer> list){
        int sum = 0;
        for(int n:list){
            sum += n;
        }
        return sum;
    }

    // 원소별로 포함,미포함 2^n 가짓수 재귀
    public static int recursion(ArrayList<Integer> list, int budget, int i){

        if(listSum(list) == budget) return list.size(); // 종료조건 list의 합이 budget이면 종료
        else if (listSum(list) < budget) {
            // i번째 연산
            if(i<list.size()){
                // i번째 포함 재귀
                return recursion(list,budget,i+1);

                // i번째 미포함 재귀
//                list.remove(i);
//                return recursion(list,budget,i);
            }

        }

        return -1; // 종료조건 해당안되는 재귀가지 어떻게 처리??
    }

//    public static int recursion2(ArrayList<Integer> list, int budget){
//        if(listSum(list) > budget) ;
//        else if (listSum(list) == budget) return list.size();
//        else{
//            for (int i = 0; i < list.size(); i++) {
//                ArrayList<Integer> nextlist = (ArrayList<Integer>) list.stream().toList(); //깊은복사 되었나?
//                nextlist.remove(i);
//                System.out.println(nextlist); //출력해서 확인해보자
//                return recursion2(nextlist, budget);
//            }
//        }
//
////        return; // 마찬가지로 탈락한 재귀가지를 어떻게 처리할지,,
//    }


    public static void main(String[] args) {

        int[] d = {1,3,2,5,4};
        int budget = 9;
        int answer;

        Arrays.sort(d); //오름차순
        d = ReverseArray.reverse(d); // 내림차순
        ArrayList<Integer> list = ToArrayConvert.intConvert2(d); //Arraylist 변환
        System.out.println(list);















    }
}
