package programmers.level2;

public class N_Queen { // N-Queen

    static int answer=0;
    static int N;

    public static void main(String[] args) {
        int n = 3; // 1~12


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
        printBoard(chessBoard);
        System.out.println(k + "번째 줄 연산 ----------------");

        if(k == N-1){ // 종료조건
            for (int i = 0; i < N; i++) {
                if(chessBoard[k][i]){
                    answer++;
//                    return; // 해당분기만 끝내는게 아니라 재귀 전체를 종료시켜버린다!!!
                }
            }
//            return; // 비정상종료
        }
        else{
            for (int i = 0; i < N; i++) {
                if(chessBoard[k][i]){
                    // 재귀 - 가능한 [k][i]에 대해 모두 재귀 실행
                    System.out.println("["+k+"]["+i+"]" + "에서 퀸 연산 및 재귀 실행");
                    boolean[][] branchChessBoard = queenConquer(chessBoard, k,i);
                    queenCalculateRecursion(branchChessBoard, k+1);
//                    queenCalculateRecursion(queenConquer(chessBoard, k,i), k+1);
                    System.out.println(k+"번째 줄에서 분기문 몇번 탈까?");
                }
            }
        }


    }

    static boolean[][] queenConquer(boolean[][] chessBoard, int i, int j){
        System.out.println("["+i+"]["+j+"]" + "에서 재귀전에 퀸 정복연산");

//        boolean[][] newBoard = chessBoard.clone(); // 깊은복사 안되는것 같다!
        boolean[][] newBoard = new boolean[N][N];
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                newBoard[k][l] = chessBoard[k][l];
            }
        }

        // chessBoard[i][j]에 퀸 범위(정복)연산 >> false 할당
        for (int k = 0; k < N; k++) {
            newBoard[i][k] = false;
            newBoard[k][j] = false;
//            System.out.println("["+i+"]["+k+"]" + "false");
//            System.out.println("["+k+"]["+j+"]" + "false");
        }

        // (오른쪽 위)대각
        for (int x = 0; x <= i+j; x++) {
            int y = i+j-x;
            if(y>=0 && y<N && x<N){
                System.out.println("["+y+"]["+x+"]" + "우상대각 false");
                newBoard[y][x] = false;
            }
        }

        // (오른쪽 위)대각
        for (int x = 0; x < N; x++) {
            int y = x+i-j;
            if(y>=0 && y<N){
//                System.out.println("["+y+"]["+x+"]" + "우하대각 false");
                newBoard[y][x] = false;
            }
        }
        return newBoard;
    }

    static void printBoard(boolean[][] chessBoard){
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if(chessBoard[i][j]) System.out.print("O ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

}
