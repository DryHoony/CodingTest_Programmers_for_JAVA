package programmers.level1;

public class NeighborSpace { // 이웃한 칸


    public static void main(String[] args) {
        String[][] board;
        int h;
        int w;
        int result;

        // case 1
        board = new String[][]
                {{"blue", "red", "orange", "red"}
                , {"red", "red", "blue", "orange"}
                , {"blue", "orange", "red", "red"}
                , {"orange", "orange", "red", "blue"}};
        h = 1;
        w = 1;
        result = 2;

        NeighborSpace obj = new NeighborSpace();
        System.out.println(obj.solution(board, h, w));

    }

    public int solution(String[][] board, int h, int w){
        int count=0;
        String color = board[h][w];

        // 위
        if(h>0 && board[h-1][w].equals(color))
            count++;
        // 아래
        if(h<board.length-1 && board[h+1][w].equals(color))
            count++;
        // 좌
        if(w>0 && board[h][w-1].equals(color))
            count++;
        // 우
        if(w<board[0].length && board[h][w+1].equals(color))
            count++;



        return count;
    }
}
