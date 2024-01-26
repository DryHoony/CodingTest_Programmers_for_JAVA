package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class MinimumMaking { // 최소값 만들기

    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        Arrays.sort(A);
        Arrays.sort(B);

        int l = A.length;
        int answer = 0;

        // 연산
        for (int i = 0; i < l; i++) {
            answer += A[i] * B[l-i-1];
        }


        System.out.println("답은 = " + answer);
    }

}
