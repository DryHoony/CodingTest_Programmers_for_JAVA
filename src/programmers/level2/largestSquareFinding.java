package programmers.level2;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Stack;

public class largestSquareFinding { // 가장 큰 정사각형 찾기

    // ver1 : 완전탐색 - 좌상단 꼭지점 기준으로 최대 정사각형 찾기 >> 효율성 fail
    public static void main1(String[] args) {
        int[][] board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] board = new int[][]{{0,0,1,1},{1,1,1,1}};
//        int[][] board = new int[][]{{0,0,0,0},{0,0,0,0}};


        // 연산용 변수
        int largestLength = 0;
        int nowLength;

        // 본 연산
        for (int i = 0; i < board.length; i++) {
            if(i+largestLength > board.length) break;
            for (int j = 0; j < board[0].length; j++) {
                if(j+largestLength > board[0].length) break;

                if(board[i][j] == 1){ // 꼭지점
                    nowLength=0;

                    // 핵심연산 - [i][j] 왼쪽상단으로 하는 정사각형 탐색 연산
                    rectangleSearch :
                    while (i+nowLength+1 < board.length & j+nowLength+1 < board[0].length){
                        nowLength++;
                        for (int k = 0; k <= nowLength; k++) {
                            // 행 탐색
                            if(board[i+k][j+nowLength]==0){
                                nowLength--;
                                break rectangleSearch;
                            }
                            // 열 탐색
                            if(board[i+nowLength][j+k]==0){
                                nowLength--;
                                break rectangleSearch;
                            }
                        }
                    }
                    // largestLength 는 꼭지점으로부터 추가된 칸 수를 계산했으므로 +1 필요
                    if(nowLength+1 > largestLength) largestLength = nowLength+1;
                }

                // 남은 길이보다 largestLength 가 크거나 같으면 연산(조기)종료
            }
        }


        System.out.println("답은 = " + largestLength*largestLength);
    }


    // ver2 : 0,1을 boolean 타입으로 변경, 연산(탐색)방법은 ver1 과 같음 >> 효율성 fail (ver1과 비슷한듯)
    public static void main2(String[] args) {
//        int[][] board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] board = new int[][]{{0,0,1,1},{1,1,1,1}};
        int[][] board = new int[][]{{0,0,0,0},{0,0,0,0}};

        // 연산용 변수
        boolean[][] boardBool = new boolean[board.length][board[0].length]; // input 데이터를 boolean 타입으로 변경
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==1) boardBool[i][j] = true;
            }
        }
        int largestLength = 0;
        int nowLength;


        // 본 연산
        for (int i = 0; i < boardBool.length; i++) {
            if(i+largestLength > boardBool.length) break;
            for (int j = 0; j < boardBool[0].length; j++) {
                if(j+largestLength > boardBool[0].length) break;

                if(boardBool[i][j]){ // 꼭지점
                    nowLength=0;

                    // 핵심연산 - [i][j] 왼쪽상단으로 하는 정사각형 탐색 연산
                    rectangleSearch :
                    while (i+nowLength+1 < boardBool.length & j+nowLength+1 < boardBool[0].length){
                        nowLength++;
                        for (int k = 0; k <= nowLength; k++) {
                            // 행 탐색
                            if(!boardBool[i+k][j+nowLength]){
                                nowLength--;
                                break rectangleSearch;
                            }
                            // 열 탐색
                            if(!boardBool[i+nowLength][j+k]){
                                nowLength--;
                                break rectangleSearch;
                            }
                        }
                    }
                    // largestLength 는 꼭지점으로부터 추가된 칸 수를 계산했으므로 +1 필요
                    if(nowLength+1 > largestLength) largestLength = nowLength+1;
                }

                // 남은 길이보다 largestLength 가 크거나 같으면 연산(조기)종료
            }
        }


        System.out.println("답은 = " + largestLength*largestLength);
    }

    // ver3 - 디버깅 필요!!
    // 각 행의 가능한 변위를 어떻게 표현하는게 효율적일까?, 어떤 구조여야 나중에 연산이 편할까?
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] board = new int[][]{{0,0,1,1},{1,1,1,1}};
//        int[][] board = new int[][]{{0,0,0,0},{0,0,0,0}};
//        int[][] board = new int[][]{{0,1,1,1,0,0,1,1,0,1},{0,1,1,1,0,0,1,1,0,1},{0,1,1,1,0,0,1,1,0,1}};

        // 연산용 변수
        int rowLength = board.length;
        int colLength = board[0].length;
        boolean lineStartFlag; // 새로운 line 유무 판단
        int[] nowLine = new int[4]; // 변수 선언
        int answerLength=0;

        // 각 행은 한번만 탐색할것!
        // 자료구죠 - [i행, j행, 좌, 우] : [i행~j행 에서 시작해서 좌~우까지 가능]
        ArrayList<int[]> lineList = new ArrayList<>();

        // 첫행 우선 연산
        lineStartFlag = true;
        for (int j = 0; j < colLength; j++) {
            if(board[0][j]==1){
                if (lineStartFlag){
                    nowLine = new int[3];
                    lineList.add(nowLine); // 변위 할당
                    nowLine[0] = 0; // 0번째 행
                    nowLine[1] = j; // j번째 col 에서 시작
                    nowLine[2] = colLength-1; // for문 끝까지 돌경우, 초기 할당값 유지
                    lineStartFlag = false;
                }else {
                    continue;
                }
            }else if (!lineStartFlag){ // board[0][j]==0
                nowLine[2] = j-1;
                lineStartFlag = true;
            }
        }
        if(!lineList.isEmpty()) answerLength=1; // 하나라도 들어있으면 일단 1정사각형 확보

        // 첫행 할당 확인 >> ok
        for (int[] line:lineList){
            System.out.println("행 좌 우");
            for (int i:line){
                System.out.print(i + " ");
            }
            System.out.println();
        }


        // 본 연산
        Stack<int[]> preLineStack = new Stack<>();
        Stack<int[]> nowLineStack = new Stack<>();
        int[] newLine;


        for (int i = 1; i < rowLength; i++) { // i행
            if(i+answerLength > rowLength) break;
            // i행 탐색준비
            for (int[] line:lineList){
                preLineStack.add(line);
            }
            lineList = new ArrayList<>(); // 초기화

            lineStartFlag = true;
            for (int j = 0; j < colLength; j++) { // j열 - 첫행 우선 연산과 유사
                if(j+answerLength > colLength) break;
                // 첫행 우선 복사 >> 수정
                if(board[i][j]==1){
                    if (lineStartFlag){
                        nowLine = new int[2]; // 좌~우
                        nowLineStack.add(nowLine);
                        nowLine[0] = j; // j번째 col 에서 시작
                        nowLine[1] = colLength-1; // for문 끝까지 돌경우, 초기 할당값 유지
                        lineStartFlag = false;
                    }else {
                        continue;
                    }
                }else if (!lineStartFlag){ // board[0][j]==0
                    nowLine[1] = j-1;
                    lineStartFlag = true;
                }
            }

            // 최소길이 1 할당 - 아래에서 정사각형은 최소길이 2부터 연산
            if(!nowLineStack.isEmpty() & answerLength==0) answerLength=1;

            // 핵심! - i행 탐색완료 후 연산 - preLineStack * nowLineStack 가능한 조합 >> lineList 에 할당, 이때 answerLength 로 필터링
            while (!nowLineStack.isEmpty()){
                nowLine = nowLineStack.pop();
                for (int[] preLine:preLineStack){
                    // preLine[새작행,좌, 우], nowLine[좌,우]
                    if(preLine[2] <= nowLine[0] || nowLine[1] <= preLine[1]) break;
                    else if(preLine[2] > nowLine[0]){ // preLine - nowLine
                        int a = preLine[2]-nowLine[0] +1; // 가로길이
                        int b = i - preLine[0] +1; // 세로길이
                        if(Math.max(a,b) > answerLength){ // 현재 답보다 더 큰 사이즈만
                            answerLength = Math.max(a,b);
                            // 할당
                            newLine = new int[3]; // [시작행, 좌, 우]
                            newLine[0] = preLine[0];
                            newLine[1] = nowLine[0];
                            newLine[2] = preLine[2];
                            lineList.add(newLine);
                        }


                    }else { // nowLine[1] > preLine[1] // nowLine-preLine
                        int a = nowLine[1] - preLine[1] +1; // 가로길이
                        int b = i - preLine[0] +1; // 세로길이
                        if(Math.max(a,b) > answerLength){ // 현재 답보다 더 큰 사이즈만
                            answerLength = Math.max(a,b);
                            // 할당
                            newLine = new int[3]; // [시작행, 좌, 우]
                            newLine[0] = preLine[0];
                            newLine[1] = nowLine[0];
                            newLine[2] = preLine[2];
                            lineList.add(newLine);
                        }
                    }


                }
            }
            preLineStack.clear();

        }


        int answer = answerLength*answerLength;
        System.out.println("답은 = " + answer);
    }
}
