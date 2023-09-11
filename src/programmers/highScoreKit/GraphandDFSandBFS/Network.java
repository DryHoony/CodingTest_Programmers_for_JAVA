package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network { // 네트워크
    // 무향 그래프, Index 0~n-1 , [i][i]=1

    public static void main(String[] args) {
        int n = 3; // 1~200
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}}; // 인접 행렬


        // 인접 리스트 변경
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 인접 행렬 >> 인접 리스트 할당
                if(i!=j && computers[i][j]==1){
                    adj[i].add(j); // computers 가 대칭행렬이라 어짜피 반대편도 연산됨
                }
            }
        }


        // 연산용 변수
        boolean[] visited = new boolean[n];
        int nextWorkCount=0; // 연결된 네트워크 갯수
        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0); // 초기 노드
        int node;

        // 연산
        while(true){
            // 남은 노드 찾기
            node = -1; // 초기화
            for (int i = 0; i < n; i++) { // 방문하지 않은 노드 할당
                if(visited[i] == false){
                    node = i;
                    break;
                }
            }
            if(node == -1) break; // 종료조건 - 모든 노드를 방문

            queue.add(node); // 네트워크 시작노드
            visited[node] = true;
            nextWorkCount++;

            // 네트워크 연결 연산 - bfs, 큐 사용
            while(!queue.isEmpty()){
                node = queue.poll(); // 탐색할 노드

                for(int i:adj[node]){
                    if(visited[i] == false){
                        queue.add(i);
                        visited[i] = true;
                    }
                }

            }

        }

        System.out.println("답은 = "+ nextWorkCount);
    }
}
