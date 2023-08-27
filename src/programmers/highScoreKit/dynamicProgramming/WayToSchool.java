package programmers.highScoreKit.dynamicProgramming;

public class WayToSchool { // 등굣길

    public static void main(String[] args) {
        int n = 3; //세로 1~100
        int m = 4; //가로 1~100
        int[][] puddles = {{2,2}}; // 물이 잠긴 지역 0~10

        // 연산용 변수
//        int count=0; // 최단경로의 갯수 1,000,000,007 로 나눈 나머지 (mod 를 언제 취할까?)
        int[][] map = new int[n+1][m+1]; // 초기값 0, index 는 m n 그대로
        map[1][1] = 1; // 집 출발

        // 웅덩이 할당 -1
        for(int[] p:puddles){
            map[p[0]][p[1]] = -1;
        }

        int j;
        // 본 연산
        for (int k = 3; k <= m+n; k++) {
            // i+j = k
            for (int i = 1; i < k; i++) {
                j = k-i;
                if(i>n || j>m) continue; // map 범위내 연산
                System.out.println("["+i+","+j+"] 연산");

            }
            System.out.println("다음 라인 >>");

        }


        System.out.println();
        System.out.println("전체 map 출력 확인");
        for (int[] arr:map){
            for(int a:arr) System.out.print(a +"  ");
            System.out.println();
        }
//        count = count%1000000007;
//        System.out.println("답은 = "+ count);
    }


}
