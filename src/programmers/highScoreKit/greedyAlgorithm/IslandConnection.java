package programmers.highScoreKit.greedyAlgorithm;

public class IslandConnection { // 섬 연결하기
    // 어떻게 greedy 한 방법이 존재하지?
    // 완전탐색 아닐까?

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        // 연산용 변수
        int leastCost = 0; // 최소 비용



        System.out.println("답은 = " + leastCost);
    }
}
