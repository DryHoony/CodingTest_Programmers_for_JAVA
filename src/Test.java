import java.util.*;

public class Test {

    // Map<,> 이용 ver - 주어진 값을 key 로 해당 index 를 value 에 담는다
    // 중복은 처리못함 - key 값이 겹치기에 중복 처리 X
    public static int[] rankArrange(int[] list){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (!map.containsKey(list[i]))
                map.put(list[i],i);
        }

        Integer[] keyList = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keyList); // 오름차순
        keyList = reverseIntArray(keyList); // 내림차순

        int[] answer = new int[list.length];
        // list 의 원소의 등수(큰 순서)에 해당하는 index 할당
        int i=1;
        for (int n:keyList){
            answer[map.get(n)] = i; // key 값에 해당하는 원소는 i등
            i++;
        }

        return answer;
    }

    public static Integer[] reverseIntArray(Integer[] list){
        int l = list.length;
        Integer[] answer = new Integer[l];

        for (int i = 0; i < l; i++) {
            answer[i] = list[l-1-i];
        }

        return answer;
    }

//    public static void main(String[] args) {
//        Map<String, Integer> num = new HashMap<>();
//        num.put("zero",0);
//        num.put("one",1);
//        num.put("two",2);
//        num.put("three",3);
//        num.put("four",4);
//        num.put("five",5);
//        num.put("six",6);
//        num.put("seven",7);
//        num.put("eight",8);
//        num.put("nine",9);
//
////        System.out.println(num.keySet()); // 어떤 순서일까?, hash 값인가?, 어떻게 바꿀까?(이용할까?)
////        System.out.println(num.values());
////        for (int i = 0; i < 10; i++) {
////            System.out.println(i+1 + "번째 원소 = " + num.values().toArray()[i]);
////        }
//
////        String[] keyList = num.keySet().toArray(new String[0]); // Array로 변환
//////        System.out.println(keyList);
////        Arrays.sort(keyList);
////        for (int i = 0; i < keyList.length; i++) {
////            System.out.println(keyList[i]);
////        }
//
//
//
//
//    }

    public static void main(String[] args) {
        int[] array = {9,3,4,1,7,6,2,8,5};
        int[] rank = rankArrange(array); // ok 잘 작동
        for (int i:rank){
            System.out.println(i);
        }

    }

    }





