import java.util.*;

public class Test {


    public static void main(String[] args) {
        Map<String, Integer> num = new HashMap<>();
        num.put("zero",0);
        num.put("one",1);
        num.put("two",2);
        num.put("three",3);
        num.put("four",4);
        num.put("five",5);
        num.put("six",6);
        num.put("seven",7);
        num.put("eight",8);
        num.put("nine",9);

        System.out.println(num.keySet()); // 어떤 순서일까?, hash 값인가?, 어떻게 바꿀까?(이용할까?)
        System.out.println(num.values());

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i+1 + "번째 원소 = " + num.values().toArray()[i]);
//        }

        String[] keyList = num.keySet().toArray(new String[0]); // Array로 변환
//        System.out.println(keyList);
        Arrays.sort(keyList);
        for (int i = 0; i < keyList.length; i++) {
            System.out.println(keyList[i]);
        }




    }

    }





