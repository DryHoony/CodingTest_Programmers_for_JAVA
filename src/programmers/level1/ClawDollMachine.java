package programmers.level1;

import java.util.ArrayList;

public class ClawDollMachine { // 크레인 인형뽑기 게임, 카카오기출 https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java

    public static int pick(int[][] list, int n){
//        int l = list.length;
        int d;

        for (int i = 0; i < list.length; i++) {
            d = list[n-1][i];
            if(d != 0){
                list[n-1][i] = 0; // list update
                return d;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int l = board.length;

        int[][] board2 = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                board2[i][j] = board[j][i];
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(board2[i][j]);
//            }
//            System.out.println();
//        }
//
//        System.out.println(pick(board2,1));
//        System.out.println(pick(board2,1));
//        System.out.println(pick(board2,1));
//        System.out.println(pick(board2,1));
//        System.out.println(pick(board2,1));

        ArrayList<Integer> basket = new ArrayList<>();
        basket.add(0); // 빈통방지, get할때 error방지
        int count=0;
        int d;

        for(int n: moves){
            d = pick(board2,n);

            // basket연산
            if(d==0) continue; // 뽑을인형이 없을땐 pass
            else if (basket.get(0) == d) { // 샴쌍둥이 폭파
                basket.remove(0);
                count += 2;
            }else {
                basket.add(0,d); // 맨앞에 추가 - 스택처럼 활용
            }

        }

        System.out.println(count);





    }
}
