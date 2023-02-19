package programmers.level0;

public class SafetyZone { // 안전지대

    public int solution(int[][] board) {
        int n = board.length;
        int il, ir, jl, jr;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    // [i][j]의 폭탄처리
                    il = (i>0) ? i-1 : i;
                    ir = (i<n-1) ? i+1 : i;
                    jl = (j>0) ? j-1 : j;
                    jr = (j<n-1) ? j+1 : j;

                    for(int a=il; a<=ir; a++){
                        for(int b=jl; b<=jr; b++){
                            if(board[a][b]==0) board[a][b]=-1;
                        }
                    }

                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==0) answer++;
            }
        }
        return answer;
    }
}
