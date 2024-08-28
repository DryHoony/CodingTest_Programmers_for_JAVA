package programmers.level2;

public class MatrixBorderRotation { // 행렬 테두리 회전하기

    public static void main(String[] args) {

        int rows; // 2~100
        int columns; // 2~100
        int[][] queries; // 1~10000
        int[] result; // 각 회전(query) 의 최솟값

        // 예시 1
        rows = 6;
        columns = 6;
        queries = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        result = new int[]{8, 10, 25};

//        // 예시 2
//        rows = 3;
//        columns = 3;
//        queries = new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
//        result = new int[]{1, 1, 5, 3};
//
//        // 예시 3
//        rows = 100;
//        columns = 97;
//        queries = new int[][]{{1,1,100,97}};
//        result = new int[]{1};

        solution(rows, columns, queries);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows + 1][columns + 1]; // index 1부터 시작 (query 의 index 와 매칭)
        // matrix 초기 할당
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = num++;
            }
        }

        // query(회전) 연산
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int leftTopStartValue = matrix[x1][y1]; // 초기값 저장
            int min = leftTopStartValue;

            // 반시계 방향으로 회전하면서 할당
            // 1. 왼쪽 밑으로
            for (int x = x1; x < x2 ; x++) {
                int y = y1;
                matrix[x][y] = matrix[x+1][y];
                if(matrix[x+1][y] < min) min = matrix[x+1][y];
            }

            // 2. 밑 오른쪽으로
            for (int y = y1; y < y2 ; y++) {
                int x = x2;
                matrix[x][y] = matrix[x][y+1];
                if(matrix[x][y+1] < min) min = matrix[x][y+1];
            }

            // 3. 오른쪽 위로
            for (int x = x2; x >x1 ; x--) {
                int y = y2;
                matrix[x][y] = matrix[x-1][y];
                if(matrix[x-1][y] < min) min = matrix[x-1][y];
            }

            // 4 위 왼쪽으로
            for (int y = y2; y > y1 ; y--) {
                int x = x1;
                matrix[x][y] = matrix[x][y-1];
                if(matrix[x][y-1] < min) min = matrix[x][y-1];
            }

            // 초기값 재할당
            matrix[x1][y1+1] = leftTopStartValue;

            answer[i] = min;
            System.out.println(i + "연산 최솟값 = "+min);
        }


        return answer;
    }


}
