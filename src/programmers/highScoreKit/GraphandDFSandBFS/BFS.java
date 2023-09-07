package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS { // BFS Example
    // 큐 사용
    // 큐에 들어갈 때 방문체크

    public static void main(String[] args) {
        BFSVer1.main(args);


    }

    class BFSVer1 { // https://scshim.tistory.com/241
        public static boolean[] visited = {false, false, false ,false ,false ,false ,false ,false, false};
        // 간선을 2차원 배열로 표현
        public static int[][] graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};

        public static void bfs(int start){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            // 현재 노드를 방문 처리
            visited[start] = true;

            // 큐가 빌때까지 반복
            while(!queue.isEmpty()){
                int v = queue.poll();
                System.out.print(v + " ");

                // 인접한 노드 중 아직 방문하지 않은 원소들을 큐에 삽입
                for(int i:graph[v]){
                    if(visited[i] == false){
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }

        }

        public static void main(String[] args) {
            int start = 1; // 시작 노드

            System.out.print("BFS 탐색 >> ");
            bfs(start);
            System.out.println();

        }
    }


}
