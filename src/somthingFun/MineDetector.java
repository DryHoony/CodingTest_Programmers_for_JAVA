package somthingFun;

public class MineDetector { // 지뢰찾기

    public static void main(String[] args) {
        int n = 5; // 세로길이
        int m = 8; // 가로길이
        int mineCount = 10; // 지뢰 갯수
        boolean[][] mineMap = makeMineMap(n, m, mineCount);
        printMineMap(mineMap);
    }


    // 지뢰 찾기 맵 생성
    public static boolean[][] makeMineMap(int n, int m, int mineCount){

        boolean[][] mineMap = new boolean[n][m];
        int mineX, mineY;
        for (int i = 0; i < mineCount; i++) {
            mineX = (int)(Math.random()*n);
            mineY = (int)(Math.random()*m);

            while(!mineMap[mineX][mineY]){
                mineX = (int)(Math.random()*n);
                mineY = (int)(Math.random()*m);
            }
            mineMap[mineX][mineY] = true;
        }
        return mineMap;
    }

    // 지뢰 찾기 맵 출력
    public static void printMineMap(boolean[][] mineMap){
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
}
