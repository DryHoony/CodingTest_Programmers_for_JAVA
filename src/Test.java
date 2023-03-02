import java.util.*;

public class Test {


    public static void main(String[] args) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0); // 빈통 방지
        answer.add(0,3);
        answer.add(0,1);
        answer.add(0,5);
        answer.add(0,2);

        System.out.println(answer);

        answer.remove(0);
        answer.remove(0);
        System.out.println(answer);
        System.out.println(answer.get(0));



//        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//        int[] moves = {1,5,3,5,1,2,1,4};
//        int n = board.length;
//
//        ArrayList<ArrayList<Integer>> board2 = new ArrayList<>(); // ArrayList 이차원배열
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            row.clear();
//            for (int j = 0; j < n; j++) {
//                if(board[j][i] != 0) row.add(board[j][i]);
//            }
//            System.out.println(row);
//            board2.add(row);
//        }
//
//        System.out.println(board2);

    }

    }

    



