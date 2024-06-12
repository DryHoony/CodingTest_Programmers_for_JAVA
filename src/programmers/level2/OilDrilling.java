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

        // case3
//        land = new int[][] {{1,0},{0,1}};
//        result = 1;

        solution(land);
    }

    public static int solution(int[][] land){
        int n = land.length; // 세로길이
        int m = land[0].length; // 가로길이

        // step1 각 덩어리 구분 -> 각 덩어리 사이즈, 및 해당 칼럼
        ArrayList<int[]>[] widthOilMassArray = new ArrayList[n]; // [i] 칸에 해당되는 withMass 는 [s,e]
        for (int i = 0; i < n; i++) {
            widthOilMassArray[i] = new ArrayList<>();
        }
        int[] oil;
        boolean newFlag;
        // step1.1 land 가로 탐색 -> 가로 덩어리 표기
        for (int i = 0; i < n; i++) { // 세로
            newFlag = true;
            oil = new int[2];
            System.out.println();
            System.out.println(i + "행 탐색");

            for (int j = 0; j < m; j++) { // 가로 탐색
                if(land[i][j] == 1){ // oil
//                    System.out.println(" 기름이다!");
                    if(newFlag){ // oil 시작
//                        System.out.println("  oil 시작");
                        oil = new int[2]; // 여기서 미리 widthOilMassArray 에 할당?? >> 테스트
                        widthOilMassArray[i].add(oil);
                        oil[0] = j;
                        oil[1] = j; // 한칸 대비
                        newFlag = false;
                    }else{ // oil 계속
//                        System.out.println("  oil 계속");
                        oil[1] = j;
                    }
                }else { // oil X
                    if(newFlag){
                        continue;
                    }else{ // oil 끝
//                        System.out.println("  oil 끝");
                        newFlag = true;
//                        System.out.println(i + "행의 oil = [" + oil[0] + "," + oil[1]+"]");
                    }
                }
            }
            for(int[] oilPrint:widthOilMassArray[i]){
                System.out.println(oilPrint[0] + ", " + oilPrint[1]);
            }
        }
        // case 1~3 ok

        // step1.2 가로 덩어리의 세로 연결 -> 최종 덩어리 도출






        // step2 칼럼별 해당 덩어리 사이즈 합 도출, Max 값이 답


        return 0;
    }
}
