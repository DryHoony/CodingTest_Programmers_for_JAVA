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

//    public static void main(String[] args) {
//        int n = 5;
//        int[] stages = {2,1,2,6,2,4,3,3};
//        double[] answer = new double[n];
//
//        double x;
//        double y = stages.length;
//
//        // answer에 성공률 할당
//        for (int i = 0; i < n; i++) {
//            x = y;
//            y -= count(stages,i+1); // stages에서 i+1의 갯수
//            answer[i] = y/x;
//        }
//
////        for (double d:answer){
////            System.out.println(d);
////        }
//
//        // 낮은 성공률 순으로 statge번호를 출력, 공동X, answer에서 낮은부터 출력
//        double[][] answer2 = new double[answer.length][];
//        for (int i = 0; i < answer.length; i++) {
//            answer2[i] = new double[]{answer[i], i+1};
//        }
//
//        arrange2Double(answer2);
//
////        for(double[] d:answer2){
////            System.out.println(d[0] + "," + d[1]);
////        }
//
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = (int) answer2[i][1];
//            System.out.println((int) answer2[i][1]);
//        }
//
//
//
//
//    }

    public static void main(String[] args) { // 성공!!!
        // 실패율
        // https://school.programmers.co.kr/learn/courses/30/lessons/42889

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages = {4,4,4,4,4};

        int total = 0; // 전체인원수
        for(int i:stages){
            total ++;
        }

        // 각 Stage 의 현재 player 수 (분자)
        int[] stagePlayerCount = new int[N+1];
        for(int i:stages){
            stagePlayerCount[i-1]++;
        }
        // stagePlayerCount 확인 ok


        // failure 계산
        float[][] failure = new float[N][]; // 유리수(실수)
        for (int i = 0; i < N; i++) {
            if(total == 0){ // total 분모값이 0이 되면? - 실패율을 0으로 정의함
                failure[i] = new float[] {i+1, 0};
            }
            else {
                failure[i] = new float[] {i+1, (float) stagePlayerCount[i] / total};
                total -= stagePlayerCount[i];
            }
        }

        // failure 정렬 - failure[][1] 값이 큰 순서대로 정렬, 같으면 failure[][0] 값이 작은것이 우선
        Arrays.sort(failure, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if(o1[1] == o2[1]){
                    return (int) (o1[0] - o2[0]);
                }
                else if (o1[1] > o2[1]){
                    return -1; // return o1[1] - o2[1]; // 오름차순
                } else if (o1[1] < o2[1]) {
                    return 1;
                }
                System.out.println("compare 삼일률 오류!!!!");
                return 0;
            }
        });


        // failure 정렬 확인 - ok
        for (float[] f:failure){
            System.out.println(f[0] + ", " + f[1]);
        }


        int[] answer = new int[N]; // 실패율 - 내림차순 (중복시 스테이지 번호 작은 순)
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failure[i][0];
        }

        System.out.println("answer 순서 확인");
        for(int i:answer){
            System.out.println(i);
        }

    }


}
