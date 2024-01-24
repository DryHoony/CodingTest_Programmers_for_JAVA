package programmers.level2;

public class MatrixMultiple { // 행렬의 곱셈
    // 2차원 행렬의 곱을 반환
    // 행과 열의 길이는 2~100

    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};

        int i = arr1.length;
        int k = arr1[0].length;
        int j = arr2[0].length;
        int[][] answer = new int[i][j];

        // 연산
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < j; y++) {
                for (int z = 0; z < k; z++) {
                    answer[x][y] += arr1[x][z]*arr2[z][y];
                }
                System.out.println("x,y 값 = " + answer[x][y]);
            }
        }


        System.out.println("답은 = ");
    }
}
