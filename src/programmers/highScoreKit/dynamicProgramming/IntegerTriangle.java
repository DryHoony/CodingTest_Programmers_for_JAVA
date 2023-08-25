package programmers.highScoreKit.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerTriangle { // 정수삼각형
    // 아깝다! >> 정확성ok but 효율성 딱! 하나 실패(시간 초과)
    // 연산조금 수정, List >> Array 로 변경 (출력, 검색속도 향상 기대)

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        // 연산용 변수
        int l = triangle.length;
        int[] previousLevel;
        int[] nextLevel;
        int[] floor;
//        int left;
//        int right;

        // 첫째줄 등록
        previousLevel = triangle[l-1];

        // 본연산 - previousLevel 기준이 아니라 triangle 기준으로 해보자
        for (int i = l-2; i >= 0; i--) {
            floor = triangle[i]; // 길이 i+1
            nextLevel = new int[i+1];

            // nextLevel 좌우 연산 한번에 시도 - max 값 할당
            for (int j = 0; j < i+1; j++) {
//                left = previousLevel[j] + floor[j]; // 왼쪽
//                right = previousLevel[j+1] + floor[j]; // 오른쪽
//                nextLevel[j] = Math.max(left, right);
                nextLevel[j] = Math.max(previousLevel[j], previousLevel[j+1]) + floor[j];


            }
            previousLevel = nextLevel.clone(); // 깊은복사

//            nextLevel = new int[i+1]; // newLevel 도 초기화 되는지 확인
        }

        System.out.println("답은 = " + previousLevel[0]);

    }


    public static void main0(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        // 연산용 변수
        int l = triangle.length;
        ArrayList<Integer> previousLevel = new ArrayList<>();
        ArrayList<Integer> nextLevel = new ArrayList<>();
        int left;
        int right;

        // 첫째줄 등록
        for(int n:triangle[l-1]){
            previousLevel.add(n);
        }

        // 본연산
        for (int i = l-2; i >=0 ; i--) {

            // nextLevel 좌우 연산 한번에 시도 - max값 할당
            for (int j = 0; j < i+1; j++) {
                left = previousLevel.get(j) + triangle[i][j]; // 왼쪽
                right = previousLevel.get(j+1) + triangle[i][j]; // 오른쪽
                nextLevel.add(Math.max(left,right));
            }
            System.out.println("중간점검 i = "+i + " >> nextLevel = " + nextLevel);


            previousLevel.clear();
            previousLevel = (ArrayList<Integer>) nextLevel.clone();

            nextLevel.clear();

        }

        System.out.println("previousLevel 에 마지막남은 하나가 답" + previousLevel.get(0));
    }

}
