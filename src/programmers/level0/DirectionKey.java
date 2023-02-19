package programmers.level0;

public class DirectionKey { // 캐릭터의 좌표

    // 방향키누름
    public static void pressKey(String direction, int[] board){
        if(direction.equals("right")) board[0]++;
        else if (direction.equals("left")) board[0]--;
        else if (direction.equals("up")) board[1]++;
        else board[1]--;


//        return board;
    }

    // 평면 범위제한추가
    public static void pressKey2(String direction, int[] board,
                                  int maxx, int minx, int maxy, int miny){
        if(direction.equals("right") && board[0] < maxx) board[0]++;
        else if (direction.equals("left") && board[0] > minx) board[0]--;
        else if (direction.equals("up") && board[1] < maxy) board[1]++;
        else if (direction.equals("down") && board[1] > miny) board[1]--;

//        return board;
    }

    public static void main(String[] args) {
        int[] answer = {0,0};
        pressKey2("right", answer, 5,5,5,5);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
