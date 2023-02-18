package programmers.level0;

public class TwoDementionalArray {

    public int[][] solution(int[] num_list, int n) {
        int l = num_list.length/n;
        int[][] answer = new int[l][n];

        for(int i=0; i<l; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[n*i+j];
            }
        }


        return answer;

    }
}
