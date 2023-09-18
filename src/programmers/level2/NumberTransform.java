package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberTransform { // 숫자 변환하기

    public static void main(String[] args) { //
        int x = 10;
        int y = 40;
        int n = 5;

        // 연산용 변수
        int level=0;
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> nextNumbers = new LinkedList<>();
        numbers.add(y);
        boolean targetFlag = false;

        // y - > x 로 거꾸로 연산해 보자. size 줄어들듯!
        while(!numbers.isEmpty()){
            level++;

            while(!numbers.isEmpty()){
                int k = numbers.poll();

                if(k%3==0 && k/3>=x) nextNumbers.add(k/3);
                if(k%2==0 && k/2>=x) nextNumbers.add(k/2);
                if(k-n>=x) nextNumbers.add(k-n);
            }

            System.out.println("nextNumbers = " + nextNumbers);

            // 다음 연산준비
            if(nextNumbers.contains(x)){
                targetFlag = true;
                break;
            }
            numbers.addAll(nextNumbers);
            nextNumbers = new LinkedList<>();
        }

//        if(targetFlag) return level;
//        return -1;
    }

    public static void main0(String[] args) { // 실패!!!
        int x = 10;
        int y = 40;
        int n = 5;
        // x -> y 변환
        // x에 사용할 수 있는 연산 = n 더하기 / 2곱하기 / 3곱하기
        // 최소 연산횟수 return, 불가능하면 -1


        // BFS - 최단거리
        // visited X >> 각 레벨에서 방문할 수 있는 숫자List
        // 탐색 할때, y 보다 크면 방문X
        // 중복 방문 visited 필요할까? >> 3^n 으로 늘어날텐데 일단 try

        // 연산용 변수
        int level=0;
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> nextNumbers = new LinkedList<>();
        numbers.add(x);
        boolean targetFlag = false;

        while(!numbers.isEmpty()){
            level ++;

            // level 연산
            while(!numbers.isEmpty()){
                int k = numbers.poll();

                if(k+n <= y) nextNumbers.add(k+n);
                if(k*2 <= y) nextNumbers.add(k*2);
                if(k*3 <= y) nextNumbers.add(k*3);
            }

            System.out.println("nextNumbers = " + nextNumbers);

            // 다음 연산준비
            if(nextNumbers.contains(y)){
                targetFlag = true;
                break;
            }
            numbers.addAll(nextNumbers);
            nextNumbers = new LinkedList<>();
        }


//        if(targetFlag) return level;
//        return -1;
    }
}
