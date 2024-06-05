package programmers.level2;

public class DoughnutAndHistogram { // 도넛과 막대 그래프
    // 크기 n에 대해
    // 도넛 모양 그래프 : n개 정점, n개 간선, 순회
    // 막대 모양 그래프 : n개 정점, n-1개 간선, 단반향
    // 8자 모양 그래프 : 2n+1개 정점, 2n+2개 간선



    public static void main(String[] args) {
        int[][] edges; // 길이 1~1,000,000 값 1~1,000,000
        int[] result;

        edges = new int[][]{{2,3},{4,3},{1,1},{2,1}}; // 간선정보
        result = new int[] {2,1,1,0}; // 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프 수, 8자 모양 그래프 수


        System.out.println(solution(edges));
    }

    public static int[] solution(int[][] edges){
        int[] answer = new int[4]; // // 생성정점, 도넛 그래프의 수, 막대 그래프 수, 8자 그래프 수

        // 순환 고리 찾기 >> 도넛 그래프
        // 순환 고리중 중복정점(출발,도착이 2번)존재 >> 8자 그래프

        // 단방향 연걸 >> 막대
        // 모든 순환 고리와, 막대에 연결된 정점 >> 생성정점

        return null;
    }
}
