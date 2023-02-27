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

    public static int budgetCount(int[] list, int budget){
        // 정렬된 list 의 일부원소의 합 == budget 인 원소갯수의 최댓값 count
        int count=0;
        int index = 0;

        //연산 budgetOperation
        return budgetOperation(list,budget,0,0);
    } //실패 및 시간초과

    public static int budgetOperation(int[] list, int budget, int count, int index){
        if(budget==0) return count; // 종료조건
        else if (budget<0 || index==list.length) return 0; // 해당안되는 재귀가지 종료조건 강제할당!! 해결필요!!

        return Math.max(budgetOperation(list, budget-list[index], count+1,index+1),
                budgetOperation(list, budget, count,index+1));
    }

    public static void main(String[] args) {

        int[] d = {2,2,3,3};
        Arrays.sort(d); //오름차순
//        int b = 9;

        System.out.println(budgetCount(d,10));

















    }
}
