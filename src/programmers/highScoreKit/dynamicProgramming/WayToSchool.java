package programmers.highScoreKit.dynamicProgramming;

public class WayToSchool { // 등굣길

    public static void main(String[] args) { // 가로줄 ver
        int n = 3; //세로 1~100
        int m = 4; //가로 1~100
        int[][] puddles = {{2,2}}; // 물이 잠긴 지역 0~10

        // 연산용 변수
        int[][] map = new int[n+1][m+1]; // 초기값 0, index 는 m n 그대로
        map[1][1] = 1; // 집 출발

        // 웅덩이 할당 -1
        for(int[] p:puddles){
            map[p[0]][p[1]] = -1;
        }

        // 첫줄 연산
        for (int j = 2; j <= m; j++) {
            if(map[1][j] != -1){ // 웅덩이가 아니면
                map[1][j] = checkPuddle(map[1][j-1]);
            }
        }

        // 본 연산
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // map[i][j] 연산
                if(map[i][j] != -1) map[i][j] = (checkPuddle(map[i-1][j]) + checkPuddle(map[i][j-1]))%1000000007;
            }
        }

        System.out.println();
        System.out.println("전체 map 출력 확인");
        for (int[] arr:map){
            for(int a:arr) System.out.print(a +"  ");
            System.out.println();
        }
        System.out.println("답은 = "+ map[n][m]);


    }

    public static void main0(String[] args) { // 대각선 ver - 하나 빼고 다 틀림,,,ㅜㅜ
        int n = 3; //세로 1~100
        int m = 4; //가로 1~100
        int[][] puddles = {{2,2}}; // 물이 잠긴 지역 0~10

        // 연산용 변수
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
//                map[i][j] = checkPuddle(map[i-1][j]) + checkPuddle(map[i][j-1]);
                if(map[i][j] != -1) map[i][j] = (checkPuddle(map[i-1][j]) + checkPuddle(map[i][j-1])) % 1000000007;
            }
            System.out.println("다음 라인 >>");

        }


        System.out.println();
        System.out.println("전체 map 출력 확인");
        for (int[] arr:map){
            for(int a:arr) System.out.print(a +"  ");
            System.out.println();
        }
        System.out.println("답은 = "+ map[n][m]);
    }

    public static int checkPuddle(int x){
        if(x==-1) return 0;
        return x;
    }
}
