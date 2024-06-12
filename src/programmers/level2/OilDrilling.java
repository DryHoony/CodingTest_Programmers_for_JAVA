package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class OilDrilling { // 석유 시추

    public static void main(String[] args) {
        int[][] land; // 세로길이 <=500, 가로길이 <= 500
        // 0은 빈 땅, 1은 석유가 있는 땅
        int result; // 가장 많은 석유를 뽑을 수 있는 col 을 return

        // case1
        land = new int[][]
                {{0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}};
        result = 9;

        // case2
//        land = new int[][] {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
//        result = 16;
    }

    public static int solution(int[][] land){
        int n = land.length; // 세로길이
        int m = land[0].length; // 가로길이
        ArrayList<int[]>[] widthMassArray = new ArrayList[n]; // [i] 칸에 해당되는 withMass 는 [s,e]


        // step1 각 덩어리 구분 -> 각 덩어리 사이즈, 및 해당 칼럼
        // step1.1 land 가로 탐색 -> 가로 덩어리 표기
        // step1.2 가로 덩어리의 세로 연결 -> 최종 덩어리 도출





        // step2 칼럼별 해당 덩어리 사이즈 합 도출, Max 값이 답


        return 0;
    }
}
