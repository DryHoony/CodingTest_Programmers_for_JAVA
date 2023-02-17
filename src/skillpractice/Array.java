package skillpractice;

import programmers.level0.ArraySlice;
import programmers.level0.EmergencySetOrder;
import programmers.level0.Mode;
import programmers.level0.ReverseArray;

import java.util.Arrays;

public class Array {

    // 배열 Array
    // 배열은 한번 생성하면 크기 변경 불가

    // main 메소드 안에서 실행해야 오류 안남
//    int[] array = new int[3];
//    array[0] = 1;
//    array[2] = 2;
//    array[3] = 3;

    // 배열 생성
    int[] array = new int[] {1,2,3,4};
    int[] array0 = {1,2,3,4};

    // 이차원 배열 생성
    int[][] array1 = new int[3][4];
    int[][] array2 = new int[][]{{1},{2,3},{4,5,6}};
    int[][] array3 = {{1},{2,3},{4,5,6}};



    public static void main(StringSkill[] args) {

//        int[][] array = new int[][]{{1},{2,3},{4,5,6}};
////         for each 구문을 자주 사용
//        for(int[] i:array){
//            for(int j:i){
//                System.out.println(j);
//            }
//        }

        int[] array = {1,2,3,4,5,6,7,8,9};

        // 배열 기본 다루기
        int a = array[0]; // index에 해당하는 원소 출력

        // 검색, 원소에 해당하는 index 출력
        Integer[] arrayfind = {10,20,30,40,50}; // asList()는 래퍼 클래스만 허용
//        int[] array = {10,20,30,40,50}; // Integer[]말고 int[]형일때는 어떡할까?
//        String[] array = {"a","b","c"};
//        int i = Arrays.asList(arrayfind).indexOf(30); // 없으면 -1출력


        ArraySlice as = new ArraySlice(); // 배열 슬라이스, Arrays.copyOfRange(array, 시작index, 끝index)

        Arrays.sort(array); // 정렬(오름차순)
        ReverseArray reverseArray = new ReverseArray(); // 뒤집기, 정렬 후 사용하면 내림차순

        EmergencySetOrder setOrder = new EmergencySetOrder(); // 배열의 원소 (크기)순서 매기기

        // 배열의 복사
        int[] array1 = {1,3,5,7,9,2,4,6,8};
        int[] array2 = array1; // 얕은복사, 종속석이다

        // 깊은복사 4가지 방법
        // 1. Arrays.copyOf(복사할배열, 복사할길이)
        int[] array3 = Arrays.copyOf(array1,array1.length);
        int[] array4 = Arrays.copyOf(array1,5); // 특정길이까지만 복사 가능

        // 2. System.arraycopy(원본배열, 원본 복사시작 위치, 복사할 배열, 복사시작 위치, 복사할 요소의 개수)
        int[] array5 = new int[10];
        System.arraycopy(array1,5,array5,3,4);

        // 3. clone(), Cloneable을 구현해야 한다(but, 예외발생)
        int[] array6 = array1.clone(); // 예외발생 안하네,,?

        // 4. for문과 인덱스를 이용한 복사 (직접구현)
        int[] array7 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array7[i] = array1[i];
        }

        // 배열 통계치 연산
        int l = array.length;// 길이, 배열의 크기
        // 평균값
        Mode mode = new Mode();  // 최빈값
        // 최댓값, 최솟값





    }





}
