package programmers.level2;

public class N_Queen { // N-Queen

    static int answer=0;
    static int N;

    public static void main(String[] args) {
        int n = 4; // 1~12

        // 본연산
        N = n;
        queenCalculate(n);

//        // queenConquer test
//        boolean[][] chessBoard = new boolean[n][n];
//        queenConquer(chessBoard, 2,1);


        System.out.println("답은 = " + answer);
    }

    static void queenCalculate(int n){
        boolean[][] chessBoard = new boolean[n][n];
        for (int i = 0; i < n; i++) { // true 로 초기화
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = true;
            }
        }

        queenCalculateRecursion(chessBoard, 0);
    }

    static void queenCalculateRecursion(boolean[][] chessBoard, int k){ // chessBoard 에서 k번째 줄 연산
        System.out.println(k + "번째 줄 연산 ----------------");

        if(k == N-1){ // 종료조건
            for (int i = 0; i < N; i++) {
                if(chessBoard[k][i]){
                    answer++;
                    return; // 정상종료
                }
            }
            return; // 비정상종료
        }



        for (int i = 0; i < N; i++) {
            if(chessBoard[k][i]){
                // 재귀 - 가능한 [k][i]에 대해 모두 재귀 실행
                System.out.println("["+k+"]["+i+"]" + "에서 퀸 연산 및 재귀 실행");
                queenCalculateRecursion(queenConquer(chessBoard, k,i), k+1);
            }
        }

    }

    static boolean[][] queenConquer(boolean[][] chessBoard, int i, int j){
        System.out.println("["+i+"]["+j+"]" + "에서 재귀전에 퀸 정복연산");

        // chessBoard[i][j]에 퀸 범위(정복)연산 >> false 할당
        for (int k = 0; k < N; k++) {
            chessBoard[i][k] = false;
            chessBoard[k][j] = false;
            System.out.println("["+i+"]["+k+"]" + "false");
            System.out.println("["+k+"]["+j+"]" + "false");
        }

        // (오른쪽 위)대각
        for (int x = 0; x <= i+j; x++) {
            int y = i+j-x;
            if(y>=0 && y<N){
                chessBoard[y][x] = false;
                System.out.println("["+y+"]["+x+"]" + "우상대각 false");
            }
        }

        // (오른쪽 위)대각
        for (int x = 0; x < N; x++) {
            int y = x+i-j;
            System.out.println("우하대각 연산 test >> " + y+", "+x);
            if(y>=0 && y<N){
                chessBoard[y][x] = false;
                System.out.println("["+y+"]["+x+"]" + "우하대각 false");
            }
        }
        return chessBoard;
    }

}
