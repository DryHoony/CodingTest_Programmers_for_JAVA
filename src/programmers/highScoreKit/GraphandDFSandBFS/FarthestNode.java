package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarthestNode { // 가장 먼 노드


    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};


        // 간선을 '인접 리스트'형태로 변경, 노드의 갯수는 정해져있으니 ArrayList[n+1]
        List<Integer>[] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];

        // adjacent List 세팅
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e:edge){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]); // 무방향 이므로 반대로도 할당
        }
//        System.out.println("adj 할당 확인");
//        for (List a:adj){
//            System.out.println(a);
//        }

        // 탐색 - 전체 탐색이니 bfs, dfs 상관없을듯, but count 세기 위해 bfs 이용
        Queue<Integer> queue = new LinkedList<>(); // dfs 연산용 Queue
        Queue<Integer> nextQueue = new LinkedList<>(); // 다음 레벨 구분용 Queue
        queue.add(1); // 시작노드 1
        visited[1] = true; // 시작노드 방문처리
        int node;
        int count=0;

        // 큐가 빌때까지 탐색
        while(!queue.isEmpty()){ // 마지막 노드일때 연산종료 - 종료조건 설정
//            System.out.println("출력확인 >> queue = " + queue + " / nextQueue = " + nextQueue);
            count = queue.size(); // 현재 높이의 노드 갯수
            System.out.println();
            System.out.print("다음 레벨 연산 >> ");

            // queue 에 있는 node 연산 - 같은 레벨
            while(!queue.isEmpty()){
                node = queue.poll();

                for(int i:adj[node]){
                    if(visited[i] == false){
                        nextQueue.add(i);
                        visited[i] = true;
                        System.out.print(i + "방문  ");
                    }
                }
            }

            // nextQueue 를 queue에 할당 및 초기화
            queue.addAll(nextQueue); // 얕은복사??
            nextQueue = new LinkedList<>();
//            System.out.println("출력확인 >> queue = " + queue + " / nextQueue = " + nextQueue);
        }


        System.out.println("답은 >> " + count);
    }
}
