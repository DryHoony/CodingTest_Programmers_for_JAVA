package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class mazeEscape { // 미로탈출

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        // 가로 세로 길이 5~100
        // 중복해서 지나갈 수 있음 - 2단계로 구분하여 각 단계의 visited 를 구성
        // 1단계 레버찾기 S-L
        // 2단계 탈출하기 L-E


        // map >> int[][]로 재구성, 장애물0, 경로1, 테두리는 장애물로 한번더 둘러쌈
        int h = maps.length;
        int w = maps[0].length();
        int[][] map = new int[h+2][w+2];
        int indexI=0;
        int indexJ=0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] escape = new int[2];

        // 맵 경로 할당 >> 1
        for(String line:maps){
            indexI++;
            indexJ=0;
            for (String str:line.split("")){
                indexJ++;

                if(str.equals("X")) continue; // 초기화 시 0으로 할당되있음 - 장애물
                else if (str.equals("O")){
                    map[indexI][indexJ] = 1; // 경로 할당 = 1
                }else if (str.equals("S")){
                    map[indexI][indexJ] = 1;
                    start[0] = indexI;
                    start[1] = indexJ;
                }else if (str.equals("L")){
                    map[indexI][indexJ] = 1;
                    lever[0] = indexI;
                    lever[1] = indexJ;
                } else if (str.equals("E")) {
                    map[indexI][indexJ] = 1;
                    escape[0] = indexI;
                    escape[1] = indexJ;
                }
            }
        }

        // 출력확인
//        System.out.println("map 출력확인 >>");
//        for(int[] line:map){
//            for (int k:line) System.out.print(k + " ");
//            System.out.println();
//        }
//        System.out.println("start = " + start[0] +" "+ start[1]);
//        System.out.println("lever = " + lever[0]+" "+ lever[1]);
//        System.out.println("escape = " + escape[0]+" "+ escape[1]);


        // 연산용 변수
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextQueue = new LinkedList<>();
        int levelCount = 0; // 경로 >> return
        boolean[][] visited = new boolean[h+2][w+2];
        boolean flag = false;

        // 1단계 연산 S -> L
        queue.add(start); // 출발
        visited[start[0]][start[1]] = true;

        first : while(!queue.isEmpty()){
            levelCount++;

            // BFS 레벨 연산
            while(!queue.isEmpty()){
                int[] node = queue.poll();
                int a = node[0];
                int b = node[1];

                // 탐색 - 상하좌우
                if(map[a-1][b]==1 && !visited[a-1][b]){
                    nextQueue.add(new int[] {a-1,b});
                    visited[a-1][b] = true;
                }
                if(map[a+1][b]==1 && !visited[a+1][b]){
                    nextQueue.add(new int[] {a+1,b});
                    visited[a+1][b] = true;
                }
                if(map[a][b-1]==1 && !visited[a][b-1]){
                    nextQueue.add(new int[] {a,b-1});
                    visited[a][b-1] = true;
                }
                if(map[a][b+1]==1 && !visited[a][b+1]){
                    nextQueue.add(new int[] {a,b+1});
                    visited[a][b+1] = true;
                }
            }

            // 종료 조건 - L 도착
            for(int[] node:nextQueue){
                if(node[0]==lever[0] && node[1]==lever[1]){
                    flag = true;
                    break first;
                }
            }

            // 다음 연산 준비
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<>();
        }


        if(!flag){
            System.out.println("1단계 연산 실패!!! >> return -1");
        }
        flag = false;

        // 2단계 연산 L -> E
        queue.clear();
        nextQueue.clear();
        visited = new boolean[h+2][w+2];
        // 이전 연산 변수 초기화 후 출발 할당
        queue.add(lever);
        visited[lever[0]][lever[1]] = true;

        second : while(!queue.isEmpty()){
            levelCount++;

            // BFS 레벨 연산
            while(!queue.isEmpty()){
                int[] node = queue.poll();
                int a = node[0];
                int b = node[1];

                // 탐색 - 상하좌우
                if(map[a-1][b]==1 && !visited[a-1][b]){
                    nextQueue.add(new int[] {a-1,b});
                    visited[a-1][b] = true;
                }
                if(map[a+1][b]==1 && !visited[a+1][b]){
                    nextQueue.add(new int[] {a+1,b});
                    visited[a+1][b] = true;
                }
                if(map[a][b-1]==1 && !visited[a][b-1]){
                    nextQueue.add(new int[] {a,b-1});
                    visited[a][b-1] = true;
                }
                if(map[a][b+1]==1 && !visited[a][b+1]){
                    nextQueue.add(new int[] {a,b+1});
                    visited[a][b+1] = true;
                }
            }

            // 종료 조건 - L 도착
            for(int[] node:nextQueue){
                if(node[0]==escape[0] && node[1]==escape[1]){
                    flag = true;
                    break second;
                }
            }

            // 다음 연산 준비
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<>();
        }



        if(flag) System.out.println("답은 >> " + levelCount);
        else System.out.println("2단계 연산 실패 >> return -1");


    }
}
