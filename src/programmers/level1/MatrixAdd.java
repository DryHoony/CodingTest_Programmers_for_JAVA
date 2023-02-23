package programmers.level1;

public class MatrixAdd { // 행렬의 덧셈


    public static int[][] add(int[][] arr1, int[][] arr2){
        int r = arr1.length; //행크기
        int c = arr1[0].length; //열크기
        int[][] answer = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
