package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ranking { // 순위
    // 정확하게 순위를 매긴다 >> 형제 없는 계층구조 (Top, Bottom)
    // 유향 그래프

    public static void main(String[] args) {
        int n = 5; //1~100
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}; // {a,b} : a가 b를 이김, 1~4500


        // 연산용 변수
        int count=0; // 정확하게 순위를 매길 수 있는 노드의 갯수
        ArrayList<Integer>[] winAdj = new ArrayList[n+1]; // 이기는 인접 리스트
        for (int i = 0; i <= n; i++) {
            winAdj[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] defeatAdj = new ArrayList[n+1]; // 지는 인접 리스트
        for (int i = 0; i <= n; i++) {
            defeatAdj[i] = new ArrayList<>();
        }
        for(int[] edge:results){
            winAdj[edge[0]].add(edge[1]);
            defeatAdj[edge[1]].add(edge[0]);
        }


        // 꼴찌 정하기 - 임의의 선수에서 출발하여 도착점이 같다면 그 선수가 '꼴찌'
        // 꼴찌에서 자식없이 올라가는 선수들이 뒤에서 ranking 매겨짐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.clear();
            queue.add(i); // i node에서 출발
            // dfs 연산 메소드 - 도착 출력
            System.out.println(i+" 에서 출발, 꼴지는 = " + dfs(queue, winAdj, n));
        }



        // 1위 정하기 - '꼴찌'에서 defeatAdj 를 타고 올라가서 같은 자식으로 끝나면 그 선수가 '1등'






        System.out.println("답은 >> " + count);
    }

    public static int dfs(Queue<Integer> queue, ArrayList<Integer>[] adj, int n){ // 꼴지 return 메소드
        boolean[] visited = new boolean[n+1]; // 모든 노드 방문X, 꼴지 찾기
        int node;
        int lastNode=0; // 마지막 레벨에서 하나가 남았을 때만 return
        int count=0;
        Queue<Integer> nextQueue = new LinkedList<>(); // 레벨 구분을 위한 Queue

        while(!queue.isEmpty()){
            // 레벨별로 구분
            lastNode = queue.peek();
            count = queue.size(); // 현재 레벨의 형제 노드 갯수, 마지막에 1일때만 꼴찌

            // 본 dfs 연산
            while(!queue.isEmpty()){ // 같은 레벨에서 모두 연산
                node = queue.poll();

                for(int i:adj[node]){ // 갈수 있는곳만 탐색
                    if(visited[i] == false){
//                        queue.add(i);
                        nextQueue.add(i);
                        visited[i] = true;
                    }
                }
            }

            // 다음 레벨 연산준비
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<>();
        }

        // 결과값 리턴
        if(count==1){
            return lastNode;
        }
        return -1; // 형제 노드 존재 >> 꼴찌 존재 X
    }




}
