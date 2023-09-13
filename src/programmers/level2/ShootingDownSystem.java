package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class ShootingDownSystem { // 요격시스템

    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}; // 1~500,000
        // 개구간 (s,e) 의 모든 targets 을 요격하기 위한 요격 미사일의 최소 갯수 return
        // 정수 s,e 범위 0~100,000,000
        // 연산(미사일 끼리 범위축소) 순서에 따라 갯수가 다르다!! - 정렬 필요! or 다른 탐색방법??


        // 정렬 - s 작은순 and e 작은순 - 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        // 연산용 변수
        int count = 0; // 요격 미사일 갯수
        int s=-1; // 현재 요격미사일 범위
        int e=-1;


        // 연산
        for (int[] t:targets){
            System.out.println();
            System.out.println("미사일 try >> "+ t[0] + ", " + t[1]);
            // (s,e) 와 (t[0],t[1]) 범위비교
            // s <= t[0]

            if(t[1] <= e){ // 포함 - 축소
                s = t[0]; // 같거나 축소
                e = t[1]; // 같거나 축소
                System.out.println("요격 범위 >> "+ s + ", " + e);
            } else if (t[0] < e) { // 부분포함 - 축소
                s = t[0]; // 같거나 축소
                System.out.println("요격 범위 >> "+ s + ", " + e);
            }
            else{ // 벗어남 - 새 요격
                // e<t[0] 가 항상 성립
//                if(e > t[0]) System.out.println("로직 잘못 짰다!!!!"); // 확인용
                // 새로운 요격 할당
                count++;
                s = t[0];
                e = t[1];
                System.out.println("새 요격 >> count = " + count);
                System.out.println("요격 범위 >> "+ s + ", " + e);
            }


        }


        System.out.println("답은 = " + count);
    }
}
