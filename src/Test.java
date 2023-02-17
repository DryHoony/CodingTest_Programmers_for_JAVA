import programmers.level0.ReverseArray;


public class Test {

    public static void main(String[] args) {

//        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
//        int n = 2;
        int[] num_list = {100, 95, 2, 4, 5, 6, 18, 33, 948};
        int n = 3;

        int l = num_list.length/n;
        int[][] answer = new int[l][n];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[n*i+j];
            }

        }

        System.out.println();





    }

    


}
