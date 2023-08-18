package programmers.highScoreKit.exhaustiveSearch;

import java.util.ArrayList;

public class Fatigue { // 피로도 - 다시다시!!
    // Brute-Force 이용 - dungeons.length <= 8 이므로 최대 8!(40320) 가짓수의 정렬에 대해 연산을 시행
    //

    static int f; // 연산용 피로도
    static int count=0; // clear 던전 수(연산용)
    static int max=0; // 최대 던전 수

    static ArrayList<Integer> index = new ArrayList<>(); // index 순서
    static ArrayList<ArrayList<Integer>> indexArray = new ArrayList<>(); // index 순서 array

    public static void main(String[] args) {
        int k = 80; // 초기 피로도
        int[][] dungeons = {{80,20},{50,40},{30,10}}; // [최소필요 피로도, 소모 피로도], 1~8개

        int l = dungeons.length;
        int[] index = new int[l];
        for (int i = 0; i < l; i++) {
            index[i]=i;
        }

        // 순열 - 연산
        permutation1(index, 0,l,l);
//        System.out.println("저장된 indexArray : " + indexArray);

        for(ArrayList<Integer> index0:indexArray){
            count = 0; // 던전수 초기화
            f = k; // 피로도 초기화

            // index0의 순서로 던전 연산
            for(int i:index0){
                if(f >= dungeons[i][0]){
                    f -= dungeons[i][1];
                    count ++;
                }
                else break;

            }

            if(count > max){
                max = count;
                if(max == l) break;
            }
        }

        System.out.println(max);
    }

    // 순열 메소드
    static void permutation1(int[] arr, int depth, int n, int r){
        // 재귀함수를 이용한다.
        if (depth == r){ // 종료조건
            // arr 출력
            index.clear(); // 초기화
            for (int i:arr){
//                System.out.print(i + " ");
                index.add(i);
            }
//            System.out.println();
//            System.out.println(index); // 여기까지 ok
//            indexArray.add(index); // 얘는 왜 이럴까? - 참조값이 같아서 문제인 걸까?
            indexArray.add((ArrayList<Integer>) index.clone());

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation1(arr, depth+1, n, r);
            swap(arr, depth, i);
            // swap한 케이스에 대해 재귀로 돌리고, 다른 swap연산을 하기 위해 원상복구
        }

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
