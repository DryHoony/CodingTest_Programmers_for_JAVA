package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;

public class Graph { // 그래프 연습
    // G = (V,E)

    static int[][] edges = new int[][] {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 5}, {4, 5}};
    static int n = 5; // 정점의 갯수

    public static void AdjacentMatrix() { // 인접행렬 ver
        int[][] matrix = new int[n+1][n+1]; // Index 를 1~n까지 사용

        // 무향 그래프 - 가장 일반적인 형태, 대칭
        for(int[] edge : edges){
            matrix[edge[0]][edge[1]] = 1; // 연결되면 1 else 0
            matrix[edge[1]][edge[0]] = 1;
        }

        // 출력
        System.out.println("인접행렬 출력");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void AdjacentListVer1(){ // 인접 리스트 by 배열 + 리스트
        ArrayList<Integer>[] list = new ArrayList[n+1]; // array[] 의 원소가 List<Integer>
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for(int[] edge:edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        // 출력
        System.out.println("인접 리스트 출력 Ver1");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void AdjacentListVer2(){ // 인접 리스트 by 리스트 + 리스트
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        // 출력
        System.out.println("인접 리스트 출력 Ver2");
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AdjacentMatrix();
        AdjacentListVer1();
        AdjacentListVer2();

    }






}
