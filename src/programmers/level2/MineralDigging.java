package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class MineralDigging { // 광물캐기
    // 곡괭이 최대 사용횟수 5회, 한 번 사용하기 시작한 곡괭이는 5회 연속사용
    // 종료조건 2가지 - 노든 광물 캐기 or Out of 곡괭이

    static int[][] diggingFatigue;

    public static void main(String[] args) {
        int[] picks = {1,3,2}; // 다이아, 철, 돌 0~5
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}; // 5~50


        int workNumber = (minerals.length-1)/5+1;
        int gokN = picks[0]+picks[1]+picks[2];
        // minerals 셋팅
//        int[][] diggingFatigue = new int[l/5][3]; // int[다이아, 철, 돌] 곡괭이 연산 피로도 array
        diggingFatigue = new int[workNumber][3];
        for (int i = 0; i < minerals.length; i++) {
            if(i/5 == gokN) break;
            if(minerals[i].equals("diamond")){ // 다이아 광물
                diggingFatigue[i/5][0] += 1; // 다이아 곡괭 피로도
                diggingFatigue[i/5][1] += 5; // 철 곡괭 피로도
                diggingFatigue[i/5][2] += 25; // 돌 곡괭 피로도
            } else if (minerals[i].equals("iron")) { // 철 광물
                diggingFatigue[i/5][0] += 1;
                diggingFatigue[i/5][1] += 1;
                diggingFatigue[i/5][2] += 5;
            } else if (minerals[i].equals("stone")) { // 돌 광물
                diggingFatigue[i/5][0] += 1;
                diggingFatigue[i/5][1] += 1;
                diggingFatigue[i/5][2] += 1;
            }

        }

        // diggingFatigue >> (돌)피로도가 높은 순으로 정렬
        Arrays.sort(diggingFatigue, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2]; // 내림차순
            }
        });

        // 연산 - 순서대로 (피로도가 높은 값에) 다이아 곡괭이 부터 사용
        int minFatigueCount=0; // 피로도 >> 최소값 return
        int workIndex=0;
        // 종료조건 2가지 - 곡괭이 모두 사용 or 작업완료
        while(workIndex < workNumber){ // 작업완료시 까지

            if(workIndex < picks[0]){
                // 다이아 곡괭 연산
                minFatigueCount += diggingFatigue[workIndex][0];
                workIndex++;
            } else if (workIndex < picks[0]+picks[1]) {
                // 철 곡괭 사용
                minFatigueCount += diggingFatigue[workIndex][1];
                workIndex++;
            } else if (workIndex < picks[0]+picks[1]+picks[2]) {
                // 돌 곡괭 사용
                minFatigueCount += diggingFatigue[workIndex][2];
                workIndex++;
            } else{
                // 곡괭이 모두 사용 - 연산종료
                break;
            }
        }





        System.out.println("답은 >> " + minFatigueCount);
    }

    public static void main0(String[] args) {
        int[] picks = {1,3,2}; // 다이아, 철, 돌 0~5
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}; // 5~50

        int l = minerals.length;
        // minerals 셋팅
//        int[][] diggingFatigue = new int[l/5][3]; // int[다이아, 철, 돌] 곡괭이 연산 피로도 array
        diggingFatigue = new int[(l-1)/5+1][3];
        for (int i = 0; i < l; i++) {
            if(minerals[i].equals("diamond")){ // 다이아 광물
                diggingFatigue[i/5][0] += 1; // 다이아 곡괭 피로도
                diggingFatigue[i/5][1] += 5; // 철 곡괭 피로도
                diggingFatigue[i/5][2] += 25; // 돌 곡괭 피로도
            } else if (minerals[i].equals("iron")) { // 철 광물
                diggingFatigue[i/5][0] += 1;
                diggingFatigue[i/5][1] += 1;
                diggingFatigue[i/5][2] += 5;
            } else if (minerals[i].equals("stone")) { // 돌 광물
                diggingFatigue[i/5][0] += 1;
                diggingFatigue[i/5][1] += 1;
                diggingFatigue[i/5][2] += 1;
            }

        }


        // 연산용 변수
        int minFatigue=0; // 피로도 >> 최소값 return
        l = Math.min((l-1)/5+1, picks[0]+picks[1]+picks[2]); // 종료조건 - 광물 다캐기 or 곡괭이 떨어짐
        int[] dig = new int[l]; // 곡괭이 배치 - 갯수만큼만 할당
        for (int i = 0; i < picks[0]; i++) { // 다이아 곡
            if(i >= l) break;
            dig[i] = 0; // 다이아 곡괭
        }
        for (int i = picks[0]; i < picks[0]+picks[1]; i++) {
            if(i >= l) break;
            dig[i] = 1; // 철 곡괭
        }
        for (int i = picks[0]+picks[1]; i < picks[0] + picks[1] + picks[2]; i++) {
            if(i>=l) break;
            dig[i] = 2; // 돌 곡괭
        }

        // dig 곡굉이 배치 - 순열 연산 완전탐색
        // 각각의 fatigue 연산
        System.out.println(countFatigue(dig));

        System.out.println("답은 >> " + minFatigue);
    }

    public static int countFatigue(int[] dig){
        int fatigue=0;

        for (int i = 0; i < dig.length; i++) {
             fatigue += diggingFatigue[i][dig[i]];
//            System.out.println("fatigue = " + fatigue);
        }

        return fatigue;
    }
}
