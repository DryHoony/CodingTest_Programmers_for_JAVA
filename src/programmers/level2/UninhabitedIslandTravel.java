package programmers.level2;

import java.util.*;

public class UninhabitedIslandTravel { // 무인도 여행

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        // 가로, 세로 3~100
        // 상하좌우 탐색 - 연결된 무인도 만들기(숫자 합이 무인도 값)
        // 무인도값[] return >> 만약 없다면 [-1] return

        // int[][] map 구성
        int h = maps.length;
        int w = maps[0].length();
        int[][] map = new int[h+2][w+2];

        boolean[][] visited = new boolean[h+2][w+2];
        for (int i = 0; i < h+2; i++) {
            visited[i][0] = true;
            visited[i][w+1] = true;
        }
        for (int j = 0; j < w+2; j++) {
            visited[0][j] = true;
            visited[h+1][j] = true;
        }

        ArrayList<int[]> unvisitedNode = new ArrayList<>(); // empty 일때 연산종료 조건!

        int iIndex=0;
        int jIndex=0;
        for(String line:maps){
            iIndex++;
            jIndex=0;
            for (String s:line.split("")){
                jIndex++;
                if(s.equals("X")){
                    visited[iIndex][jIndex] = true;
                    continue;
                }
                map[iIndex][jIndex] = Integer.parseInt(s);
                unvisitedNode.add(new int[] {iIndex,jIndex});
            }
        }

        ///////////////////////////////////////////////
//        System.out.println("map 출력 확인 >> ");
//        for (int[] line:map){
//            for (int n:line) System.out.print(n +" ");
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println("visited 출력 확인 >> ");
//        for (boolean[] line:visited){
//            for (boolean n:line) System.out.print(n +" ");
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println("unvisitedNode 출력 확인 >> ");
//        for (int[] node:unvisitedNode){
//            System.out.print(node[0]+","+node[1]+ " / ");
//        }


        // 연산용 변수
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> valueList = new ArrayList<>();

        // 본연산
        while(!unvisitedNode.isEmpty()){
            queue.add(unvisitedNode.get(0));
            visited[queue.peek()[0]][queue.peek()[1]] = true;
            unvisitedNode.remove(0);
            int value=0;
            System.out.println("섬 탐색 시작");

            while(!queue.isEmpty()){ // BFS
                int[] node = queue.poll();
                int a = node[0];
                int b = node[1];
                value += map[a][b];
                System.out.println(a+","+b+" 위치 탐색 >> 현재 value = " + value);

                // 상하좌우 탐색
                if(map[a-1][b]!=0 && !visited[a-1][b]){
                    queue.add(new int[] {a-1,b});
                    visited[a-1][b] = true;
//                    unvisitedNode.remove(new int[] {a-1,b}); // 작동을 안하는것 같다
                    for (int i = 0; i < unvisitedNode.size(); i++) {
                        int[] uNode = unvisitedNode.get(i);
                        if(uNode[0]==a-1 && uNode[1]==b){
                            unvisitedNode.remove(i); // 잘될까?
                            break;
                        }
                    }
                }
                if(map[a+1][b]!=0 && !visited[a+1][b]){
                    queue.add(new int[] {a+1,b});
                    visited[a+1][b] = true;
//                    unvisitedNode.remove(new int[] {a+1,b});
                    for (int i = 0; i < unvisitedNode.size(); i++) {
                        int[] uNode = unvisitedNode.get(i);
                        if(uNode[0]==a+1 && uNode[1]==b){
                            unvisitedNode.remove(i);
                            break;
                        }
                    }
                }
                if(map[a][b-1]!=0 && !visited[a][b-1]){
                    queue.add(new int[] {a,b-1});
                    visited[a][b-1] = true;
//                    unvisitedNode.remove(new int[] {a,b-1});
                    for (int i = 0; i < unvisitedNode.size(); i++) {
                        int[] uNode = unvisitedNode.get(i);
                        if(uNode[0]==a && uNode[1]==b-1){
                            unvisitedNode.remove(i);
                            break;
                        }
                    }
                }
                if(map[a][b+1]!=0 && !visited[a][b+1]){
                    queue.add(new int[] {a,b+1});
                    visited[a][b+1] = true;
//                    unvisitedNode.remove(new int[] {a,b+1});
                    for (int i = 0; i < unvisitedNode.size(); i++) {
                        int[] uNode = unvisitedNode.get(i);
                        if(uNode[0]==a && uNode[1]==b+1){
                            unvisitedNode.remove(i);
                            break;
                        }
                    }
                }

            }

            valueList.add(value);
        }



        Collections.sort(valueList);
        if(valueList.isEmpty()) System.out.println("답은 -1");
        else System.out.println("답은 >> " + valueList);
    }


    public static void main0(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        // 가로, 세로 3~100
        // 상하좌우 탐색 - 연결된 무인도 만들기(숫자 합이 무인도 값)
        // 무인도값[] return >> 만약 없다면 [-1] return

        // int[][] map 구성
        int h = maps.length;
        int w = maps[0].length();
        int[][] map = new int[h+2][w+2];

        boolean[][] visited = new boolean[h+2][w+2]; // 모든 값이 true 가 되었을때 연산 종료
        for (int i = 0; i < h+2; i++) {
            visited[i][0] = true;
            visited[i][w+1] = true;
        }
        for (int j = 0; j < w+2; j++) {
            visited[0][j] = true;
            visited[h+1][j] = true;
        }


        int iIndex=0;
        int jIndex=0;
        for(String line:maps){
            iIndex++;
            jIndex=0;
            for (String s:line.split("")){
                jIndex++;
                if(s.equals("X")){
                    visited[iIndex][jIndex] = true;
                    continue;
                }
                map[iIndex][jIndex] = Integer.parseInt(s);
            }
        }

        // 연산용 변수
        ArrayList<Integer> islandValue = new ArrayList<>();
        int[] node;
        boolean searchFlag = true;
        Queue<int[]> queue = new LinkedList<>();


        // 본 연산
        while (searchFlag){

            // visited 에서 false 인 값을 찾아 시작노드 할당, 모두 true 라면 연산종료 by searchFlag
            searchFlag = false;
            startNodeSearch : for (int i = 0; i < h+2; i++) {
                for (int j = 0; j < w+2; j++) {
                    if(!visited[i][j]){
                        queue.add(new int[] {i,j}); // 시작 노드 할당
                        searchFlag = true;
                        break startNodeSearch;
                    }
                }
            }

            int value=0;
            // 섬 탐색 방문 - BFS
            while(!queue.isEmpty()){
                node = queue.poll();
                int a = node[0];
                int b = node[1];
                value += map[a][b];

                // 상하좌우 탐색
                if(map[a-1][b]!=0 && !visited[a-1][b]){
                    queue.add(new int[] {a-1,b});
                    visited[a-1][b] = true;
                }
                if(map[a+1][b]!=0 && !visited[a+1][b]){
                    queue.add(new int[] {a+1,b});
                    visited[a+1][b] = true;
                }
                if(map[a][b-1]!=0 && !visited[a][b-1]){
                    queue.add(new int[] {a,b-1});
                    visited[a][b-1] = true;
                }
                if(map[a][b+1]!=0 && !visited[a][b+1]){
                    queue.add(new int[] {a,b+1});
                    visited[a][b+1] = true;
                }

            }

            // value 값 islandValue 에 추가
            if(searchFlag) islandValue.add(value);

        }


        Collections.sort(islandValue);
        System.out.println("답은 >> " + islandValue);

    }
}
