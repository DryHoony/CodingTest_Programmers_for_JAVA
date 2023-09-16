package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot { // 리코쳇 로봇(보드게임)


    public static void main(String[] args) { // ver2 - 맨끝도 장애물 도달로 map 확장
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        // 길이 3~100, 값 3~100
        // R -> G 최소 움직임으로 도달, D:장애물, 미끄러지듯 움직임,
        // 도달 할 수 없으면 -1

        // BFS - 레벨구분(while 문 두번??)
        // 탐색 - 상하좌우 방향에 (멈출 수 있는)D가 있는지 확인 and (이전의) 멈춤칸이 visited 인지 확인
        int h = board.length;
        int w = board[0].length();
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextQueue = new LinkedList<>();
        int[] target = new int[2];

        // 지도 셋팅 - String 타입 호출 불편
        int[][] map = new int[h+2][w+2];
        for (int i = 0; i < h+2; i++) {
            map[i][0] = 1;
            map[i][w+1] = 1;
        }
        for (int j = 0; j < w+2; j++) {
            map[0][j] = 1;
            map[h+1][j] = 1;
        }
        int a=0;
        int b=0;
        for (String bor:board){
            a++;
            b=0; // 초기화
            for(String bo:bor.split("")){
                b++;
                // map[x][y] 할당
                if(bo.equals("D")) map[a][b] = 1;
                if(bo.equals("R")){
                    // 출발노드 할당
                    queue.add(new int[] {a,b});
                }
                if(bo.equals("G")){
                    // 도착노드 할당
                    target[0] = a;
                    target[1] = b;
                }
            }
        }

//        System.out.println("맵 출력확인 >> ");
//        for (int[] line:map){
//            for (int n:line){
//                System.out.print(n+" ");
//            }
//            System.out.println();
//        }
//
//        // 출발노드 확인
//        int[] node = queue.poll();
//        System.out.println("출발노드 확인 >> "+node[0]+" "+node[1]);
//        System.out.println("타겟노드 확인 >> "+target[0] +" "+ target[1]);

        boolean[][] visited = new boolean[h+2][w+2];
        visited[queue.peek()[0]][queue.peek()[1]] = true;

        int moveCount = 0; // BFS 에서 탐색 레벨
        boolean targetFlag = false;


        // 본연산
        levelLoop : while(!queue.isEmpty()){
            moveCount++;
            System.out.println(moveCount + "레벨 탐색 >> ");
            int x;
            int y;

            // 레벨 연산 - 일반 BFS with nextQueue
            while(!queue.isEmpty()){
                int[] node = queue.poll();
                x = node[0];
                y = node[1];

                // node 탐색 - 상하좌우, nextQueue 에 할당
                for (int i = x-1; i >=0 ; i--) { // 상, index--
                    if(map[i][y] == 1){
                        // 방문가능 확인
                        if(!visited[i+1][y]){
                            System.out.println(x+" "+y+ "에서 방문 >> " + (i+1) +" " +y);
                            nextQueue.add(new int[] {i+1,y});
                            visited[i+1][y] = true;
                        }
                        break; // 장애물 만나면 무조건 연산종료
                    }
                }
                for (int i = x+1; i<=h+1 ; i++) { // 하, index++
                    if(map[i][y] == 1){
                        // 방문가능 확인
                        if(!visited[i-1][y]){
                            System.out.println(x+" "+y+ "에서 방문 >> " + (i-1) +" " +y);
                            nextQueue.add(new int[] {i-1,y});
                            visited[i-1][y] = true;
                        }
                        break; // 장애물 만나면 무조건 연산종료
                    }
                }
                for (int j = y-1; j >= 0; j--) { // 좌
                    if(map[x][j] == 1){
                        // 방문가능 확인
                        if(!visited[x][j+1]){
                            System.out.println(x+" "+y+ "에서 방문 >> " + x +" " +(j+1));
                            nextQueue.add(new int[] {x,j+1});
                            visited[x][j+1] = true;
                        }
                        break; // 장애물 만나면 무조건 연산종료
                    }
                }
                for (int j = y+1; j <= w+1; j++) { // 우
                    if(map[x][j] == 1){
                        // 방문가능 확인
                        if(!visited[x][j-1]){
                            System.out.println(x+" "+y+ "에서 방문 >> " + x +" " +(j-1));
                            nextQueue.add(new int[] {x,j-1});
                            visited[x][j-1] = true;
                        }
                        break; // 장애물 만나면 무조건 연산종료
                    }
                }
            }

            for (int[] n:nextQueue){
                if(n[0]==target[0] && n[1]==target[1]){
                    targetFlag = true;
                    break levelLoop; // 이중 while 종료
                }
            }

            // 다음 레벨 준비
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<>(); // 초기화 - 중복방지(깊은복사)

        }

        if(targetFlag) System.out.println("답은 >> " + moveCount);
        else System.out.println("못찼음 ㅜㅜ >> -1");


    }

    public static void main0(String[] args) { // 잘못짬 ㅜㅜ,, 맨끝에 도달한것도 장애물로 쳐야한다. map 을 늘리자 >> ver2
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        // 길이 3~100, 값 3~100
        // R -> G 최소 움직임으로 도달, D:장애물, 미끄러지듯 움직임,
        // 도달 할 수 없으면 -1



        // BFS - 레벨구분(while 문 두번??)
        // 탐색 - 상하좌우 방향에 (멈출 수 있는)D가 있는지 확인 and (이전의) 멈춤칸이 visited 인지 확인
        int h = board.length;
        int w = board[0].length();
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextQueue = new LinkedList<>();
        int[] target = new int[2];

        // 지도 셋팅 - String 타입 호출 불편
        int[][] map = new int[h][w];
        int a=-1;
        int b=-1;
        for (String bor:board){
            a++;
            b=-1;
            for(String bo:bor.split("")){
                b++;
                // map[x][y] 할당
                if(bo.equals("D")) map[a][b] = 1;
                if(bo.equals("R")){
                    // 출발노드 할당
                    queue.add(new int[] {a,b});
                }
                if(bo.equals("G")){
                    // 도착노드 할당
                    target[0] = a;
                    target[1] = b;
                }
            }
        }

//        // map 출력 확인
//        for (int[] line:map){
//            for (int n:line){
//                System.out.print(n+" ");
//            }
//            System.out.println();
//        }
//
//        // 출발노드 확인
//        int[] node = queue.poll();
//        System.out.println(node[0]+" "+node[1]);

        boolean[][] visited = new boolean[h][w];
        visited[queue.peek()[0]][queue.peek()[1]] = true;

        int moveCount = -1; // BFS 에서 탐색 레벨
        boolean targetFlag = false;


        while(!queue.isEmpty()){
            moveCount++;
            int x;
            int y;

            // 레벨 연산 - 일반 BFS with nextQueue
            while(!queue.isEmpty()){
                int[] node = queue.poll();
                x = node[0];
                y = node[1];

                // node 탐색 - 상하좌우, nextQueue 에 할당
                for (int i = x-2; i >= 0; i--) { // 상, index--
                    if(map[i][y] == 1 && !visited[i+1][y]){
                        nextQueue.add(new int[] {i+1,y});
                        visited[i+1][y] = true;
                    }
                }
                for (int i = x+2; i<h ; i++) { // 하, index++
                    if(map[i][y] == 1 && !visited[i-1][y]){
                        nextQueue.add(new int[] {i-1,y});
                        visited[i-1][y] = true;
                    }
                }
                for (int j = y-2; j >= 0; j--) { // 좌
                    if(map[x][j] == 1 && !visited[x][j+1]){
                        nextQueue.add(new int[] {x,j+1});
                        visited[x][j+1] = true;
                    }
                }
                for (int j = y+2; j < w; j++) { // 우
                    if(map[x][j] == 1 && !visited[x][j-1]){
                        nextQueue.add(new int[] {x,j-1});
                        visited[x][j-1] = true;
                    }
                }
            }

            if(nextQueue.contains(target)){ // 종료 조건
                targetFlag = true;
                break;
            }

            // 다음 레벨 준비
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<>(); // 초기화 - 중복방지(깊은복사)

        }

        if(targetFlag) System.out.println("답은 >> " + moveCount);
        else System.out.println("못찼음 ㅜㅜ >> -1");

    }
}