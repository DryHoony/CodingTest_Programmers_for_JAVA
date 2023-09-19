package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class TableHashFunction { // 테이블 해시 함수

    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}}; // 길이 1~2500, 원소의 길이 1~500, 원소값 1~1,000,000
        int col = 2;
        int row_begin = 2;
        int row_end=3;
        // S(i) = sum(i번째 튜플(행)의 원소를 i로 나눈 값)

        // [col-1] 기준 오름차순 정렬, 동일하면 [0] 기준 내림차순 정렬
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1] == o2[col-1]) return o2[0]-o1[0];
                return o1[col-1] - o2[col-1];
            }
        });

        System.out.println("정렬 확인 >> ");
//        for (int[] line:data){
//            for(int i:line){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
        int answer=0;
        int sum;

        for (int i = row_begin; i <= row_end; i++) {
            sum=0;
            for (int n: data[i-1]){
                sum += n%i;
            }
            answer = answer ^ sum;
        }


        System.out.println("answer = " + answer);




    }
}
