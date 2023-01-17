import java.util.Arrays;
import java.util.Collections;

public class ArraySkillPractice {


    public static void main(String[] args) {

        //생성
//        int[] array1 = new int[4];
//        array1[0] = 1;
//        array1[1] = 2;
//        array1[2] = 3;
//        array1[3] = 4;
//
//        int[] array2 = new int[]{1,2,3,4};
//        int[] array3 = {1,2,3,4};

        int[] array = {5,4,30,8,1};
        Arrays.sort(array); // 오름차순

        // 내림차순 정렬을 위해선 int[] >> Integer[] 로 boxing(Primitive자료형 -> Wrapper 클래스)이 필요하다.
        // 정렬 후 다시 int형 변환
        array = Arrays.stream(array)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        for (int i:array){
            System.out.println(i);
        }


    }
}
