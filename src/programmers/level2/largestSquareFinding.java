package programmers.level2;

public class largestSquareFinding { // 가장 큰 정사각형 찾기

    // ver1
    public static void main(String[] args) {
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

                if(board[i][j] == 1){
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
}
