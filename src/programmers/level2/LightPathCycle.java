package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LightPathCycle { // 빛의 경로 사이클

    public static void main(String[] args) { // 통과! - 속도 차이 꽤 난다! >> (나중에) 복잡도 계산 한번 해보자
//        String[] grid = {"SL", "LR"}; // 길이 1~500, 문자열 길이는 모두 동일하며 1~500
        String[] grid = {"S"};

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


        boolean[][][] visitedBoolean = new boolean[n][l][4]; // [i][j] 격자에서 [k]방향 방문 여부
        Stack<int[]> visitedStack = new Stack<>(); // {i,j,k}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < 4; k++) {
                    visitedStack.push(new int[] {i,j,k});
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>(); // 각 사이클의 길이, 오름차순 정렬

        int[] nowGrid = new int[3]; // 현재 격자(위치)
        int cycleLength;

        // visited 에서 출발 격자,방향 탐색(설정), cycle 시작값 설정
        mainOperation : while(!visitedStack.isEmpty()){

            nowGrid = visitedStack.pop();

            while (visitedBoolean[nowGrid[0]][nowGrid[1]][nowGrid[2]]){
                if(visitedStack.isEmpty()) break mainOperation;

                nowGrid = visitedStack.pop();
//                System.out.println(nowGrid[0]+", " + nowGrid[1] + ", " + nowGrid[2]);

            }


            cycleLength=0;
            // cycle 연산 - nowGrid[i][j] 에서 nowGrid[k] 방향으로 ㄱ
            while(!visitedBoolean[nowGrid[0]][nowGrid[1]][nowGrid[2]]){ // 종료조건 설정
                System.out.println("(" + nowGrid[0] + ", " + nowGrid[1] + ") 에서 " + nowGrid[2] + "방향으로 연산");

                cycleLength++; // 실제연산(건너감)
                visitedBoolean[nowGrid[0]][nowGrid[1]][nowGrid[2]] = true;

                // 다음격자 계산 >> nowGrid 에 할당
                switch (nowGrid[2]){
                    case 0:
                        System.out.println("위");
                        if(nowGrid[0] == 0) nowGrid[0] = n-1;
                        else nowGrid[0]--;
                        break;
                    case 2:
                        System.out.println("아래");
                        if(nowGrid[0] == n-1) nowGrid[0] = 0;
                        else nowGrid[0]++;
                        break;
                    case 1:
                        System.out.println("우");
                        if(nowGrid[1] == l-1) nowGrid[1] = 0;
                        else nowGrid[1]++;
                        break;
                    case 3:
                        System.out.println("좌");
                        if(nowGrid[1] == 0) nowGrid[1] = l-1;
                        else nowGrid[1]--;
                        break;
                }

                // nowGrid 의 격자함수값 연산 >> nowGrid[2] 에 할당 (다음 진행할 방향)
                nowGrid[2] += gridFunction[nowGrid[0]][nowGrid[1]];
                if(nowGrid[2] == -1) nowGrid[2]=3;
                else if (nowGrid[2] == 4) nowGrid[2]=0;

            }

            // 답에 할당
            answer.add(cycleLength);
        }


        Collections.sort(answer); // 오름차순 정렬
        // 정답 형태인 int[] 로 변경
        System.out.println("답은 = " + answer);





    }

    public static void main0(String[] args) { // 실패(시간초과) - 7,9,10,11
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

        // visited 에서 출발 격자,방향 탐색(설정), cycle 시작값 설정
        while(true){
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
            if(finish) break; // 종료조건



            // cycle 연산 - nowGrid[i][j] 에서 direction 방향으로 ㄱ
            while(!visited[nowGrid[0]][nowGrid[1]][direction]){ // 종료조건 설정
                System.out.println("(" + nowGrid[0] + ", " + nowGrid[1] + ") 에서 " + direction + "방향으로 연산");

                cycleLength++; // 실제연산(건너감)
                visited[nowGrid[0]][nowGrid[1]][direction] = true;

                // 다음격자 계산 >> nowGrid 에 할당
                switch (direction){
                    case 0:
                        System.out.println("위");
                        if(nowGrid[0] == 0) nowGrid[0] = n-1;
                        else nowGrid[0]--;
                        break;
                    case 2:
                        System.out.println("아래");
                        if(nowGrid[0] == n-1) nowGrid[0] = 0;
                        else nowGrid[0]++;
                        break;
                    case 1:
                        System.out.println("우");
                        if(nowGrid[1] == l-1) nowGrid[1] = 0;
                        else nowGrid[1]++;
                        break;
                    case 3:
                        System.out.println("좌");
                        if(nowGrid[1] == 0) nowGrid[1] = l-1;
                        else nowGrid[1]--;
                        break;
                }

                // nowGrid 의 격자함수값 연산 >> direction 에 할당 (다음 진행할 방향)
                direction += gridFunction[nowGrid[0]][nowGrid[1]];
                if(direction == -1) direction=3;
                else if (direction == 4) direction=0;

            }

            // 답에 할당
            answer.add(cycleLength);
        }




        Collections.sort(answer); // 오름차순 정렬
        // 정답 형태인 int[] 로 변경
        System.out.println("답은 = " + answer);
    }
}
