package programmers.level2;

public class SoloPlayingTicTacTo { // 혼자서 하는 틱택토
    // 틱택토 - 2인용 게임, 3*3 빈칸, 선공O 후공X
    // 가로 세로 대각선 으로 3개가 같은 표시 만들면 승리
    // 9칸이 모두 차서 더 이상 표시 할수 없으면 무승부

    public static void main(String[] args) {
        String[] board = {"OXX", "OOX", "OXO"};
        // 머쓱이 트롤링 - OX 를 헷갈려 반대로 표시, 게임 종료됬음에도 계속 진행
        // 주어진 board 가 나올수 있으면 1 return, 그렇지 않으면 0 리던

        // 연산용 변수
        boolean possibleFlag = true;
        int oCount = 0;
        int xCount = 0;
        for (String line:board){
            for (String s:line.split("")){
                if(s.equals("O")) oCount++;
                else if (s.equals("X")) xCount++;
            }
        }

        // 갯수 연산 - 선공O 이 후공X 보다 같거나 1개 더 많음
        if( !(oCount==xCount || oCount==xCount+1) ) possibleFlag = false;
        System.out.println("갯수 통과했나? >> " + possibleFlag);

        boolean oWin = oIsWin(board);
        boolean xWin = xIsWin(board);
        System.out.println("oWin = " + oWin);
        System.out.println("xWin = " + xWin);

        // 승리 연산
        if(oWin && xWin) possibleFlag = false; // 둘다 승리할 순 없음
        if(possibleFlag && oWin){ // 선공O 만 승리 - 갯수가 한개 더 많아야 함
            if( !(oCount==xCount+1) ) possibleFlag=false;
        }
        if(possibleFlag && xWin){ // 후공X 만 승리 - 갯수가 같아야 함
            if( !(oCount==xCount) ) possibleFlag=false;
        }


        if(possibleFlag) System.out.println("답은 1"); // 가능
        else System.out.println("답은 0");
    }

    public static boolean oIsWin(String[] board){ // 가로 세로 대각선 확인
        // 가로줄, 세로줄 두줄이상 성공 X >> false 반환
        // 가로 한줄 && 세로 한줄 OK
        // 대각선 독립적으로 몇개가 되도 ok

        int horizontal = 0;
        int vertical = 0;
        for (String hor:board){
            if(hor.equals("OOO")) horizontal++;
        }
        for (int i = 0; i < 3; i++) {
            if(board[0].charAt(i)=='O' && board[1].charAt(i)=='O' && board[2].charAt(i)=='O') vertical++;
        }

        if(horizontal>1 || vertical>1) return false; // 가로 세로 두줄 동시달성 할 수 없음
        if(horizontal==1 || vertical==1) return true;

        // 대각선
        if(board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O') return true;
        if(board[2].charAt(0)=='O' && board[1].charAt(1)=='O' && board[0].charAt(2)=='O') return true;

        // 아무것도 해당되지 않으면 false;
        return false;
    }

    public static boolean xIsWin(String[] board){ // 가로 세로 대각선 확인
        // 가로줄, 세로줄 두줄이상 성공 X >> false 반환
        // 가로 한줄 && 세로 한줄 OK
        // 대각선 독립적으로 몇개가 되도 ok
        int horizontal = 0;
        int vertical = 0;
        for (String hor:board){
            if(hor.equals("XXX")) horizontal++;
        }
        for (int i = 0; i < 3; i++) {
            if(board[0].charAt(i)=='X' && board[1].charAt(i)=='X' && board[2].charAt(i)=='X') vertical++;
        }

        if(horizontal>1 || vertical>1) return false; // 가로 세로 두줄 동시달성 할 수 없음
        if(horizontal==1 || vertical==1) return true;

        // 대각선
        if(board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X') return true;
        if(board[2].charAt(0)=='X' && board[1].charAt(1)=='X' && board[0].charAt(2)=='X') return true;

        // 아무것도 해당되지 않으면 false;
        return false;
    }
}
