package somthingFun;

public class MineDetector { // 지뢰찾기

    public static void main(String[] args) {
        int n = 15; // 세로길이
        int m = 20; // 가로길이
        int mineCount = 40; // 지뢰 갯수

        boolean[][] mineMap;
        if(mineCount > n*m){
            System.out.println("지뢰 갯수가 맵 크기보다 많습니다.");
            return;
        }
        mineMap = makeMineMap(n, m, mineCount);
        printMineMap(mineMap);

        int[][] mineAnswerMap = makeMineAnswerMap(mineMap);
        System.out.println();
        System.out.println();
        printMineAnswerMap(mineAnswerMap, mineMap);

    }


    // 지뢰 찾기 맵 생성
    public static boolean[][] makeMineMap(int n, int m, int mineCount){

        boolean[][] mineMap = new boolean[n][m];
        int mineX, mineY;
        for (int i = 0; i < mineCount; i++) {
            mineX = (int)(Math.random()*n);
            mineY = (int)(Math.random()*m);

            while(mineMap[mineX][mineY]){
                mineX = (int)(Math.random()*n);
                mineY = (int)(Math.random()*m);
            }
            mineMap[mineX][mineY] = true;
        }
        return mineMap;
    }

    // 지뢰 찾기 맵 출력
    public static void printMineMap(boolean[][] mineMap){
        System.out.println("<지뢰찾기 맵>");
        for (int i = 0; i < mineMap.length; i++) {
            for (int j = 0; j < mineMap[0].length; j++) {
                if(mineMap[i][j]){
                    System.out.print("X ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // 지뢰 찾기 정답 맵 생성
    public static int[][] makeMineAnswerMap(boolean[][] mineMap){
        int[][] mineAnswerMap = new int[mineMap.length][mineMap[0].length];
        for (int i = 0; i < mineMap.length; i++) {
            for (int j = 0; j < mineMap[0].length; j++) {
                if(mineMap[i][j]){
                    mineAnswerMap[i][j] = 0;
                }else{
                    mineAnswerMap[i][j] = countMine(mineMap, i, j);
                }
            }
        }
        return mineAnswerMap;
    }

    // 지뢰 갯수 세기 (근방)
    public static int countMine(boolean[][] mineMap, int x, int y){
        int count = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if(i < 0 || j < 0 || i >= mineMap.length || j >= mineMap[0].length){
                    continue;
                }
                if(mineMap[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    // 지뢰 찾기 정답 맵 출력
    public static void printMineAnswerMap(int[][] mineAnswerMap, boolean[][] mineMap){
        System.out.println("<지뢰찾기 정답 맵>");
        for (int i = 0; i < mineAnswerMap.length; i++) {
            for (int j = 0; j < mineAnswerMap[0].length; j++) {
                if(mineMap[i][j])  System.out.print("X ");
                else System.out.print(mineAnswerMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
