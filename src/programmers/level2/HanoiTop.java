package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class HanoiTop { // 하노이 탑

    // 전역 변수
    static int[][] answer;
    static int i=0;

    // 재귀함수
    public static void HanoiRecursion(int n, int a, int b){
        int c = remainTower(a,b); // 중간 타워

        // 종료조건
        if(n==1){
//            System.out.println(a + ", " + b);
            answer[i][0] = a;
            answer[i][1] = b;
            i++;
            return;
        }

        // 재귀
        HanoiRecursion(n-1,a,c);
        HanoiRecursion(1,a,b);
        HanoiRecursion(n-1,c,b);

    }

    public static int remainTower(int a, int b){
        List<Integer> tower = new ArrayList<>();
        tower.add(1);
        tower.add(2);
        tower.add(3);

        // a 제거
        for (int j = 0; j < tower.size(); j++) {
            if(tower.get(j) == a){
                tower.remove(j);
                break;
            }
        }

        // b 제거
        for (int j = 0; j < tower.size(); j++) {
            if(tower.get(j) == b){
                tower.remove(j);
                break;
            }
        }

        return tower.get(0);
    }

    public static void main(String[] args) {
        int n = 4;
        // 1번 기둥에 있는 원판의 갯수 n개를 3번 원판으로 옮기는 방법을 return
        // return [[1,2],[1,3],[2,3]]

        // 연산용 변수
        answer = new int[(int) Math.pow(2,n) - 1][2];

        // 연산
        HanoiRecursion(n,1,3);

        System.out.println("답은 = ");
    }

}
