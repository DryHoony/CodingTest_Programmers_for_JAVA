package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.Deque;
import java.util.LinkedList;

public class DFS { // DFS Example
    // 스택을 사용, 재귀를 사용

    public static void main(String[] args) {
        DFSByRecursionVer1.main(args);
        DFSByStackVer1.main(args);


    }

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
