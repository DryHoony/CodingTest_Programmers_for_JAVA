package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LightPathCycle { // 빛의 경로 사이클

    public static void main(String[] args) {
        String[] grid = {"SL", "LR"}; // 길이 1~500, 문자열 길이는 모두 동일하며 1~500
        // 격자 S L R = 직진, 좌회전, 우회전
        // 각 순환 사이클의 길이 return



        // 연산용 변수
        int n = grid.length; // 행
        int l = grid[0].length(); // 열
        // 격자의 갯수는 n*l, 모든 경로의 갯수 n*l*4
        int[][] gridFunction = new int[n][l]; // 각 격자의 방향 함수
        // 함수값 할당
        for (int i = 0; i < n; i++) {
            String str = grid[i]; // i 행
            for (int j = 0; j < l; j++) {
                switch (str.charAt(j)){
                    case 'S':
                        gridFunction[i][j] = 0; // 직진
                        break;
                    case 'L':
                        gridFunction[i][j] = -1; // 좌회전
                        break;
                    case 'R':
                        gridFunction[i][j] = 1; // 우회전;
                        break;
                }
            }
        }


        boolean[][][] visited = new boolean[n][l][4]; // [i][j] 격자에서 [k]방향 방문 여부
        ArrayList<Integer> answer = new ArrayList<>(); // 각 사이클의 길이, 오름차순 정렬

        int[] nowGrid = new int[2]; // 현재 격자(위치)
        int direction=0; // 방향 0,1,2,3
        int cycleLength=0;
        boolean finish = false;

        while(!finish){
            // visited 에서 출발 격자,방향 탐색(설정), cycle 시작값 설정
            finish = true;
            gridSearch : for (int i = 0; i < n; i++) {
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < 4; k++) {
                        if(!visited[i][j][k]){
                            nowGrid[0] = i;
                            nowGrid[1] = j;
                            direction = k;
                            cycleLength=0;

                            finish = false;
                            break gridSearch;
                        }
                    }
                }
            }
            // nowGrid[i][j] 에서 direction 방향으로 ㄱ

            // cycle 연산
            while(!visited[nowGrid[0]][nowGrid[1]][direction]){ // 종료조건 설정
                cycleLength++; // 실제연산(건너감)

                // 다음격자 계산 >> nowGrid 에 할당
                switch (direction){
                    case 0:
//                        System.out.println("위");
                        if(nowGrid[0] == 0) nowGrid[0] = n-1;
                        else nowGrid[0]--;
                        break;
                    case 2:
                        System.out.println("아래");
                        break;
                    case 1:
                        System.out.println("우");
                        break;
                    case 3:
                        System.out.println("좌");
                        break;
                }

                // nowGrid 의 격자함수값 연산 >> direction에 할당


            }

            // 답에 할당
            answer.add(cycleLength);

        }




        Collections.sort(answer); // 오름차순 정렬
        // 정답 형태인 int[] 로 변경
        System.out.println("답은 = " + answer);
    }
}
