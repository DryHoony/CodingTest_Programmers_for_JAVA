package programmers.highScoreKit.GraphandDFSandBFS;

public class Graph { // 그래프 연습
    // G = (V,E)

    static int[][] edges = new int[][] {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 5}, {4, 5}};
    static int n = 5; // 정점의 갯수

    public static void AdjacentMatrix(int[][] edges) { // 인접행렬 ver
        int[][] matrix = new int[n+1][n+1]; // Index 를 1~n까지 사용

        // 무향 그래프 - 가장 일반적인 형태, 대칭
        for(int[] edge : edges){
            matrix[edge[0]][edge[1]] = 1; // 연결되면 1 else 0
            matrix[edge[0]][edge[1]] = 1;
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static void AdjacentList(int[][] edges){ // 인접 리스트
        // ver1 - 배열 + 리스트



        // ver2 - 리스트 + 리스트


    }

    public static void main(String[] args) {
        AdjacentMatrix(edges);


    }






}
