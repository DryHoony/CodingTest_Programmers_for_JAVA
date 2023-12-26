package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class NNumbersOfLCM { // N개의 최소공배수

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,90,57,80};

        // 연산용 변수
        ArrayList<Integer> primeArray = primeArray(100); // 100이하 소수
        int answer = 1;
        int l = arr.length;
        int pIndex = 0;
        int p;
        int pCnt;
        int pMaxCnt;

        // 연산
        Arrays.sort(arr);
        while ((arr[l-1]>1)){
            p = primeArray.get(pIndex);
            pMaxCnt = 0; // 초기화

            // p로 arr의 모든원소를 나누기
            for (int i = 0; i < l; i++) {
                pCnt=0;
                while (arr[i]%p==0){
                    arr[i] /= p;
                    pCnt++;
                }
                pMaxCnt = Math.max(pCnt, pMaxCnt);
            }
            answer *= (int)Math.pow(p,pMaxCnt);

            pIndex++;
            Arrays.sort(arr);
        }

        System.out.println("답은 = " + answer);
    }

    public static ArrayList<Integer> primeArray(int n){
        // 범위 n까지 에라토스테네스의 체
        ArrayList<Integer> pArray = new ArrayList<>();
        boolean isP;

        for (int i = 2; i < 100; i++) {
            isP = true;
            for (int p:pArray){
                if(i%p==0){
                    isP = false;
                    break;
                }
            }
            if(isP) pArray.add(i);
        }

        return pArray;
    }
}
