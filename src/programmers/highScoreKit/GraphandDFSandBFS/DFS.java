package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS { // DFS Example
    // 스택을 사용, 재귀를 사용

    public static void main(String[] args) {
        // 출력결과 // 1 2 7 6 8 3 4 5
        DFSByRecursionVer1.main(args);
        DFSByRecursionVer2.main(args);
        DFSByStackVer1.main(args);

    }

    // 재귀, int[][]
    public static class DFSByRecursionVer1 { // https://scshim.tistory.com/241
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

        public static void dfs(int v){
            visited[v] = true; // 현재 노드 방문 처리
            System.out.print(v + " "); // 방문노드 출력

            for(int i : graph[v]){ // 인접 노드 탐색
                if (visited[i]==false) dfs(i);
            }
        }

        public static void main(String[] args) {
//            System.out.println("어떻게 하면 내부 클래스 안의 main 메소드가 실행될까?");
            int start = 1; // 탐색 시작 노드
            System.out.print("재귀를 이용한 탐색 ver1, 간선 2차원 배열 >> ");
            dfs(start);
            System.out.println();
        }
    }

    // 재귀, LinkedList<Integer>
    public static class DFSByRecursionVer2{ // https://velog.io/@smallcherry/Java-AlgorithmBFSAndDFS

        public static void main(String[] args) {
            DFSByRecursionVer2 dfs = new DFSByRecursionVer2(9);
            // 간선을 2차원 배열로 표현, Node는 8개 Index 1~8
            int[][] graph = {{}, {2, 3, 8},{1, 7},{1, 4, 5},{3, 5}, {3, 4}, {7},{2, 6, 8},{1, 7}};

            // 2차월 배열 형태의 간선을 LinkedList로 변환
            for (int i = 1; i < graph.length; i++) {
                for(int j:graph[i]){
                    dfs.addEdge(i,j);
                }
            }

            System.out.print("재귀를 이용한 탐색 ver2, LinkedList >> ");
            dfs.DFS(1); // 1 노드부터 탐색 시작
            System.out.println();

        }

        private int V;
        private LinkedList<Integer>[] adj; // 링크드리스트의 배열

        // constructor
         DFSByRecursionVer2(int v){
            V = v;
            adj = new LinkedList[v]; // v개의 LinkedList 선언 및 생성
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w){ // v번째 LinkedList 에 w를 삽입
            adj[v].add(w);
        }

        void DFS(int v){ // v를 시작노드로
            boolean visited[] = new boolean[V]; // 각 노드의 방문 여부
            DFSUtil(v, visited);
        }

        void DFSUtil(int v, boolean visited[]){
            // 현재 노드 방문
            visited[v] = true;
            System.out.print(v + " ");

            // 방문한 노드와 인접한 모든 노드를 가져옴
            Iterator<Integer> it = adj[v].listIterator();
            while(it.hasNext()){
                int n = it.next();
                // 방문하지 않은 노드면 해당 노드에서 재귀
                if(!visited[n]) DFSUtil(n, visited);
            }
        }

    }

    public static class DFSByStackVer1{ // https://scshim.tistory.com/241
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

        public static void dfs(int start){
            visited[start] = true; // 시작 노드 방문 처리
            System.out.print(start + " "); // 방문 노드 출력

            Deque<Integer> stack = new LinkedList<>();
            stack.push(start); // 시작 노드를 스택에 입력

            while(!stack.isEmpty()){
                int now = stack.peek();

                boolean hasNearNode = false; // 방문하지 않은 인접 노드 확인
                for (int i:graph[now]){
                    if(!visited[i]){ // 방문하지 않았으면
                        hasNearNode = true;
                        stack.push(i);
                        visited[i] = true;
                        System.out.print(i + " "); // 방문 노드 출력
                        break; // 자식 노드를 모두 탐색-방문 하지 않고 Death First 가 되도록 한다.
                    }
                }
                // 방문하지 않은 인접 노드가 없는 경우 해당 노드 꺼내기
                if(hasNearNode == false) stack.pop();

            }

        }

        public static void main(String[] args) {
            System.out.print("Stack을 이용한 탐색 Ver1 >> ");
            dfs(1); // 1에서 탐색 시작
            System.out.println();
        }
    }


}
