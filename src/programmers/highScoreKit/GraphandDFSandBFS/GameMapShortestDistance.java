package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance { // 개임 맵 최단거리
    // 상대 팀 진영에 도착하기 위한 칸의 최소 갯수 return, 불가능하면 -1
    // maps n*m, n,m은 1~100
    // 출발 maps[0][0] >> 도착 maps[n-1][m-1]
    // 최단거리 찾기만 하면 끝이므로 BFS - 다익스트라??

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}; // 0은 벽, 1은 지나갈 수 있음
        int n = maps.length;
        int m = maps[0].length;

        // maps 이 간선이 아닌 노드에 대한 정보이므로 >> 인접행렬 or 인접리스트 >> 일단 없이 해보자
        // 지나갈수 없는 테두리에 더미Index 추가
        boolean[][] visited = new boolean[n+2][m+2];
        int[][] mapIndex = new int[n+2][m+2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mapIndex[i+1][j+1] = maps[i][j];
            }
        }

        // BFS 에서 level 을 나타내는 변수 필요 >> 도착했을 때 답이 된다.
        int level = 1; // 경로의 길이
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextLevelQueue = new LinkedList<>();
        queue.add(new int[] {1,1}); // 출발노드
        visited[1][1] = true;
        int[] node;


        while(!queue.isEmpty()){ // 레벨 연산용
            if(visited[n][m] == true) break; // 종료조건 >> return level
            level++; // 다음 레벨

            while (!queue.isEmpty()){ // 본 연산
                node = queue.poll();
                int a = node[0];
                int b = node[1];
                System.out.println(a + ", " + b + " 노드 연산");

                // 인접노드 방문 연산 - 상하좌우
                if(visited[a-1][b] == false && mapIndex[a-1][b]==1){
                    nextLevelQueue.add(new int[]{a-1,b});
                    visited[a-1][b] = true;
                    System.out.println(level + "level 에 방문 >> "+ (a-1) + ", "+b);
                }
                if(visited[a+1][b] == false && mapIndex[a+1][b]==1){
                    nextLevelQueue.add(new int[]{a+1,b});
                    visited[a+1][b] = true;
                    System.out.println(level + "level 에 방문 >> "+ (a+1) + ", "+b);
                }
                if(visited[a][b-1] == false && mapIndex[a][b-1]==1){
                    nextLevelQueue.add(new int[]{a,b-1});
                    visited[a][b-1] = true;
                    System.out.println(level + "level 에 방문 >> "+ a + ", "+(b-1));
                }
                if(visited[a][b+1] == false && mapIndex[a][b+1]==1){
                    nextLevelQueue.add(new int[]{a,b+1});
                    visited[a][b+1] = true;
                    System.out.println(level + "level 에 방문 >> "+ a + ", "+(b+1));
                }


            }

            // 다음레벨 연산준비
            queue.addAll(nextLevelQueue);
            nextLevelQueue = new LinkedList<>(); // 안겹치도록 초기화

        }


//        return level;
        System.out.println("답은 = "+level);






    }


}
