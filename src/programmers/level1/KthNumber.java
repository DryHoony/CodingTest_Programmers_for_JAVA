package programmers.level1;

import java.util.Arrays;

public class KthNumber {

    public static int cutting(int[] array, int[] commands){
        int a = commands[0];
        int b = commands[1];

        int[] cut = new int[b-a+1];

        for (int i = 0; i < b-a+1; i++) {
            cut[i] = array[i+a-1];
        }

        Arrays.sort(cut);

        return cut[commands[2]-1];
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};

        System.out.println(cutting(array, new int[]{1,7,3}));
    }
}
