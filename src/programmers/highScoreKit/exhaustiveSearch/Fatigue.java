package programmers.highScoreKit.exhaustiveSearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Fatigue { // 피로도


    public static void main(String[] args) {
        int k = 80; // 남은 피로도
        int[][] dungeons = {{80,20},{50,40},{30,10}}; // [최소필요 피로도, 소모 피로도], 1~8개
        // 탐험할 수 있는 최대 던전 수

//        Arrays.sort(dungeons, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
////                return 0; // 음수-앞, 양수-뒤
//                if(o1[1] != o2[1]) return o1[1] - o2[1]; // 오름차순(작은값 우선)
//                else return o1[0] - o2[0];
//
//            }
//        });
//        // 정렬확인
//        for(int[] array:dungeons){
//            System.out.println(array[0] + "," + array[1]);
//        }
//
//        int count=0;
//        int fatigue=0;
//        for(int[] dungeon:dungeons){
//            fatigue += dungeon[1];
//            if(fatigue >= k) break;
//            count++;
//        }

        // 최대 8개에 해당하는 원소를 나열하는 모든 경우의 수(완전탐색)에 대한 연산








    }

}
