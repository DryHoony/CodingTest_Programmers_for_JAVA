import java.util.*;

public class Test {


    public static void main(String[] args) {
        Map<Integer,Integer> test = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            test.put(i,i);
        }

        // 반복문 조회중 제거 test
        // ConcurrentModificationException!!!
        Set<Integer> keySet = test.keySet(); // 지역변수로 분리
        for (int key:keySet){
            System.out.println("key = " + key);
            test.remove(key);
        }


        System.out.println(test.keySet());

    }





    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }

    public static String bracketTranslateReverse(String input){
        input = input.replaceAll("\\{","\\[");
        input = input.replaceAll("}","]");

        System.out.println(input);
        return input;
    }
}









