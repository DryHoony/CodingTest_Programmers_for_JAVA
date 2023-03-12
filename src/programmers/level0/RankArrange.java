package programmers.level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static int[] rank(double[] list){ // 높은값 순으로 index+1 나열, 중복시 공동등수
        int l = list.length;
        int[] answer = new int[l];

        double[] ordered = Arrays.copyOf(list,l); //깊은복사
        Arrays.sort(ordered);
        ordered = reverse(ordered); // 내림차순

        for (int i = 0; i < l; i++) {
            // list[i]가 ordered에서의 index를 answer[i]에 할당
            answer[i] = find(ordered,list[i])+1;
        }

        return answer;
    }

    // 이차원 정렬

    // Map<,> 이용 ver - 주어진 값을 key 로 해당 index 를 value 에 담는다
    // 중복은 처리못함 - key 값이 겹치기에 중복 처리 X
    public static int[] rank2(int[] list){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (!map.containsKey(list[i]))
                map.put(list[i],i);
        }

        Integer[] keyList = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keyList); // 오름차순
        keyList = reverseIntArray(keyList); // 내림차순

        int[] answer = new int[list.length];
        // list 의 원소의 등수(큰 순서)에 해당하는 index 할당
        int i=1;
        for (int n:keyList){
            answer[map.get(n)] = i; // key 값에 해당하는 원소는 i등
            i++;
        }

        return answer;
    }

    public static Integer[] reverseIntArray(Integer[] list){
        int l = list.length;
        Integer[] answer = new Integer[l];

        for (int i = 0; i < l; i++) {
            answer[i] = list[l-1-i];
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

