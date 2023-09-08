package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ranking { // 순위
    // 위상 정렬(topology sorting) : 비순환 유향 그래프에의 Vertex 를 방향을 거스르지 않도록 나열하는 것

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        // 연산용 변수
        int count=0;
        int[][] mat = new int[n+1][n+1]; // 2차원 행렬이 필요- 이기면 1, 지면 -1

        // 초기 경로 할당
        for (int[] line:results){
            mat[line[0]][line[1]] = 1; // 이김
            mat[line[1]][line[0]] = -1; // 짐
        }

        // 중간고리 k기준 i-k-j 경로 연산
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(mat[i][k]==1 && mat[k][j]==1){
                        mat[i][j]=1;
                    } else if (mat[i][k]==-1 && mat[k][j]==-1) {
                        mat[i][j]=-1;
                    }
                }
            }
        }

        // 본인경로 및 mat[][0] index값 1 할당 >> 의미없는 숫자 연산피하기
        for (int i = 1; i <= n; i++) {
            mat[i][i] = 1;
            mat[i][0] = 1;
        }

        boolean flag;
        for (int i = 1; i <= n; i++) {
            flag = true;
            for (int x:mat[i]){
                if(x==0){
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }

        System.out.println("mat 출력확인 >>");
        for (int[] line:mat){
            for (int x:line){
                System.out.print(x + " ");
            }
            System.out.println();
        }

        System.out.println("답은 >> "+count);
    }


    public static void main0(String[] args) {
//        int n = 5;
//        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
//        int n=6; int[][] results = {{1,2},{1,3},{2,6},{6,5},{5,4}}; // 반례 test
        int n=7; int[][] results = {{5,1},{1,2},{1,3},{2,6},{6,7},{7,4}}; // 반례 test

        int answer = 0;

        // 그래프를 나타내기 위한 인접 행렬 초기화
        int[][] graph = new int[n][n];

        // 경기 결과를 그래프에 반영
        for (int[] result : results) {
            int winner = result[0] - 1; // 0-based index로 변환
            int loser = result[1] - 1;  // 0-based index로 변환
            graph[winner][loser] = 1;   // winner가 loser를 이긴 경우 1로 표시
            graph[loser][winner] = -1;  // loser가 winner에게 진 경우 -1로 표시
        }



        // 플로이드 와샬 알고리즘 응용
        for (int k = 0; k < n; k++) { // 중간 연결고리 >>
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) { // 이기는 연결고리
                        graph[i][j] = 1;  // i가 j를 이긴다.

                        // 연결 출력 테스트
                        System.out.println(i + "-"+ k+ "-" + j+ " 연결!!");
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) { // 지는 연결고리
                        graph[i][j] = -1; // i가 j에게 진다.
                    }

                }
            }
        }

        System.out.println("graph 출력 확인");
        for (int[] line:graph){
            for (int k:line) System.out.print(k + "   ");
            System.out.println(); // 다음줄
        }

        // 정확하게 순위를 매길 수 있는 선수의 수를 세기
        for (int i = 0; i < n; i++) {
            boolean canDetermineRank = true;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] == 0) { // i!=j 본인제외
                    canDetermineRank = false;
                    break;
                }
            }

            if (canDetermineRank) {
                answer++;
            }
        }

        System.out.println("정답은 >> "+ answer);

    }





}
