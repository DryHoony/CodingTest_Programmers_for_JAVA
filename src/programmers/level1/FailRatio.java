package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class FailRatio { // 실패율 Kakao 기출 https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java

    public static int count(int[] list, int n){
        int answer = 0;
        for(int i:list){
            if(i==n) answer++;
        }
        return answer;
    }

    // 이차원 배열 정렬 double
    public static double[][] arrange2Double(double[][] list){
        Arrays.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) return 1;
                    else if(o1[1] == o2[1]) return 0;
                    else return -1;
                }else if(o1[0] > o2[0]) return 1;
                else return -1;
            }
        });

        return list;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        double[] answer = new double[n];

        double x;
        double y = stages.length;

        // answer에 성공률 할당
        for (int i = 0; i < n; i++) {
            x = y;
            y -= count(stages,i+1); // stages에서 i+1의 갯수
            answer[i] = y/x;
        }

//        for (double d:answer){
//            System.out.println(d);
//        }

        // 낮은 성공률 순으로 statge번호를 출력, 공동X, answer에서 낮은부터 출력
        double[][] answer2 = new double[answer.length][];
        for (int i = 0; i < answer.length; i++) {
            answer2[i] = new double[]{answer[i], i+1};
        }

        arrange2Double(answer2);

//        for(double[] d:answer2){
//            System.out.println(d[0] + "," + d[1]);
//        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (int) answer2[i][1];
            System.out.println((int) answer2[i][1]);
        }




    }
}
