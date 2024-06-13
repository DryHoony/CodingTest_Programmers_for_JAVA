package programmers.level2;

import java.util.*;

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

        solution1(land);
    }

    public static int solution1(int[][] land){
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
        Map<Integer, int[]> oilMassMap = new HashMap<>(); // Index - [크기, 왼쪽끝, 오른쪽끝]
        int oilIndex = 0;
        int[] oilMass;

        ArrayList<Integer> preOilIndexArr = new ArrayList<>(); // 이전행의 widthOilMass 의 Index List -> 겹칠때 Index 뽑아오기용
        ArrayList<Integer> nowOilIndexArr = new ArrayList<>();
        ArrayList<Set<Integer>> connectedIndexSetList = new ArrayList<>(); // 겹치는 Index -> Set 으로 묶음

        // step1.2.1 widthOilMassArray 의 각 행을 한번씩만 스캔 -> oilMassMap, connectedIndexSetList
        // 첫행 따로 연산 - 겹침X
        for(int[] widthOil : widthOilMassArray[0]){
            oilIndex++;
            oilMass = new int[]{widthOil[1]-widthOil[0]+1, widthOil[0], widthOil[1]}; // [크기, 왼쪽끝, 오른쪽끝]
            oilMassMap.put(oilIndex, oilMass);

            preOilIndexArr.add(oilIndex);
        }

        for (int i = 1; i < n; i++) {
            System.out.println(i + "행의 widthOil 탐색 시작");

            for(int[] widthOil : widthOilMassArray[i]){
                ArrayList<Integer> sameIndex = new ArrayList<>(); // 겹치는 Index 저장용

                // 윗층과 연결된 oilMass 탐색 -> sameIndex
                for (int j = 0; j < preOilIndexArr.size(); j++) { // 이전 oilIndex 값 = preOilIndexArr.get(j)
                    int[] preWidthOilMass = widthOilMassArray[i - 1].get(0);

                    if (preWidthOilMass[1] < widthOil[0] || widthOil[1] < preWidthOilMass[0]) {
                        // 단일 비연결
                        continue;

                    }else {
                        // 연결 -> 연결된 oilIndex -> sameIndex 에 할당
                        sameIndex.add(preOilIndexArr.get(j));
                    }
                }

                // sameIndex 연산
                if(sameIndex.size() == 0){
                    // 종합 비연결 -> oilIndex 새로 할당
                    oilIndex++;
                    oilMass = new int[]{widthOil[1]-widthOil[0]+1, widthOil[0], widthOil[1]}; // [크기, 왼쪽끝, 오른쪽끝]
                    oilMassMap.put(oilIndex, oilMass);

                    nowOilIndexArr.add(oilIndex);
                }
                else { // 연결된 sameIndex 처리>>
                    // 첫행 index 를 할당
                    // oilMassMap.get(sameIndex.get(0)) = [크기, x,y] 업데이트
                    // 구현필요

                    if(sameIndex.size() > 1){ // connectedIndexSetList
                        // 구현필요
                    }
                }
            }

            preOilIndexArr = nowOilIndexArr; // 다음연산 준비
            nowOilIndexArr = new ArrayList<>(); // 초기화

        }

        // step 1.2.1.1 connectedIndexSetList 의 Set 끼리 겹치는것이 있는지 확인!!!

        // step1.2.2 connectedIndexSetList 를 기준으로 oilMassMap 에서 뽑아서(제거) finalOilMass 를 도출
          int[] finalOilMass = new int[3]; // 바로 columnValue 계산
        // 도출한 finalOilMass 를 columnValue 에 연산
          int[] columnValue = new int[m]; // 이 중 Max 값이 답

        // step1.2.3 oilMassMap 에 남아있는 oilMass [크기, 왼쪽끝, 오른쪽끝] 를 columnValue 에 연산


        // step2 columnValue 의 최댓값 index 가 답!


        return 0;
    }
}
