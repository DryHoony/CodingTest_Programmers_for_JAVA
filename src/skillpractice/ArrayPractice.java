package skillpractice;

import programmers.level0.ArraySlice;
import programmers.level0.EmergencySetOrder;
import programmers.level0.Mode;
import programmers.level0.ReverseArray;

import java.util.Arrays;

public class ArrayPractice {

    // 배열 Array
    // 배열은 한번 생성하면 크기 변경 불가

    // main 메소드 안에서 실행해야 오류 안남
//    int[] array = new int[3];
//    array[0] = 1;
//    array[2] = 2;
//    array[3] = 3;

    int[] array = new int[] {1,2,3,4};
    int[] array0 = {1,2,3,4};

    // 이차원 배열
    int[][] array1 = new int[3][4];
    int[][] array2 = new int[][]{{1},{2,3},{4,5,6}};
    int[][] array3 = {{1},{2,3},{4,5,6}};



    public static void main(String[] args) {

//        int[][] array = new int[][]{{1},{2,3},{4,5,6}};
        // for each 구문을 자주 사용
//        for(int[] i:array){
//            for(int j:i){
//                System.out.println(j);
//            }
//        }

        int[] array = {1,2,3,4,5,6,7,8,9};

        // 정렬(오름차순)
        Arrays.sort(array);

        // 최빈값 연산
        Mode mode = new Mode();

        // 뒤집기
        ReverseArray reverseArray = new ReverseArray();

        // 배열 슬라이스
        ArraySlice as = new ArraySlice();

        // 배열의 원소 순서 매기기
        EmergencySetOrder setOrder = new EmergencySetOrder();










    }





}
