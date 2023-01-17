package programmers.level0;

import java.util.Arrays;

public class Mode { // 최빈값 구하기

    public int getMode(int[] array){ // array의 원소가 음이아닌 정수일때만 유효

        int arr_max = 0; // array의 최대값
        for(int i:array){
            if(i>arr_max){
                arr_max = i;
            }
        }

        int[] count = new int[arr_max + 1];
        for(int i:array){
            count[i]++;
        }
        // count 완성

        boolean overlap = false; // 최빈값 중복, true일경우 -1 리턴
        int mode = 0; // 최빈값
        int nCount = 0; //

        for(int i=0; i<count.length; i++){
            if(count[i]>nCount){
                mode = i;
                nCount = count[i];
                overlap = false;
            } else if (count[i]==nCount) {
                overlap = true;
            }
        }

        if(overlap){
            return -1;
        }

        return mode;

    }

    public int getMode2(int[] array){ //정렬을 이용
        Arrays.sort(array);

        boolean overlap = false; // 최빈값 중복 검사
        int mode = array[0]; // 최빈값
        int modeCount = 0; // 최빈값 후보의 count

        int caln = array[0]; // 연산숫자
        int calCount = 1; // 연산숫자 count

        for(int i=1; i<array.length; i++){ //i값이 1부터 시작함에 주의. lenght가 1인 array는 쓸 수 없다.
            if(array[i] == caln){ // 연속된 숫자가 나오면
                calCount++;
            } else if (array[i] > caln) { // 다음 숫자가 나오면

                // 최빈값 업데이트
                if(calCount > modeCount){
                    mode = caln;
                    modeCount = calCount;
                    overlap = false;
                } else if (calCount == modeCount) {
                    overlap = true;
                }

                // 연산숫자 리셋
                caln = array[i];
                calCount = 1;
            }
        }

        // for문을 끝내고 마지막 숫자가 cal에 기록된 후에 한번 최빈값 test한번 더 시행
        if(calCount > modeCount){
            mode = caln;
            modeCount = calCount;
            overlap = false;
        } else if (calCount == modeCount) {
            overlap = true;
        }

        if(overlap){
            return -1;
        }
        return mode;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4}; // -1
        int[] array2 = {1,1,1,1,3,5,5,5,5,5,5}; // 5
        int[] array3 = {1,2,2,2,3,4,6,7,1,2,4,1,6,1,1}; // 1
        int[] array4 = {5,1,2,5,4,5,7,6,3,5,5,9,52,5,2,4}; // 5

        Mode m = new Mode();

//        int answer = m.getMode(array2);
//        System.out.println(answer);
        System.out.println(m.getMode2(array1));
        System.out.println(m.getMode2(array2));
        System.out.println(m.getMode2(array3));
        System.out.println(m.getMode2(array4));

    }
}
