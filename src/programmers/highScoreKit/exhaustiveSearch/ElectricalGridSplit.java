package programmers.highScoreKit.exhaustiveSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElectricalGridSplit { // 전력망을 둘로 나누기
    // 다시 해볼 것!! - Node(구현할것)나 방문(visited)개념으로 좀 더 쉽게 retry

    public static void main(String[] args) {
        // input
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        // 연산용 변수
        ArrayList<int[]> wireArray = new ArrayList<>();
        ArrayList<int[]> wireArrayDel = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int x;
        int count;
        int min=n;


        for (int i = 0; i < n-1; i++) {
            System.out.println(i + "번째 전선 제거 후 연산");
            // 연산용 변수 초기화
            wireArray.clear();
            count=0;
            que.add(1);

            for (int j = 0; j < n-1; j++) {
                if(i==j) continue;
                else {
                    wireArray.add(wires[j]);
                }
            }
            System.out.print("전력망 구성 ");
            for (int[] wire:wireArray){
                System.out.print("("+wire[0]+","+wire[1]+") / ");
            }
            System.out.println();


            // wireArray 에 몰아 넣고 연결된 전력망 구성 (step2)
            // "Queue 에서 poll >> 해당 값을 가지고 있는 wire 를 제거 및 que 에 추가" que empty일때 까지 반복
            while (!que.isEmpty()){
                x = que.poll();
                count++; // 연결되는 전력망 count
                // wireArray 의 wire[a,b] 중 x를 가지고 있으면 '연산'
                // '연산' - wireArray 에서 제거, 반대쪽 전력 Que에 추가
                System.out.println(x+"에 연결되는 전력망");
                for(int[] wire:wireArray){
                    if(wire[0]==x){
                        wireArrayDel.add(wire);
                        que.add(wire[1]);
                        System.out.println("("+wire[0]+","+wire[1]+")");
                    }
                    else if (wire[1]==x) {
                        wireArrayDel.add(wire);
                        que.add(wire[0]);
                        System.out.println("("+wire[0]+","+wire[1]+")");
                    }
                }
                // Que.poll 값 x에 대해 wire 조건문 연산 끝났으므로, 연결된 전력망 remove 연산
                for(int[] wire:wireArrayDel){
                    wireArray.remove(wire);
                }
                wireArrayDel.clear(); // 초기화

                }

            System.out.println("연결된 전력망 갯수 = "+count);
            System.out.println();
            count = Math.abs(n - count*2); // 전력망 차이값으로 잠시 계산
            if(count < min) min = count;
//            if(min==0); break; // 전역최솟값 달성 - min값이 0도 아닌데 왜 break 걸리지?
            }

        System.out.println();
        System.out.println("차이는 : "+ min);
        }

    }

