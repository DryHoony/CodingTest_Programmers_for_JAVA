package programmers.highScoreKit.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortUsedInJava {
    // 'array' 에 대해, 'List' 에 대해
    // 정렬(오름차순) , 역순정렬(내림차순)

    // Array 에 대한 정렬
    public static void main0(String[] args) {
        Integer[] IntegerArray = {3,4,5,6,79,20,4,63};

        Arrays.sort(IntegerArray);
        /*
        * Arrays.sort()
        * 오름차순 정렬, 원소가 Integer 인지 String 인지 중요X
        * 기본적으로 객체는 Comparable 이 구현되어 있음
        * int[] 형태도 사용가능
        * */

        Arrays.sort(IntegerArray, Collections.reverseOrder());
        /*
        * Collection.reverseOrder() 옵션추가로 내림차순 정렬
        * 단, int[]와 같은 형태는 안됨, Integer 등의 객체 타입이어야 한다.
        * */

        // Comparator 를 직접구현하여 정렬 순서를 정의,수정,조작 할 수 있다.
        Arrays.sort(IntegerArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // 오름차순(정렬의 default) 구조
//                return o2 - o1; // 내림차순 >> Collections.reverseOrder()를 쓰자
            }
        });


        String[] StringArray = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon"};

        Arrays.sort(StringArray);

        // 문자열 길이 순서로 정렬, Comparator 직접 구현
        Arrays.sort(StringArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

    }

    // List 에 대한 정렬
    public static void main(String[] args) {


    }


}
