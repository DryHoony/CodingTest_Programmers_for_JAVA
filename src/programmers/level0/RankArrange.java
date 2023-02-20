package programmers.level0;

import java.util.Arrays;

public class RankArrange { // 등수 매기기


    public static double[] reverse(double[] list){
        int l = list.length;
        double[] answer = new double[l];

        for (int i = 0; i < l; i++) {
            answer[i] = list[l-1-i];
        }

        return answer;
    }

    public static int find(double[] list, double x){
        for (int i = 0; i < list.length; i++) {
            if(x==list[i]) return i;
        }
        return -1; //없으면
    }

    public static int[] rank(double[] list){
        int l = list.length;
        int[] answer = new int[l];

        double[] ordered = Arrays.copyOf(list,l); //깊은복사
        Arrays.sort(ordered);
        ordered = reverse(ordered);

        for (int i = 0; i < l; i++) {
            // list[i]가 ordered에서의 index를 answer[i]에 할당
            answer[i] = find(ordered,list[i])+1;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] score = {{80,70},{70,80},{30,50},{90,100},{100,90},{100,100},{10,30}};
        int l = score.length;
        double[] means = new double[l];

        for (int i = 0; i < l; i++) {
//            means[i] = Arrays.stream(score[i]).sum()/2; // 평균매기기 - int값이 문제가 있는것 같다.
            means[i] = Arrays.stream(score[i]).sum(); // 합계로 대체 - (등수)결과에 영향X
        }

        int[] result = rank(means);

        for (int i:result){
            System.out.println(i);
        }



        }




    }

